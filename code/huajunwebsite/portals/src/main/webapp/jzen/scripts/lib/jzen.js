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
], function (ng, $, _, ngRoute, ngResource, cnf, device, $jp) {
    'use strict';

    window.isMobile = device.isMobile();
    /*window.isMobile = true;*/
    if (window.isMobile) {
        $("body").removeClass('layout-default').addClass("layout-mobile");
    }
    $(function () {

        var mds = ['app'];
        var cnfs = [];
        //ng.copy(uiCnf, cnfs);

        _.each(cnf, function (md) {
            mds.push(md.name);
            cnfs.push(md.path + '/.cnf');
        });

        require(cnfs, function () {
            ng.bootstrap(document, mds);
        });

    }.bind(this));
});