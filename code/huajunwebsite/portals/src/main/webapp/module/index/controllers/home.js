define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('HomeCtrl', ['$scope', function ($scope) {

        $(function () {

            $('#carousel-ad').carousel();
            $("#newsTicker1").ticker();

        });

    }]);
});