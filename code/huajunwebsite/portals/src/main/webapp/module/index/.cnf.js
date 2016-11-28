/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/home'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/', {
            templateUrl: 'module/index/views/home.html',
            controller: 'IndexCtrl'
        }).otherwise({
            redirectTo: '/'
        });
    }]);
});