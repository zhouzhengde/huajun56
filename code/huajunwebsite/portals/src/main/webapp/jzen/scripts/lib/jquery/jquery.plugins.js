/**
 * @summary: make more jquery plugins for jzen framework.
 * @author: Bond(China)
 */
define(['jquery', 'underscore'], function ($, _) {
    'restrict'

    var bool = function (configValue, defaultValue) {
        if (configValue != undefined && configValue == false) {
            return configValue;
        }
        return defaultValue;
    };

    $.fn.toggleGroup = function () {

        if ($(this).css('display') != null && $(this).css('display').indexOf('none') >= 0) {
            return;
        }

        var $lis = $(this).find(".toggle");
        $lis.bind('click', function () {
            if ($(this).hasClass("active")) {
                return;
            }
            var sibs = $(this).siblings();
            _.each(sibs, function (sib) {
                var target = $(sib).removeClass("active").attr('data-toggle');
                if (target) {
                    $(target).removeClass("show").addClass("hide");
                }
            });
            var target = $(this).addClass("active").attr('data-toggle');
            if (target) {
                $(target).removeClass("hide").addClass("show");
            }
        });

        $(this).find(".toggle.default").eq(0).trigger('click');
    };

    //-S 滚动插件
    $.fn.ticker = function (config) {
        config = config || {};
        var defaultConf = {
            start: bool(config.start, true),
            speed: config.speed || 20,//(ms)
            step: config.step || 1, //(px)
            hoverStop: bool(config.hoverStop, true),
            fromTo: config.fromTo || 'bottom-top', // bottom-top | right-left【没有实现】
            callback: config.callback || {}
        };
        var $root = $(this);
        var $li = $root.children("li");
        var height = $li.outerHeight() * $li.size();
        var interval = undefined;
        var obj = {
            // Manual to start
            start: function () {
                obj.stop();
                if (!defaultConf.start) {
                    return;
                }
                interval = setInterval(function () {
                    var top = parseInt($li.css('top')) - defaultConf.step;
                    $li.css({
                        top: top + "px"
                    });
                    if (top < -height) {
                        $li.css({
                            top: $root.height() + "px"
                        });
                    }
                }, defaultConf.speed);

            },
            // Manual to stop
            stop: function () {
                if (interval) {
                    clearInterval(interval);
                    interval = undefined;
                }
            }
        };

        $root.css({
            overflow: 'hidden'
        });
        $li.css({
            position: 'relative',
            top: "0px"
        });

        $li.bind('mouseover', function (event) {
            if (!defaultConf.hoverStop) {
                return;
            }
            obj.stop();
            if (defaultConf.callback.onHover) {
                defaultConf.callback.onHover(event, this);
            }
        }).bind('mouseout', function () {
            obj.start();
        }).bind('click', function (event) {
            if (defaultConf.callback.onClick) {
                defaultConf.callback.onClick(event, this);
            }
        });
        if (defaultConf.start) {
            obj.start();
        }
        return obj;
    };
    //-E 滚动插件


});
