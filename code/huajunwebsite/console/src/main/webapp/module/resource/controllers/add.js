/**
 * Created by Lenovo on 2016/12/26.
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('ResourceAddCtrl', ['$scope', 'ResourceResource', '$location', '$callback', "$pager", "ResourceTypeService", function ($scope, $resourceResource, $location, $callback, $pager, $resourceTypeService) {

        var load = function () {
            $scope.resourceTypeList = $resourceTypeService.list;
            $scope.resource = {};
            var params = ng.copy($pager);
            params.pageSize = 65535;
            $resourceResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.resourceList = data.result.result;
                }
            });
        };
        load();

        $scope.doAdd = function () {

            $scope.$broadcast('validator:validate', function (result) {
                if (result) {
                    var callback = {
                        before: function (data) {
                            if (data.status == 200) {
                                load();
                                $scope.$broadcast('validator:clear');

                                $.messager.confirm($.messager.model.title.info, "添加成功！是否返回列表？", function () {
                                    window.location.href = "#/resource";
                                });
                                return false;
                            } else {
                                return true;
                            }
                        }
                    };
                    ng.extend($callback, callback);
                    $resourceResource.add($scope.resource, $callback.exec);
                }
            });
        };

        // 校验
        $scope.validator = {
            functions: {},
            ajax: {}
        };
        // =============END============
    }]);
});