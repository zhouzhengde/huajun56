/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/list',
    './controllers/passwd',
    './services/resource',
    './services/user'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/user', {
            templateUrl: 'module/user/views/list.html',
            controller: 'UserListCtrl'
        }).when('/passwd', {
            templateUrl: 'module/user/views/passwd.html',
            controller: 'EditPasswordCtrl'
        });
    }]);
});