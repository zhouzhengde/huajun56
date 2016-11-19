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
                method: 'post'
            },
            editpasswd: {
                url: 'api/user/editpasswd',
                method: 'post'
            }
        });
    }]);
});