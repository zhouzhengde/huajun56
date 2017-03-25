define(['jquery',
    'underscore',
    'angular',
    'treeview',
    '../.md'
], function ($, _, ng, treeView, md, html) {

    md.directive('uiTreeView', function () {

        return {
            replace: false,
            restrict: 'AE',
            scope: {
                uiConfig: '='
            },
            controller: function ($scope) {
            },

            link: function (scope, ele) {

                scope.$watch('uiConfig', function (newVal, oldVal) {
                    if (newVal) {
                        scope.uiConfig.orginal = $(ele).treeview(newVal);
                    }
                });
            }
        };
    });
});