/*
 * Copyright (c) 2015. Bond(China), java freestyle app
 */

define(['jquery'], function ($) {

    $(window).bind('resize', function () {
        //alert($(".ui-layout.content").height() + "," + $(window).height() );
        director();
    });

    var director = function () {
        if (!window.isMobile) {
            $("body").css({
                height: $(window).height()
            });
            $(".ui-layout-content").css({
                height: $(window).height() - 50 + "px"
            });
            $(".menu").css({
                height: $(window).height() - 126 + "px"
            });
        }
    };

    $(function () {
        director();
    });
});