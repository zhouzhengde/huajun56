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

    var md = ng.module('app', ['ngRoute', 'angular-ui', "ui.bootstrap", 'auth', 'index'])
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
           /* $authResource.islogin({}, function (data) {
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
            });*/

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
        });
    return md;
});