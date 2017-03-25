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
        };


        // var data1 = $.ajax({
        //     url: "http://localhost:9090/api/portals/order/latest/4",
        //     type: 'get',
        //     success: function(data, status, xhr) {
        //         alert(data);
        //     }
        // });

    }]);
});