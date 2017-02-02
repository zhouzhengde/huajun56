/*
 * Copyright (c) 2015. Bond(China), java freestyle app
 */

require.config({
    urlArgs: 'v=0.0.1',
    baseUrl: 'jzen/scripts/lib',
    paths: {
        'angular-resource': 'angular/angular-resource',
        'angular-sanitize': 'angular/angular-sanitize',
        'angular-scenario': 'angular/angular-scenario',
        'angular-animate': 'angular/angular-animate',
        'angular-cookies': 'angular/angular-cookies',
        'angular-loader': 'angular/angluar-loader',
        'angular-touch': 'angular/angular-touch',
        'angular-route': 'angular/angular-route',
        'angular': 'angular/angular',
        "bootstrap": 'bootstrap/js/bootstrap',
        'jquery': 'jquery/jquery-2.1.4',
        "jquery-bootstrap": 'jquery/jquery.bootstrap.min',
        "jquery-plugins": 'jquery/jquery.plugins',
        "ui-bootstrap": 'angular/uibootstrap/ui-bootstrap-tpls',
        "flatui": 'flatui/js/flat-ui',
        'underscore': 'util/underscore',
        'device': 'util/device',
        'style': 'util/style-adjust',
        'jzen': 'jzen',
        'root': '../../../js',
        'app': '../../../js/.md',
        'module': '../../../module',
        'lib': '../../../jzen/scripts/lib'
    },
    map: {
        '*': {
            'css': 'css',
            'text': 'text'
        }
    },
    shim: {
        'jzen': {
            'deps': [
                'flatui'
            ]
        },
        'flatui': {
            'deps': [
                'bootstrap',
                'css!../lib/bootstrap/css/bootstrap',
                'css!../lib/fontawesome/css/font-awesome',
                'css!../lib/flatui/css/flat-ui',
                'css!../lib/iconfont/iconfont',
                'css!../../../css/common',
                'css!../../../css/function',
                'jquery',
                'device',
                'jquery-bootstrap',
                'jquery-plugins'
            ]
        },
        'bootstrap': {
            'deps': [
                'jquery'
            ]
        },
        'jquery-plugins': {
            'deps': [
                'jquery'
            ]
        },
        'jquery-bootstrap': {
            "deps": [
                'jquery',
                'bootstrap'
            ]
        },
        'ui-bootstrap': {
            "deps": [
                'css!../lib/angular/uibootstrap/ui-bootstrap-csp',
                'jquery',
                'bootstrap',
                'angular',
                'angular-animate',
                'angular-touch',
                'angular-route'
            ],
            exports: 'uiBootstrap'
        },
        'angular': {
            exports: "angular"
        },
        'angular-route': {
            deps: ['angular'],
            exports: 'ngRoute'
        },
        'angular-animate': {
            deps: ['angular'],
            exports: 'ngAnimate'
        },
        'angular-cookies': {
            deps: ['angular'],
            exports: 'ngCookies'
        },
        'angular-loader': {
            deps: ['angular'],
            exports: 'ngLoader'
        },
        'angular-resource': {
            deps: ['angular'],
            exports: 'ngResource'
        },
        'angular-sanitize': {
            deps: ['angular'],
            exports: 'ngSanitize'
        },
        'angular-touch': {
            deps: ['angular'],
            exports: 'ngTouch'
        }
    },
    deps: [
        'jzen'
    ]
});