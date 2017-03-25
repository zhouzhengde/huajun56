/**
 * Created by Lenovo on 2016/12/26.
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('RoleConfigCtrl', ['$scope', 'RoleResource', '$location', '$callback', "ResourceResource", "$routeParams", "$pager", "$timeout", function ($scope, $roleResource, $location, $callback, $resourceResource, $routeParams, $pager, $timeout) {

        $scope.roleId = $routeParams.id;
        $scope.roleName = $routeParams.name;
        $scope.permissionList = [];

        var findPermission = function (data) {

            for (var i = 0; i < $scope.permissionList.length; i++) {
                var per = $scope.permissionList[i];
                if (data.id == per.resourceId) {
                    return per;
                }
            }
            return {
                resourceId: data.id,
                resource: {
                    name: data.name
                },
                roleId: $scope.roleId,
                permissionObject: {
                    access: false,
                    query: false,
                    add: false,
                    modify: false,
                    delete: false
                }
            }
        };

        var setPermission = function (permission, removeFlag) {
            for (var i = 0; i < $scope.permissionList.length; i++) {
                var per = $scope.permissionList[i];
                if (permission.resourceId == per.resourceId) {
                    if (removeFlag) {
                        $scope.permissionList.splice(i, 1);
                    } else {
                        $scope.permissionList[i] = permission;
                    }
                    return;
                }
            }
            if (removeFlag) {
                return;
            }
            $scope.permissionList.push(permission);
            $scope.$apply();
        };

        function toggleChecked(data) {
            if (data.nodes != null && data.nodes.length > 0) {
                for (var i = 0; i < data.nodes.length; i++) {
                    $scope.allResConfig.orginal.treeview("toggleNodeChecked", [data.nodes[i].nodeId, {silent: false}]);
                }
            }
        }

        $scope.onChecked = function (event, data) {
            var res = findPermission(data);
            setPermission(res);
            $scope.$apply();
            toggleChecked(data);
        };

        function toggleUnChecked(data) {
            if (data.nodes != null && data.nodes.length > 0) {
                for (var i = 0; i < data.nodes.length; i++) {
                    $scope.allResConfig.orginal.treeview('uncheckNode', [data.nodes[i].nodeId, {silent: false}]);
                }
            }
        }

        $scope.onUnChecked = function (event, data) {
            var res = findPermission(data);
            setPermission(res, true);
            $scope.$apply();
            toggleUnChecked(data);
        };

        $scope.onSelected = function (event, data) {
            /*var res = findPermission(data);
             $scope.showChoosePermission = true;
             $scope.$apply();*/
        };

        $scope.onUnSelected = function (event, data) {
            /* $scope.showChoosePermission = false;
             $scope.$apply();*/
        };

        $scope.doCheckAll = function (item, value) {
            for (var attr in item.permissionObject) {
                item.permissionObject[attr] = value;
            }
        };

        $scope.doSave = function () {

            var params = ng.copy($scope.permissionList);
            for (var i = 0; i < params.length; i++) {
                var per = params[i];
                per.permissionObject.checkAll = undefined;
            }

            var callback = {
                before: function (data) {
                    if (data.status == 200) {
                        load();
                        $.messager.confirm($.messager.model.title.info, "保存成功！是否返回列表？", function () {
                            window.location.href = "#/role";
                        });
                        return false;
                    } else {
                        // 使用默认方式打印错误消息
                        return true;
                    }
                }
            };
            ng.extend($callback, callback);
            $roleResource.savePermissions(params, $callback.exec);
        };

        function loadPermission() {
            var pager = ng.copy($pager);
            pager.result = [];
            pager.pageSize = 65535;
            pager.condition.roleId = $scope.roleId;
            $roleResource.getPermissions(pager, function (data) {
                $scope.permissionList = data.result.result == null ? [] : data.result.result;

                for (var i = 0; i < $scope.permissionList.length; i++) {
                    var per = $scope.permissionList[i];
                    var nodes = $scope.allResConfig.orginal.treeview('search', [per.resource.name, {exactMatch: true}]);
                    $scope.allResConfig.orginal.treeview('toggleNodeChecked', [nodes[0].nodeId, {silent: true}]);
                }
                $scope.allResConfig.orginal.treeview('clearSearch');
            });
        };

        var load = function () {

            //获取所有资源信息
            $resourceResource.tree({}, function (data) {
                //需要处理当前角色是否已经拥有的权限资源
                $scope.allResConfig = {
                    data: data.result,
                    showCheckbox: true,
                    onNodeChecked: $scope.onChecked,
                    onNodeUnchecked: $scope.onUnChecked,
                    onNodeSelected: $scope.onSelected,
                    onNodeUnselected: $scope.onUnSelected
                };
                loadPermission();
            });
        };
        load();
        //=============END============
    }]);
});