/**
 * Created by Lenovo on 2016/11/24.
 */
define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('RoleUpdateCtrl', ['$scope', 'RoleResource', '$location', '$routeParams', '$callback', 'RoleResource', function ($scope, $roleResource, $location, $routeParams, $callback, $roleResource) {

        $scope.role = {};
        /**
         * Load Data By Code
         */
        var load = function () {
            $roleResource.get({
                "id": $routeParams.id
            }, function (data) {
                if (data.status == 200) {
                    $scope.role = data.result;
                } else {
                    $.messager.alert($.messager.model.title.warn, data.message);
                }
            })
        };
        load();
        /**
         * To add new Role
         */
        $scope.doUpdate = function () {
            $scope.$broadcast('validator:validate', function (result) {

                if (result) {
                    var callback = {
                        before: function (data) {
                            if (data.status == 200) {
                                load();
                                $scope.$broadcast('validator:clear');
                                $.messager.confirm($.messager.model.title.info, "修改成功！是否返回列表？", function () {
                                    window.location.href = "#/role";
                                });
                                return false;
                            } else {
                                return true;
                            }
                        }
                    };
                    ng.extend($callback, callback);
                    $roleResource.update($scope.role, $callback.exec);
                }
            });

        };

        $scope.validator = {
            functions: {
                /*可追加客户化的函数验证*/
            },
            ajax: {
                "getByRoleName": {
                    "url": "api/role/name/exist",
                    "method": "post",
                    "alertText": "* 验证失败",
                    "alertTextLoad": "* 正在验证中，请稍候..."
                }
            }
        };
    }]);
});