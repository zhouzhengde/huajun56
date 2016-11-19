/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/list',
    './controllers/add',
    './services/resource',
    './services/list'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/knowledge', {
            templateUrl: 'module/knowledge/views/list.html',
            controller: 'KnowledgeListCtrl'
        }).when('/knowledge/add', {
            templateUrl: 'module/knowledge/views/add.html',
            controller: 'KnowledgeAddCtrl'
        });
    }]);
});