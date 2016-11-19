/*
 * Copyright (c) 2015. Bond(China), java freestyle app
 */

define([
    'angular',
    'jquery',
    'underscore',
    'angular-route',
    'ui-bootstrap',
    'js/menu.js',
    'jquery-bootstrap'
], function (ng, $, _, route, ui, menuList, jqboot) {
    'use strict';

    // 设置全局的alert 样式
    $.messager.model = {
        ok: {text: "确认", classed: 'btn-primary'},
        cancel: {text: "取消", classed: 'btn-warning'},
        title: {
            warn: "警告",
            info: "提示"
        }
    };

    var listMenu = {};

    var md = ng.module('app', ['ngRoute', 'angular-ui', "ui.bootstrap", 'auth', 'knowledge'])
        .controller('HeaderCtrl', ['$scope', "AuthResource", "$location", "$rootScope", function ($scope, $authResource, $location, $rootScope) {

            $scope.menuList = menuList;

            // 菜单选中
            $scope.doChangeMenu = function (menu, location) {

                if (menu) {
                    menu.active = true;
                }
                _.each(menuList, function (o) {
                    if (menu && menu.name !== o.name) {
                        o.active = false;
                    }
                    if (location) {
                        if (location.indexOf(o.href) != -1) {
                            o.active = true;
                        } else {
                            o.active = false;
                        }
                    }
                });
            };

            var doModifyLocation = function () {
                // 对菜单的状态进行修正
                var hash = window.location.hash == '';
                if (hash) {
                    $location.path($scope.menuList[0].href.substring(1));
                    $scope.doChangeMenu(undefined, $scope.menuList[0].href);
                } else {
                    $scope.doChangeMenu(undefined, window.location.hash);
                }
            };
            doModifyLocation();


            $rootScope.$on('$routeChangeStart', function (event, current, previous) {
                var hash = current.originalPath;
                if (hash && hash.indexOf("#") != 0) {
                    hash = "#" + hash;
                }
                $scope.doChangeMenu(undefined, hash);
            });

            // 登出
            $scope.doLogout = function () {
                $authResource.logout({}, function (data) {
                    if (data.status == 500) {
                        $.messager.alert("提示", data.message);
                    }
                    if (data.status == 200) {
                        window.location.href = "login.html#/login";
                    }
                });
            };

            //是否已经登入
            $authResource.islogin({}, function (data) {
                $rootScope.userInfo = {};
                if (data.status == 500) {
                    $.messager.alert("错误", data.message);
                    return;
                }
                if (data.status == 200 && data.result && !data.result.islogin) {
                    window.location.href = "login.html#/login";
                } else {
                    // 设置登入用户信息
                    $rootScope.userInfo = data.result.userInfo;
                }
            });

        }]).controller('FooterCtrl', ['$scope', function ($scope) {
            /*页脚*/

        }]).run(function ($rootScope, $templateCache) {

            $rootScope.isMobile = window.isMobile;
            $rootScope.$on('$routeChangeStart', function (event, current, previous) {
                if ($.isFunction(listMenu.$path) && current.$$route && current.$$route.originalPath) {
                    listMenu.$path("#" + current.$$route.originalPath);
                }
                if (typeof(current) !== 'undefined') {
                    $templateCache.remove(current.templateUrl);
                }
            });

        }).factory('$pager', function ($rootScope) {
            return {
                pageIndex: 0,
                pageSize: 5,
                condition: {},
                total: 0,
                previous: 0,
                next: 0,
                first: 1,
                last: 0,
                result: []
            };
        }).factory('$knowledgeTypeSet', function ($rootScope) {
            return [
                {
                    code: "1",
                    name: "茂业百货简介"
                },
                {
                    code: "2",
                    name: "员工管理"
                },
                {
                    code: "3",
                    name: "顾客服务"
                },
                {
                    code: "4",
                    name: "业务知识"
                }
            ];
        }).config(['$routeProvider', function ($routeProvider) {

        }]).filter("gender", function () {
            return function (inputValue, otherParams) {
                return inputValue == 1 ? '女' : '男';
            }
        }).filter("employerType", function () {
            return function (inputValue, otherParams) {
                switch (inputValue) {
                    case "10":
                        return " 内部员工";
                    case "20":
                        return "外部员工"
                    default:
                        return "未知";
                }
            }
        }).filter("roleType", function () {
            return function (inputValue, otherParams) {
                switch (inputValue) {
                    case "admin":
                        return " 管理员";
                    case "manager":
                        return "店长";
                    case "lmanager":
                        return "门店管理员";
                    case "zmanager":
                        return "店长助理";
                    case "sales":
                        return " 员工";
                    default:
                        return "未知";
                }
            }
        }).filter("levelType", function () {
            return function (inputValue, otherParams) {
                switch (inputValue) {
                    case "1":
                        return " 高级";
                    case "2":
                        return "中级";
                    case "3":
                        return "一般";
                    default:
                        return "未知";
                }
            }
        }).filter("validType", function () {
            return function (inputValue, otherParams) {
                switch (inputValue) {
                    case "1":
                        return " 可用";
                    case "0":
                        return "不可用";
                    default:
                        return "未知";
                }
            }
        });
    return md;
});