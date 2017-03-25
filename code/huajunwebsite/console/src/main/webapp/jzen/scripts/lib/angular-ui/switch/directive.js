define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'text!ui/switch/tpl.html'
], function ($, _, ng, md, html) {

    md.directive('uiSwitch', function () {

        return {
            template: html,
            replace: false,
            restrict: 'AE',
            scope: {
                uiModel: '=',
                uiDisabled: "=",
                uiLabel: "="
            },
            controller: function ($scope) {

                $scope.uiModel = $scope.uiModel || false;
                $scope.doChange = function () {
                    if ($scope.uiDisabled)
                        return;
                    $scope.uiModel = !$scope.uiModel;
                };
            },

            link: function (scope, ele) {

            }
        };
    });
});