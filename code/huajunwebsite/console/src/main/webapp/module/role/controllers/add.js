/**
 * Created by Lenovo on 2016/12/21.
 */
define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('RoleAddCtrl', ['$scope', 'RoleResource', '$location', '$callback', 'RoleResource', function ($scope, $roleResource, $location, $callback, $roleResource) {


        var load = function () {
            $scope.role = {};
        };
        load();


        $scope.doAdd = function () {
            $scope.$broadcast('validator:validate', function (result) {
                if (result) {
                    var callback = {
                        before: function (data) {
                            if (data.status == 200) {
                                load();
                                $scope.$broadcast('validator:clear');

                                $.messager.confirm($.messager.model.title.info, "添加成功！是否返回列表？", function () {
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
                    $roleResource.add($scope.role, $callback.exec);
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
        //=============END============
    }]);
});