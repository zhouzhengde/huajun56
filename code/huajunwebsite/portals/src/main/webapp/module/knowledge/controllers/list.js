/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('KnowledgeListCtrl', ['$scope', 'KnowledgeResource', '$location', '$pager', '$knowledgeTypeSet', function ($scope, $knowledgeResource, $location, $pager, $knowledgeTypeSet) {

        /**
         *  初始化分页对象
         */
        $scope.pager = $pager;
        $scope.knowledgeTypeSet = $knowledgeTypeSet;

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
            $knowledgeResource.list(pager, function (data) {

                if (data.status == 200) {
                    $scope.pager = data.result;
                } else {
                    $.messager.popup(data.message);
                }
            });
        }
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

        //=============END============
    }]);
});