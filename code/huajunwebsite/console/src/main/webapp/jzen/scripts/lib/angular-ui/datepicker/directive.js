define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'text!ui/datepicker/tpl.html'
], function ($, _, ng, md, html) {

    md.directive('uiDatepicker', function () {

        return {
            template: html,
            replace: false,
            restrict: 'AE',
            scope: {
                uiModel: '=',
                uiDisabled: "=",
                uiLabel: "=",
                uiOptions: "="
            },
            controller: function ($scope) {

                var dateOptions = {
                    maxDate: new Date(2100, 12, 30),
                    startingDay: 1
                };

                $scope.options = $scope.uiOptions || dateOptions;

                $scope.disabled = $scope.uiDisabled || false;

                $scope.show = false;

                $scope.open = function (item) {
                    $scope.show = true;
                };
            },

            link: function (scope, ele) {

            }
        };
    });
});