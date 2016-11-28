/**
 * Created by Bond(China) on 2016/11/18.
 */
/*
 * Copyright (c) 2016. Bond(China), java freestyle app
 */

define([
    '../.md',
    'angular',
    'jquery',
    'underscore'
], function (md, ng, $, _) {

    return md.controller('KnowledgeAddCtrl', ['$scope', 'KnowledgeResource', '$location', '$pager', '$knowledgeTypeSet', function ($scope, $knowledgeResource, $location, $pager, $knowledgeTypeSet) {

        $scope.knowledgeTypeSet = $knowledgeTypeSet;
        $scope.knowledge = {
        };


        //=============END============
    }]);
});