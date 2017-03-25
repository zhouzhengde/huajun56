/**
 * Created by Lenovo on 2016/12/19.
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('UserModifyCtrl', ['$scope', 'UserResource', '$location', '$callback', 'RoleResource', '$pager', 'StoreResource', '$routeParams', function ($scope, $userResource, $location, $callback, $roleResource, $pager, $storeResource, $routeParams) {

        var load = function () {

            $scope.user = {};
            $scope.companyList = [];
            $scope.storeList = [];
            $scope.brandStoreList = [];
            $scope.roleList = [];


            var params = ng.copy($pager);
            params.pageSize = 65535;
            $roleResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.roleList = data.result.result;
                }
            });
            $userResource.listCompany(params, function (data) {
                if (data.status == 200) {
                    $scope.companyList = data.result.result;
                }
            });

            $userResource.get({id: $routeParams.id}, function (data) {

                $scope.user = data.result;
                $scope.doChangeCompany($scope.user.companyCode)
            });
        };
        load();

        $scope.doChangeCompany = function (company) {
            if (!company) {
                return;
            }
            //$scope.user.storeCode = null;
            var params = ng.copy($pager);
            params.pageSize = 65535;
            params.condition.companyCode = company;
            params.condition.storeType = 0;
            $storeResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.storeList = data.result.result;
                    $scope.doChangeStore($scope.user.storeCode);
                }
            });
        };

        $scope.doChangeStore = function (store) {
            if (!store) {
                return;
            }
            var params = ng.copy($pager);
            params.pageSize = 65535;
            params.condition.parentCode = store;
            params.condition.storeType = 1;
            $storeResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.brandStoreList = data.result.result;
                }
            });
        };


        $scope.doUpdate = function () {
            $scope.$broadcast('validator:validate', function (result) {
                if (result) {
                    var callback = {
                        before: function (data) {
                            if (data.status == 200) {
                                load();
                                $scope.$broadcast('validator:clear');

                                $.messager.confirm($.messager.model.title.info, "修改成功！是否返回列表？", function () {
                                    window.location.href = "#/user";
                                });
                                return false;
                            } else {
                                // 使用默认方式打印错误消息
                                return true;
                            }
                        }
                    };
                    ng.extend($callback, callback);
                    $userResource.modify($scope.user, $callback.exec);
                }
            });
        };

        // 校验
        $scope.validator = {
            modify: true,
            functions: {
                /*可追加客户化的函数验证*/
            },
            ajax: {
                "getByUserCode": {
                    "url": "api/user/userCode/exist",
                    "alertText": "* 验证失败",
                    'extraData': function () {
                        return 'userId=' + $scope.user.id;
                    },
                    "alertTextLoad": "* 正在验证中，请稍候..."
                },
                "getByMobile": {
                    "url": "api/user/mobile/exist",
                    "alertText": "* 验证失败",
                    'extraData': function () {
                        return 'userId=' + $scope.user.id + '&brandCode=' + $scope.user.brandStore;
                    },
                    "alertTextLoad": "* 正在验证中，请稍候..."
                }
            }
        };

        //=============END============
    }]);
});