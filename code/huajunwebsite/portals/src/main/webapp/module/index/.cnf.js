/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/home',
    './controllers/corp',
    './controllers/intro'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/index', {
            templateUrl: 'module/index/views/home.html',
            controller: 'HomeCtrl'
        }).when('/corp', {
            templateUrl: 'module/index/views/corp.html',
            controller: 'CorpCtrl'
        }).when('/intro', {
            templateUrl: 'module/index/views/intro.html',
            controller: 'IntroCtrl'
        }).otherwise({
            redirectTo: '/index'
        });
    }]);
});
