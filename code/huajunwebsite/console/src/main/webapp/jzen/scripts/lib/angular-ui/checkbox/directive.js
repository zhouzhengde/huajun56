define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'text!ui/checkbox/tpl.html'
], function ($, _, ng, md, html) {

    md.directive('uiCheckbox', function () {

        return {
            template: html,
            replace: false,
            restrict: 'AE',
            scope: {
                uiModel: '=',
                uiDisabled: "=",
                uiLabel: "=",
                uiChange: "&"
            },
            controller: function ($scope) {

                $scope.uiModel = $scope.uiModel || false;
                $scope.doChange = function () {
                    event.preventDefault();
                    if ($scope.uiDisabled)
                        return;
                    $scope.uiModel = !$scope.uiModel;
                    $scope.uiChange({value: $scope.uiModel});
                    event.stopPropagation();
                    return false;
                };
            },

            link: function (scope, ele) {

            }
        };
    });
});