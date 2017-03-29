/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/login',
    './services/resource'
], function (md) {
    'use strict';

    md.config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) {

        $routeProvider.when('/login', {
            templateUrl: 'module/auth/views/login.html',
            controller: 'LoginCtrl'
        });

        // $locationProvider.html5Mode(true);
    }]);
});