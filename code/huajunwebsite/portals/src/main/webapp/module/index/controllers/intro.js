define([
    '../.md',
    'angular',
    'jquery',
    'underscore',
    'echarts',
    'echarts-map-china',
    './comp-scope-map',
    './comp-culture-canvas',
], function (md, ng, $, _, echarts, chinaMap, option, cultureCanvas) {

    md.controller('IntroCtrl', ['$scope', '$timeout', function ($scope, $timeout) {

        var myChart = undefined;
        var initMap = function () {
            if (myChart) {
                myChart.clear();
            }

            myChart = echarts.init(document.getElementById('echart-map-transform'));
            myChart.setOption(option);
        };
        initMap();
        $(window).on('resize', function () {
            initMap();
            cultureCanvas.draw();
        });


        $(function () {

            $(".menu-bar ul").toggleGroup();

            var cultureData = [
                {
                    text: "企业\n愿景",
                    content: "ddd",
                },
                {
                    text: "核心\n价值观",
                    content: "ccc",
                },
                {
                    text: "企业\n精神",
                    content: "ccc",
                },
                {
                    text: "经营\n理念",
                    content: "ccc",
                },
                {
                    text: "企业\n使命",
                    content: "eee",
                },
                {
                    text: "企业\n使命",
                    content: "eee",
                },
            ]

            cultureCanvas.init({
                dom: "#comp-culture-canvas",
                smallBlockOffset: 15,
                title: "华军\n物流",
                data: cultureData,
                firstBlockOffset : 0.0001

            });
            cultureCanvas.draw();
        });

        $scope.doJumpCulture = function () {
            cultureCanvas.draw();
        }
    }]);
});