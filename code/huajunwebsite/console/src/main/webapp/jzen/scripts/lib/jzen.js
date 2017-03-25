/**
 * Created by Bond(China)
 * bootstraps angular onto the window.document node
 */
define([
    'require',
    'angular',
    'jquery',
    'underscore',
    'angular-route',
    'angular-resource',
    '!root/.cnf',
    '!ui/.cnf',
    'device'
], function (require, ng, $, _, ngRoute, ngResource, cnf, uiCnf, device) {
    'use strict';

    window.isMobile = device.isMobile();
    /*window.isMobile = true;*/
    if (window.isMobile) {
        $("body").removeClass('layout-default').addClass("layout-mobile");
    }

    $(function () {

        var mds = ['app'];
        var cnfs = [];
        ng.copy(uiCnf, cnfs);

        _.each(cnf, function (md) {
            mds.push(md.name);
            cnfs.push(md.path + '/.cnf');
        });

        require(cnfs, function () {
            ng.bootstrap(document, mds);
        });

    }.bind(this));
});