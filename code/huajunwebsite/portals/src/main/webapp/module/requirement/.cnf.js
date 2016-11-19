/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define(['./.md',
    './controllers/list',
    './services/resource',
    './services/requirement'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/requirement', {
            templateUrl: 'module/requirement/views/list.html',
            controller: 'RequirementListCtrl'
        });
    }]);
});