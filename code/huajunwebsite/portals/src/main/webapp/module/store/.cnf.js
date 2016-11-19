/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/list',
    './services/resource',
    './services/list'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/store', {
            templateUrl: 'module/store/views/list.html',
            controller: 'StoreListCtrl'
        });
    }]);
});