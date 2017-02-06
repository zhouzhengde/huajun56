define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('HomeCtrl', ['$scope', '$rootScope', function ($scope,$rootScope) {
        $(function () {

            $('#carousel-ad').carousel();
            $("#newsTicker1").ticker({start: true});

        });


        $scope.doHome = function () {
            $("#menu-navbar-collapse").removeClass("in");
        }

    }]);
});