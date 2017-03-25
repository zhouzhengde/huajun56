/**
 * Created by Lenovo on 2016/12/21.
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {
    //与Service的主要区别在于，注入了$resource 提供者
    md.factory('RoleResource', ['$resource', function ($resource) {

        return $resource('', {}, {
            list: {
                url: 'api/role/list',
                method: 'post',
                isArray: false
            },
            add: {
                url: 'api/role',
                method: 'post',
                isArray: false
            },
            delete: {
                url: 'api/role/:id',
                method: 'delete',
                isArray: false
            },
            update: {
                url: 'api/role',
                method: 'put',
                isArray: false
            },
            get: {
                url: 'api/role/:id',
                method: 'get',
                isArray: false
            },
            getPermissions: {
                url: 'api/roleResource/list',
                method: 'post',
                isArray: false
            },
            savePermissions: {
                url: 'api/roleResource',
                method: 'post',
                isArray: false
            },
            limit: {
                url: 'api/role',
                method: 'get',
                isArray: false
            }
        });
    }]);
});