/**
 * Created by Lenovo on 2016/12/26.
 */
define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('ResourceListCtrl', ['$scope', 'ResourceResource', '$location', '$pager', '$callback', "ResourceTypeService", function ($scope, $resourceResource, $location, $pager, $callback, $resourceTypeService) {

        $scope.resourceTypeList = $resourceTypeService.list;
        /**
         *  初始化分页对象
         */
        $scope.pager = ng.copy($pager);

        /**
         * 加载列表数据
         */
        $scope.reload = function (pager, pageIndex) {
            if (!pager) {
                pager = $scope.pager;
            }
            pager = ng.copy(pager);
            pager.result = [];
            if (pageIndex) {
                pager.pageIndex = pageIndex;
            }
            /*pager.pageSize = 65535;*/
            $resourceResource.list(pager, function (data) {

                if (data.status == 200) {
                    $scope.pager = data.result;
                } else {
                    $.messager.popup("系统错误!");
                }
            });

            var params = ng.copy($pager);
            params.pageSize = 65535;
            $resourceResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.resourceList = data.result.result;
                }
            });
        };
        $scope.reload();
        /**
         * 选择所有或取消全选
         */
        $scope.globalChecked = false;
        $scope.doCheckAll = function () {
            $scope.globalChecked = !$scope.globalChecked;
            _.each($scope.pager.result, function (menu) {
                menu.checked = $scope.globalChecked;
            });
        };
        /**
         * 删除
         * @param role
         */

        // ================ END ================
    }]);
});