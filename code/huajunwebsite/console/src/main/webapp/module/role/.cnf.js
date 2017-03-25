/**
 * Created by Lenovo on 2016/12/21.
 */

define(['./.md',
    './controllers/list',
    './controllers/add',
    './controllers/config',
    './controllers/update',
    './services/list',
    './services/resource'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/role', {
            templateUrl: 'module/role/views/list.html',
            controller: 'RoleListCtrl'
        }).when('/role/add', {
            templateUrl: 'module/role/views/add.html',
            controller: 'RoleAddCtrl'
        }).when('/role/update/:id', {
            templateUrl: 'module/role/views/update.html',
            controller: 'RoleUpdateCtrl'
        }).when('/role/config/:id/:name', {
            templateUrl: 'module/role/views/config.html',
            controller: 'RoleConfigCtrl'
        });
    }]);
});