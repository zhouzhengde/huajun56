/**
 * Created by Bond(China) on 2016/11/17.
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('EditPasswordCtrl', ['$scope', 'UserResource', '$user', '$callback', function ($scope, $userResource, $user, $callback) {

        $scope.user = {
            loginName: $user.loginName,
            userName: $user.userName,
            password: null,
            oldPassword: null,
            confirmPassword: null
        };

        $scope.doEdit = function () {
            $scope.$broadcast('validator:validate', function (result) {
                if (result) {
                    $.messager.confirm($.messager.model.title.info, "确认修改密码吗？", function () {
                        var callback = {
                            before: function (data) {
                                if (data.status == 200) {

                                    $scope.$broadcast('validator:clear');
                                    $.messager.confirm($.messager.model.title.info, "修改成功！是否返回？", function () {
                                        history.go(-1);
                                    });
                                    return false;
                                } else {
                                    return true;
                                }
                            }
                        };
                        ng.extend($callback, callback);
                        $userResource.editpasswd($scope.user, $callback.exec);
                    });
                }
            });
        };

        // 校验
        $scope.validator = {
            functions: {
                /*可追加客户化的函数验证*/
            },
            ajax: {}
        };

    }]);
});