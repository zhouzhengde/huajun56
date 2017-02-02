/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    'angular',
    'app',
    '!module/index/.cnf'
], function (ng) {
    'use strict';

    var mds = ['app', 'index'];
    ng.bootstrap(document, mds);
});