/**
 * Created by Admin on 2016/7/2.
 */
define(['jquery', 'underscore', 'angular', '.cnf', './upload/angular-file-upload'], function($, _ , ng, cnf, upload){
   return ng.module('angular-ui', ['angularFileUpload']);
});