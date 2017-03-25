/**
 * Created by Lenovo on 2016/12/26.
 */
define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.factory('ResourceTypeService', [function () {

        return {
            "list": [
                {
                    typeId: 0,
                    name: "菜单"
                },
                {
                    typeId: 1,
                    name: "选项资源"
                },
                {
                    typeId: 2,
                    name: "接口资源"
                }
            ]
            /* add more */
        };
    }]).filter("resourceType", function () {
        return function (inputValue, otherParams) {
            switch (inputValue) {
                case 0:
                    return "菜单";
                case 1:
                    return "选项资源";
                case 2:
                    return "接口资源";
            }
        }
    });
});