/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.factory('AuthResource', ['$resource', function ($resource) {

        return $resource('', {}, {
            login: {
                url: 'api/auth/login',
                method: 'post',
                isArray: false
            },
            logout: {
                url: 'api/auth/logout',
                method: 'get',
                isArray: false
            },
            islogin: {
                url: 'api/auth/islogin',
                method: 'get',
                isArray: false
            }
        });
    }]);
});