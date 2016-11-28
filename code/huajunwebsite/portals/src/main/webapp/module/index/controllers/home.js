define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('IndexCtrl', ['$scope', function ($scope) {

        $(function () {

            $('#carousel-ad').carousel();
            $("#newsTicker1").ticker();
            $("#newsTicker2").ticker();
            $("#newsTicker3").ticker();
        });

    }]).controller('DevelopCtrl', ['$scope', function ($scope) {

        $scope.moduleName = "Welcome to Home Page!";

    }]);
});