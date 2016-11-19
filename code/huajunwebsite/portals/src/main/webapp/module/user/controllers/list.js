define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    md.controller('UserListCtrl', ['$scope', '$uibModal', 'UserResource', '$pager', function ($scope, $uibModal, $userResource, $pager) {

        /**
         *  初始化分页对象
         */
        $scope.pager = $pager;

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
            $userResource.list(pager, function (data) {

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
            _.each($scope.pager.result, function (user) {
                user.checked = $scope.globalChecked;
            });
        };
        // ================ END ================
    }]);
});