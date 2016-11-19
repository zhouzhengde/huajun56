/*
 * Copyright (c) 2015. Bond(China), java freestyle app
 */

define(['jquery'], function ($) {
    $(window).bind('resize', function () {
        director();
    });

    var director = function () {
        if (!window.isMobile)
            $("body").css({
                height: $(window).height()
            });
    };

    $(function () {
        director();
    });
});