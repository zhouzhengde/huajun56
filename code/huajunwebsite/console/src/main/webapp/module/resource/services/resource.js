/**
 * Created by Lenovo on 2016/12/26.
 */
define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.factory('ResourceResource', ['$resource', function ($resource) {

        return $resource('', {}, {
            list: {
                url: 'api/resource/list',
                method: 'post',
                isArray: false
            },
            tree: {
                url: 'api/resource/tree',
                method: 'post',
                isArray: false
            },
            add: {
                url: 'api/resource',
                method: 'post',
                isArray: false
            },
            modify: {
                url: 'api/resource',
                method: 'put',
                isArray: false
            },
            get: {
                url: 'api/resource/:id',
                method: 'get',
                isArray: false
            }
        });
    }]);
});