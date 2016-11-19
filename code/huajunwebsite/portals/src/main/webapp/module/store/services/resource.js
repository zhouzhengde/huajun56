/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.factory('StoreResource', ['$resource', function ($resource) {

        return $resource('', {}, {
            list: {
                url: 'api/store/list',
                method: 'post',
                isArray: false
            }
        });
    }]);
});