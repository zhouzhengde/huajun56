define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('CorpCtrl', ['$scope', function ($scope) {

        $(function () {

            $(".menu-bar ul").toggleGroup();

        });

    }]);
});