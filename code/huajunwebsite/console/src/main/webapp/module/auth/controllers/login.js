/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('LoginCtrl', ['$scope', 'AuthResource', '$location', '$rootScope', "$cookieStore", function ($scope, $authResource, $location, $rootScope, $cookieStore) {

        $scope.user = {
            username: null,
            password: null
        }
        $scope.message = "";

        /**
         * 响应回车登入
         * @param event
         */
        $scope.doEnterKey = function (event) {
            if (event.keyCode == 13) {
                $scope.doLogin();
            }
        }

        /**
         * 登入
         */
        $scope.doLogin = function () {

            $authResource.login($scope.user, function (data) {
                if (data.status == 200) {
                    $scope.message = "";
                    window.location.href = "index.html";
                    $cookieStore.put("$$moi$$mypt$$user", data.result);
                } else {
                    $scope.message = data.message;
                }
            });
        };
    }]);
});