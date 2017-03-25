/**
 * Created by Lenovo on 2016/12/26.
 */
define(['./.md',
    './controllers/list',
    './controllers/add',
    './controllers/modify',
    './services/resource',
    './services/resourceTypeService'
], function (md) {
    'use strict';

    md.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/resource', {
            templateUrl: 'module/resource/views/list.html',
            controller: 'ResourceListCtrl'
        }).when('/resource/add',{
            templateUrl:'module/resource/views/add.html',
            controller:'ResourceAddCtrl'
        }).when('/resource/modify/:id',{
            templateUrl:'module/resource/views/modify.html',
            controller:'ResourceModifyCtrl'
        });
    }]);
});