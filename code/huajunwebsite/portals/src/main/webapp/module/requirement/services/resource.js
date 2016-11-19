/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.factory('RequirementResource', ['$resource', function ($resource) {

        return $resource('', {}, {
            list: {
                url: 'api/requirement/list',
                method: 'post'
            }
        });
    }]);
});