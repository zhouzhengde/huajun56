/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.factory('UserResource', ['$resource', function ($resource) {

        return $resource('', {}, {
            list: {
                url: 'api/user/list',
                method: 'post',
                isArray: false
            },
            editpasswd: {
                url: 'api/user/edit/pwd',
                method: 'post',
                isArray: false
            },
            add: {
                url: 'api/user',
                method: 'post',
                isArray: false
            },
            modify: {
                url: 'api/user',
                method: 'put',
                isArray: false
            },
            delete: {
                url: 'api/user/:id',
                method: 'delete',
                isArray: false
            },
            get: {
                url: 'api/user/:id',
                method: 'get',
                isArray: false
            },
            resetPassword: {
                url: 'api/user/reset/pwd/default/:id',
                method: 'put',
                isArray: false
            },
            listCompany: {
                url: 'api/company/list',
                method: 'post',
                isArray: false
            }
        });
    }]);
});