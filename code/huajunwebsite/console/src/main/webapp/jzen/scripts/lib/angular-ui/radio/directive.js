define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'text!ui/radio/tpl.html'
], function ($, _, ng, md, html) {

    md.directive('uiRadio', function () {

        return {
            template: html,
            replace: false,
            restrict: 'AE',
            scope: {
                uiModel: '=',
                uiConfig: '=',
                uiDisabled: "="
            },
            controller: function ($scope, $pager) {

                $scope.doCheck = function (item) {
                    $scope.uiModel = item.value;
                };

                $scope.uiModel = $scope.uiModel || $scope.uiConfig.options[0].value;
            },

            link: function (scope, ele) {
                // Todo
            }
        };
    });
});