define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('IntroCtrl', ['$scope', function ($scope) {

        $(function () {

            $(".menu-bar ul").toggleGroup();

        });

    }]);
});