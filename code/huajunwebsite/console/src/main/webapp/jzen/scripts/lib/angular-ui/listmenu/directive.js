define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'text!ui/listmenu/tpl.html'
], function ($, _, ng, md, html) {

    md.directive('uiListMenu', function () {

        return {
            replace: false,
            restrict: 'AE',
            scope: {
                uiConfig: '=',
                uiModel: '='
            },
            controller: function ($scope, $timeout, $interval) {

                $scope.doHref = function (href) {
                    location.href = href;
                };

                $scope.$on("menu:doDelayTrigger", function (event, func) {
                    $timeout(func, 20);
                });
            },

            link: function (scope, ele) {

                var defaultConf = {
                    animateTime: 400,
                    onNodeSelected: function (e, node) {
                        //console.log("default event!");
                    },
                    onUnNodeSelected: function (e, node) {
                        //console.log("default event!");
                    }
                };

                if(scope.uiConfig){
                    ObjectUtils.merge(scope.uiConfig, defaultConf);
                }

                var root = function (data) {
                    var $ul = $(html);
                    var li = $ul.html().toString();
                    for (var i = 0; i < data.length; i++) {
                        var item = data[i];
                        if(item.disabled){
                            continue;
                        }
                        var href = item.path || '#';
                        var $li = $(li.replace("#href", (href)).replace("#text", item.name).replace("#iconfont", item.iconfont || "fa")).appendTo($ul);
                        if (item.nodes && item.nodes.length > 0) {
                            $li.append(root(item.nodes)).children("p").on('click', function (e) {
                                if ($(this).hasClass("active")) {
                                    $(this).siblings().slideUp(scope.uiConfig['animateTime']);
                                    scope.uiConfig.onUnNodeSelected(e, item);
                                } else {
                                    $(this).siblings().slideDown(scope.uiConfig['animateTime']);
                                    scope.uiConfig.onNodeSelected(e, item);
                                }
                                $(this).toggleClass("active");
                            });
                        } else {
                            $li.addClass("leaf").find("label:last-child").removeClass("menu-arrow").addClass("menu-leaf");
                            $li.children("p").on('click', function (event) {
                                event.preventDefault();
                                var $all = $(this).parents('.menu').find(".menu-item");
                                for (var i = 0; i < $all.length; i++) {
                                    if ($all.eq(i).has(this).length == 0) {
                                        $all.eq(i).children('p').removeClass("active").siblings("ul").slideUp(scope.uiConfig['animateTime']);
                                    } else {
                                        var $p = $all.eq(i).children('p').eq(0);
                                        if (!$p.hasClass("active") && !$all.eq(i).hasClass("leaf")) {
                                            $p.trigger("click");
                                        }
                                    }
                                }
                                $(this).addClass("active");
                                /*没有返回值使用默认跳转*/
                                if (!scope.uiConfig.onNodeSelected(event, item)) {
                                    var rp = $(this).attr('data-real-href');
                                    if (rp && rp != '' && rp.indexOf("/") > 0) {
                                        $(this).attr('data-real-href', $(this).find('label[class=text]').attr("data-href"));
                                        location.href = rp;
                                    } else {
                                        location.href = $(this).find('label[class=text]').attr("data-href");
                                    }
                                }
                                event.stopPropagation();
                                return false;
                            });
                        }
                    }
                    $ul.children("li").eq(0).remove();
                    return $ul;
                };

                var path = function (path) {

                    var _jump = function () {
                        var arr = path.split("/");
                        var menuPath = arr[0] + "/" + arr[1];
                        if (menuPath.length <= 2) {
                            return;
                        }
                        var $menuItem = ele.find("label[data-href=\'" + menuPath + "\']").eq(0).parent();
                        if ($menuItem.html()) {
                            $menuItem.attr("data-real-href", path).trigger("click");
                        } else {
                            scope.$emit("menu:doDelayTrigger", _jump);
                        }
                    };
                    _jump();
                };

                scope.$watch('uiModel', function (newVal, oldVal) {
                    if (!newVal) {
                        return;
                    }
                    if (scope.uiConfig) {
                        ele.append(root(newVal));
                        $(window).trigger("resize");
                        var mod = window.location.hash || "#/index";
                        mod = mod.substring(0, mod.indexOf("?") > 0 ? mod.indexOf("?") : mod.length);
                        path(mod);
                        if ($.isFunction(scope.uiConfig['init'])) {
                            scope.uiConfig.init({
                                "$root": ele,
                                "$path": path
                            });
                        }
                    }
                });
            }
        };
    });
});