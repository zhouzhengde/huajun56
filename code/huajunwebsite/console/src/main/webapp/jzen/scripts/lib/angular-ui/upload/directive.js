define(['jquery',
    'underscore',
    'angular',
    '../.md',
    'text!ui/upload/tpl.html',
    'text!ui/upload/choose.html'
], function ($, _, ng, md, html, chooseTpl) {

    md.directive('fileUpload', function () {

        return {
            template: html,
            replace: false,
            restrict: 'AE',
            scope: {
                ngUrl: '=',
                ngPreview: '=',
                ngMultiple: '=',
                ngDrag: '=',
                ngFilter: '&',
                ngCallbacks: '&'
            },
            controller: function ($scope, FileUploader) {

                $scope.ngPreview = ($scope.ngPreview != undefined && $scope.ngPreview == true) ? true : false;
                $scope.ngMultiple = ($scope.ngMultiple != undefined && $scope.ngMultiple == true) ? true : false;
                $scope.ngDrag = ($scope.ngDrag != undefined && $scope.ngDrag == true) ? true : false;

                var uploader = $scope.uploader = new FileUploader({
                    url: $scope.ngUrl
                });

                // FILTERS
                uploader.filters.push({
                    name: 'customFilter',
                    fn: function (item, options) {
                        if ($.isFunction($scope.ngFilter)) {
                            $scope.ngFilter(item, options);
                        }
                        return this.queue.length < 10;
                    }
                });
                // CALLBACKS
                uploader.onWhenAddingFileFailed = function (item, filter, options) {
                    if ($.isFunction($scope.ngCallbacks.onWhenAddingFileFailed)) {
                        $scope.ngCallbacks.onWhenAddingFileFailed(item, filter, options);
                    }
                };
                uploader.onAfterAddingFile = function (fileItem) {
                    if ($.isFunction($scope.ngCallbacks.onAfterAddingFile)) {
                        $scope.ngCallbacks.onAfterAddingFile(fileItem);
                    }
                };
                uploader.onAfterAddingAll = function (addedFileItems) {
                    if ($.isFunction($scope.ngCallbacks.onAfterAddingAll)) {
                        $scope.ngCallbacks.onAfterAddingAll(addedFileItems);
                    }
                };
                uploader.onBeforeUploadItem = function (item) {
                    if ($.isFunction($scope.ngCallbacks.onBeforeUploadItem)) {
                        $scope.ngCallbacks.onBeforeUploadItem(item);
                    }
                };
                uploader.onProgressItem = function (fileItem, progress) {
                    if ($.isFunction($scope.ngCallbacks.onProgressItem)) {
                        $scope.ngCallbacks.onProgressItem(fileItem, progress);
                    }
                };
                uploader.onProgressAll = function (progress) {
                    if ($.isFunction($scope.ngCallbacks.onProgressAll)) {
                        $scope.ngCallbacks.onProgressAll(progress);
                    }
                };
                uploader.onSuccessItem = function (fileItem, response, status, headers) {
                    if ($.isFunction($scope.ngCallbacks.onSuccessItem)) {
                        $scope.ngCallbacks.onSuccessItem(fileItem, response, status, headers);
                    }
                };
                uploader.onErrorItem = function (fileItem, response, status, headers) {
                    if ($.isFunction($scope.ngCallbacks.onErrorItem)) {
                        $scope.ngCallbacks.onErrorItem(fileItem, response, status, headers);
                    }
                };
                uploader.onCancelItem = function (fileItem, response, status, headers) {
                    if ($.isFunction($scope.ngCallbacks.onCancelItem)) {
                        $scope.ngCallbacks.onCancelItem(fileItem, response, status, headers);
                    }
                };
                uploader.onCompleteItem = function (fileItem, response, status, headers) {
                    if ($.isFunction($scope.ngCallbacks.onCompleteItem)) {
                        $scope.ngCallbacks.onCompleteItem(fileItem, response, status, headers);
                    }
                };
                uploader.onCompleteAll = function () {
                    if ($.isFunction($scope.ngCallbacks.onCompleteAll)) {
                        $scope.ngCallbacks.onCompleteAll();
                    }
                };
            },

            link: function (scope, ele) {
                // Todo
            }
        };
    }).directive('fileChoose', function () {
        return {
            replace: false,
            template: chooseTpl,
            restrict: 'AE',
            scope: {
                multiple: '=',
                uploader: '='
            },
            controller: function ($scope) {
                $scope.multiple = ($scope.multiple != undefined && $scope.multiple == true) ? true : false;
                $scope.doChoose = function (item) {
                    $(event.currentTarget).parent("div").children("input.file-upload-choose-btn").eq(0).trigger("click");
                }
            }
        };
    }).directive('ngThumb', ['$window', function ($window) {
        var helper = {
            support: !!($window.FileReader && $window.CanvasRenderingContext2D),
            isFile: function (item) {
                return angular.isObject(item) && item instanceof $window.File;
            },
            isImage: function (file) {
                var type = '|' + file.type.slice(file.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        };

        return {
            restrict: 'AE',
            template: '<canvas/>',
            link: function (scope, element, attributes) {
                if (!helper.support) return;

                var params = scope.$eval(attributes.ngThumb);

                if (!helper.isFile(params.file)) return;
                if (!helper.isImage(params.file)) return;

                var canvas = element.find('canvas');
                var reader = new FileReader();

                reader.onload = onLoadFile;
                reader.readAsDataURL(params.file);

                function onLoadFile(event) {
                    var img = new Image();
                    img.onload = onLoadImage;
                    img.src = event.target.result;
                }

                function onLoadImage() {
                    var width = params.width || this.width / this.height * params.height;
                    var height = params.height || this.height / this.width * params.width;
                    canvas.attr({width: width, height: height});
                    canvas[0].getContext('2d').drawImage(this, 0, 0, width, height);
                }
            }
        };
    }]);
});