define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'jquery-scrollbar'
], function ($, _, ng, md, jqScrollbar) {

    md.directive('uiScrollbar', [function () {
        return {
            restrict: "AC",
            scope: {
                uiScrollOptions: "="
            },
            link: function (scope, element, attrs) {

                if (/firefox/.test(navigator.userAgent.toLocaleLowerCase())) {
                    $(element).css({
                        "overflow": 'hidden'
                    });
                }

                element = $(element);

                scope.$watch("uiScrollOptions", function (newVal, oldVal) {

                    if (!element) {
                        return;
                    }
                    if (newVal && newVal.style) {
                        element.addClass(newVal.style);
                    } else {
                        element.addClass("scrollbar-macosx");
                    }
                    element.css({
                        "overflow": "hidden !important"
                    });
                    var opt = newVal;
                    /*console.log(element);*/
                    element.scrollbar(opt).on('$destroy', function () {
                        element.scrollbar('destroy');
                    });
                });
            }
        };
    }]);
});