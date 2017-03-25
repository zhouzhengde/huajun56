define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('UserListCtrl', ['$scope', '$uibModal', 'UserResource', '$location', '$pager', '$callback', '$timeout', 'StoreResource', 'RoleResource', '$disabledType', function ($scope, $uibModal, $userResource, $location, $pager, $callback, $timeout, $storeResource, $roleResource, $disabledType) {

        /**
         *  初始化分页对象
         */
        $scope.pager = ng.copy($pager);
        $scope.disabledType = $disabledType;
        $scope.searchKeywords = null;

        /**
         * 加载列表数据
         */
        $scope.reload = function (pager, pageIndex) {

            $scope.pager.result = [];
            $scope.loading = true;
            if (!pager) {
                pager = ng.copy($scope.pager);
            }
            pager = ng.copy(pager);
            pager.result = [];
            if (pageIndex) {
                pager.pageIndex = pageIndex;
            }
            if ($scope.searchKeywords == "") {
                $scope.searchKeywords = null;
            }
            pager.condition.userName = $scope.searchKeywords;
            pager.condition.userCode = $scope.searchKeywords;
            pager.condition.phone = $scope.searchKeywords;

            $userResource.list(pager, function (data) {
                $scope.loading = false;
                if (data.status == 200) {
                    $scope.pager = data.result;
                } else {
                    $.messager.popup("系统错误!");
                }
            });
            var params = ng.copy($pager);
            params.pageSize = 65535;
            $userResource.listCompany(params, function (data) {
                if (data.status == 200) {
                    $scope.companyList = data.result.result;
                }
            });
            $roleResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.roleList = data.result.result;
                }
            });
        };
        $scope.reload();

        $scope.doChangeCompany = function (company) {
            if (!company) {
                return;
            }
            var params = ng.copy($pager);
            params.pageSize = 65535;
            params.condition.companyCode = company;
            params.condition.storeType = 0;
            $storeResource.list(params, function (data) {
                if (data.status == 200) {
                    $scope.storeList = data.result.result;
                }
            });
        };
        $scope.doChangeRole = function (role) {
            if (!role) {
                return;
            }
            var params = ng.copy($pager);
            params.parent = 65535;
            params.condition.name = role;
            $roleResource.list(params, function (data) {
                if (data.status == 200) {

                }
            })
        }

        /**
         * 重置密码为默认
         * @param userId
         */
        $scope.doResetPwd = function (userId) {
            $.messager.confirm($.messager.model.title.info, "确认重置为默认密码吗？默认密码为:123456。", function () {
                $userResource.resetPassword({id: userId}, $callback.exec);
            });
        };

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

        /**
         * 删除
         * @param store
         */
        $scope.doDel = function (user) {
            $.messager.confirm($.messager.model.title.info, "确认删除吗？", function () {
                var callback = {
                    after: function (data) {
                        $scope.reload();
                    }
                };
                ng.extend($callback, callback);
                $userResource.delete({"id": user.id}, $callback.exec);
            });
        };
        // ================ END ================
    }]);
});