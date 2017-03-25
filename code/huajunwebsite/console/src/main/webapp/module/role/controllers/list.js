/**
 * Created by Lenovo on 2016/12/21.
 */


define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('RoleListCtrl', ['$scope', 'RoleResource', '$location', '$pager', '$callback', function ($scope, $roleResource, $location, $pager, $callback) {

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
            $roleResource.list(pager, function (data) {

                if (data.status == 200) {
                    $scope.pager = data.result;
                } else {
                    $.messager.popup("系统错误!");
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
            _.each($scope.pager.result, function (role) {
                role.checked = $scope.globalChecked;
            });
        };

        /**
         * 删除
         * @param role
         */
        $scope.doDel = function (role) {

            $.messager.confirm($.messager.model.title.info, '确认删除吗？', function () {
                var callback = {
                    after: function (data) {
                        $scope.reload();
                    }
                };
                ng.extend($callback, callback);
                $roleResource.delete({"id": role.id}, $callback.exec);
            });
        };
        // ================ END ================

    }]);
});