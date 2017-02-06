define([
    '../.md',
    'angular',
    'jquery',
    'underscore',
    'echarts'
], function (md, ng, $, _, echarts) {

    md.controller('CorpCtrl', ['$scope', function ($scope) {

        $(function () {

            $(".menu-bar ul").toggleGroup();

        });




    }]);
});