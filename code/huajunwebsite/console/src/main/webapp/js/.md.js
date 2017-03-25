/*
 * Copyright (c) 2015. Bond(China)
 */

define([
    'angular',
    'jquery',
    'underscore',
    'angular-route',
    'angular-route',
    'ui-bootstrap',
    'jquery-bootstrap',
    'angular-cookies'
], function (ng, $, _, route, ui, jqboot) {
    'use strict';

    // 设置全局的alert 样式
    $.messager.model = {
        ok: {text: "确认", classed: 'btn-primary'},
        cancel: {text: "取消", classed: 'btn-warning'},
        title: {
            warn: "警告",
            info: "提示",
            error: "错误"
        }
    };

    var listMenu = {};

    var md = ng.module('app', ['ngRoute', 'angular-ui', "ui.bootstrap", 'auth', 'knowledge', 'ngCookies'])
        .controller('MenuCtrl', ['$scope', "AuthResource", "$user", function ($scope, $authResource, $user) {


            if (!$user.role) {
                return;
            }

            $scope.menuConf = {
                animateTime: 400,
                init: function (_listMenu) {
                    listMenu = _listMenu;
                }
            };

            $authResource.menuList({}, function (data) {
                $scope.menuData = data.result;
            });

            $scope.controlText = "取消固定"
            $scope.doHide = function () {
                if ($scope.controlText == "取消固定") {
                    $scope.controlText = "固定"
                    $("body").addClass("flex-zoom");
                } else {
                    $scope.controlText = "取消固定"
                    $("body").removeClass("flex-zoom");
                }
            };
        }])
        .controller('HeaderCtrl', ['$scope', "AuthResource", "$location", "$rootScope", "$cookieStore", function ($scope, $authResource, $location, $rootScope, $cookieStore) {

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
            }
        }]).controller('FooterCtrl', ['$scope', function ($scope) {
            /*页脚*/
        }]).run(function ($rootScope, $templateCache, $timeout, $log, $location, $user) {

            $rootScope.isMobile = window.isMobile;
            $rootScope.$on("$locationChangeStart", function (event, url) {

            });

            $rootScope.$on('$routeChangeStart', function (event, current, previous) {

                var _path = function () {
                    if ($.isFunction(listMenu.$path) && current.$$route && current.$$route.originalPath) {

                        var path = current.$$route.originalPath;
                        for (var param in current.params) {

                            path = path.replace(":" + param, current.params[param]);
                        }
                        listMenu.$path("#" + path);
                    }
                    if (current) {
                        $templateCache.remove(current.templateUrl);
                    }
                };
                _path();
            });
        }).factory('$pager', function ($rootScope) {
            var pager = {
                pageIndex: 0,
                pageSize: 10,
                condition: {},
                total: 0,
                previous: 0,
                next: 0,
                first: 1,
                last: 0,
                result: []
            };
            return ng.copy(pager);
        }).factory('$user', ["$http", "$q", "AuthResource", "$rootScope", "$cookieStore", function ($http, $q, $authResource, $rootScope, $cookieStore) {

            var loginUrl = "login.html#/login";
            if ($rootScope.userInfo) {
                return ng.copy($rootScope.userInfo);
            }
            $rootScope.userInfo = {};
            $.ajax({
                url: "api/auth/islogin?mt=" + Math.random(),
                async: false,
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (data.status == 200 && data.result && data.result.islogin) {
                        if (data.result.userInfo) {
                            $rootScope.userInfo = data.result.userInfo;
                        } else {
                            $.messager.alert($.messager.model.title.error, "没有权限！");
                            window.location.href = loginUrl;
                        }
                    } else {
                        window.location.href = loginUrl;
                    }
                },
                error: function (data) {
                    window.location.href = loginUrl;
                }
            });

            return ng.copy($rootScope.userInfo);
        }]).factory('$disabledType', function ($rootScope) {

            return [
                {
                    code: false,
                    name: "启用"
                },
                {
                    code: true,
                    name: "禁用"
                }
            ]
        }).factory('$cardType', function ($rootScope) {
            return [
                {
                    code: "1",
                    name: "金卡"
                },
                {
                    code: "2",
                    name: "普卡"
                },
                {
                    code: "3",
                    name: "无卡"
                }
            ]
        }).factory('$gender', function ($rootScope) {
            return [
                {
                    code: "0",
                    name: "男"
                },
                {
                    code: "1",
                    name: "女"
                },

            ]
        }).factory('$callback', function ($rootScope) {
            var obj = {
                before: function (data) {
                    return true;
                },
                after: function (data) {
                    return true;
                },
                exec: function (data) {
                    if (!obj.before(data)) {
                        return;
                    }
                    if (data.status == 200) {
                        $.messager.alert($.messager.model.title.info, "操作成功！");
                    } else {
                        $.messager.alert($.messager.model.title.error, data.message);
                    }
                    obj.after(data);
                }
            };
            return obj;
        }).config(['$routeProvider', function ($routeProvider) {

        }]).filter("gender", function () {
            return function (inputValue, otherParams) {
                return inputValue == 1 ? '女' : '男';
            }
        }).filter("idType", function () {
            return function (inputValue, otherParams) {
                return inputValue == 1 ? '身份证' : '护照'
            }
        }).filter("disabledType", function () {
            return function (inputValue, otherParams) {
                switch (inputValue) {
                    case false:
                        return " 启用";
                    case true:
                        return "禁用";
                }
            }
        }).filter("cardType", function () {
            return function (inputValue, otherParams) {
                switch (inputValue) {
                    case 1:
                        return "金卡";
                    case 2:
                        return "普卡";
                    case 3:
                        return "无卡"
                }
            }
        }).filter("nodesString", function () {
            return function (inputValue, key, split) {
                var rs = "";
                if ($.isArray(inputValue)) {
                    _.each(inputValue, function (o) {
                        rs += o[key] + split;
                    });
                    return rs.substring(0, rs.length - 1);
                } else {
                    return inputValue;
                }
            }
        });
    return md;
});