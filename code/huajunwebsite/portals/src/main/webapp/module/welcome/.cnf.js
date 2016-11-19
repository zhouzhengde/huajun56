/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/welcome'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/', {
            templateUrl: 'module/welcome/views/welcome.html',
            controller: 'WelcomeCtrl'
        }).otherwise({
            redirectTo: '/'
        });
    }]);
});