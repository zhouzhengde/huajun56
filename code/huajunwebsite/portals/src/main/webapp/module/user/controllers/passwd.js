/**
 * Created by Bond(China) on 2016/11/17.
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('EditPasswordCtrl', ['$scope', '$rootScope', 'UserResource', function ($scope, $rootScope, $userResource) {

        $scope.user = {
            login_name: $rootScope.userInfo.login_name,
            name: $rootScope.userInfo.name,
            password: null,
            spare_1: null,
            spare_2: null
        };

        $scope.doEdit = function () {

            $.messager.confirm($.messager.model.title.info, "确认修改密码吗？", function () {
                // 执行修改
                $userResource.editpasswd($scope.user, function (data) {
                    $.messager.alert($.messager.model.title.info, data.message);
                });
            });
        };
    }]);
});