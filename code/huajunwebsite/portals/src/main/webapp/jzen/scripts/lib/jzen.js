/**
 * Created by Bond(China)
 * bootstraps angular onto the window.document node
 */
require([
    'angular',
    'jquery',
    'underscore',
    'angular-route',
    'angular-resource',
    '!root/.cnf',
    'device',
    'jquery-plugins'
], function (ng, $, _, ngRoute, ngResource, cnf, device) {
    'use strict';

    window.isMobile = device.isMobile();
    if (window.isMobile) {
        $("body").removeClass('layout-default').addClass("layout-mobile");
    }
});