define(['jquery',
    'underscore',
    'angular',
    '../.md'
], function ($, _, ng, md) {

    md.directive('ngValidator', function () {

        return {
            replace: true,
            restrict: 'AE',
            scope: {
                'validatorConfig': "="
            },
            controller: function ($scope, $timeout) {

                $scope.$on('validator:validate', function (event, callback) {

                    if ($.isFunction(callback)) {
                        callback($scope.doValidate());
                    }
                });

                $scope.$on('validator:hide', function (event, ele) {
                    if (ele) {
                        $(ele).validationEngine('hide');
                    } else {
                        $scope.doHide();
                    }
                });
                $scope.$on('validator:clear', function (event, ele) {
                    $scope.doClear();
                });
            },
            link: function (scope, ele) {

                if (scope.validatorConfig && $.isPlainObject(scope.validatorConfig.ajax)) {
                    for (var item in scope.validatorConfig.ajax) {
                        $.validationEngineLanguage.allRules[item] = scope.validatorConfig.ajax[item];
                    }
                }

                var functions = {};
                if (scope.validatorConfig) {
                    functions = scope.validatorConfig.functions;
                }
                $(ele).validationEngine('attach', {
                    promptPosition: 'bottomLeft:0, 12',
                    focusFirstField: false,
                    addSuccessCssClassToField: 'correct',
                    addFailureCssClassToField: 'incorrect',
                    customFunctions: functions
                });

                scope.doValidate = function () {
                    $(ele).find('select').removeClass("correct");
                    return $(ele).validationEngine("validate");
                };

                scope.doHide = function () {
                    return $(ele).validationEngine("hide");
                };
                scope.doClear = function () {
                    return $(ele).validationEngine("clear");
                };

                setTimeout(function () {
                    if (scope.validatorConfig.modify) {
                        $(ele).find("input").each(function (index, ele) {
                            var clz = $(ele).attr("class");
                            if (clz.indexOf('required') > 0) {
                                $(ele).addClass('correct');
                            }
                        });

                        $(ele).find("select").each(function (index, ele) {
                            var clz = $(ele).attr("class");
                            if (clz.indexOf('required') > 0) {
                                $(ele).addClass('correct');
                            }
                        });
                    }
                }.bind(this), 200);
            }
        };
    }).directive('ngValid', function () {

        return {
            replace: true,
            restrict: 'AE',
            scope: {},
            controller: function ($scope) {

            },
            link: function (scope, ele) {
                $(ele).addClass($(ele).attr('ng-valid')).bind('focus', function () {
                    $(this).validationEngine("hide");
                });
            }
        };
    });
});