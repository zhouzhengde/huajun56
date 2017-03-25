/**
 * Created by Lenovo on 2016/12/19.
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('UserAddCtrl', ['$scope', 'UserResource', '$location', '$callback', 'RoleResource', '$pager', 'StoreResource', function ($scope, $userResource, $location, $callback, $roleResource, $pager, $storeResource) {

        var load = function () {
            $scope.user = {
                gender: 0,
                disabled: false
            };
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
        };
        load();

        $scope.doChangeCompany = function (company) {
            if (!company) {
                return;
            }
            $scope.user.storeCode = null;
            var params = ng.copy($pager);
            params.pageSize = 65535;
            params.condition.companyCode = company;
            params.condition.storeType = 0;
            $storeResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.storeList = data.result.result;
                }
            });
        };

        $scope.doChangeStore = function (store) {
            if (!store) {
                return;
            }
            $scope.user.brandStore = null;
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


        $scope.doAdd = function () {
            $scope.$broadcast('validator:validate', function (result) {
                if (result) {
                    var callback = {
                        before: function (data) {
                            if (data.status == 200) {
                                load();
                                $scope.$broadcast('validator:clear');

                                $.messager.confirm($.messager.model.title.info, "添加成功！是否返回列表？", function () {
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
                    $userResource.add($scope.user, $callback.exec);
                }
            });
        };

        // 校验
        $scope.validator = {
            functions: {
                /*可追加客户化的函数验证*/
            },
            ajax: {
                "getByUserCode": {
                    "url": "api/user/userCode/exist",
                    "alertText": "* 验证失败",
                    "alertTextLoad": "* 正在验证中，请稍候..."
                },
                "getByMobile": {
                    "url": "api/user/mobile/exist",
                    'extraData': function () {
                        if ($scope.user.brandStore) {
                            return 'brandCode=' + $scope.user.brandStore;
                        }
                        return null;
                    },
                    "alertText": "* 验证失败",
                    "alertTextLoad": "* 正在验证中，请稍候..."
                }
            }
        };

        //=============END============
    }]);
});