define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'text!ui/loading/tpl.html'
], function ($, _, ng, md, html) {

    md.directive('uiLoading', function () {

        return {
            template: html,
            replace: false,
            restrict: 'AE',
            scope: {
                uiShow: '='
            },
            controller: function ($scope) {

                $scope.uiShow = $scope.uiShow || false;
            },

            link: function (scope, ele) {

            }
        };
    });
});