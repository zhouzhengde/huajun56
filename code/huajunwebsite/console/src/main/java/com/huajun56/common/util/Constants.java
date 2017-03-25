/*
 * Copyright (c) 2015. Bond(China), java freestyle app
 */

package com.huajun56.common.util;

/**
 * 常量类
 *
 * @author Bond(China)
 * @version 1.0.0
 */
public interface Constants {

    // ################ COMMON [START] #################
    String ENCODING = "UTF-8";
    String CONTENT_TYPE = "Content-Type";
    String CONTENT_TYPE_FILE_STREAM = "application/octet-stream;chartset=utf-8";
    // ################ COMMON [END] ###################

    // ################  REST [START] ##################
    String REST_STATUS = "status";
    String REST_MESSAGE = "message";
    String REST_CODE = "code";
    String REST_CAUSES = "causes";
    String REST_OK_MESSAGE = "OK";
    String REST_ERROR_MESSAGE = "ERROR";
    String REST_RESULT = "result";
    int REST_ACK_OK = 200;
    int REST_ACK_ERROR = 500;
    // ################  REST [END] ####################

    // ############## 密码加密算法设定 [START] ##################
    String HASH_ALGORITHM = "SHA-1";
    int HASH_INTERATIONS = 1024;
    int SALT_SIZE = 8;
    // ############## 密码加密算法设定 [END] ####################

    // ############## 消息发送类型码定义 [START] ##################
    /**
     * 重置密码的类型ID
     */
    int SMS_TYPEID_RESET_PASSWORD = 1;
    int SMS_TYPEID = 2;
    int SMS_TYPEID_LOGIN = 3;
    /**
     * 重置密码的短信内容模板
     */
    String SMS_TPL_RESET_PWD = "template/sms/reset_pwd.tpl";
    String SMS_TPL_LOGIN = "template/sms/login.tpl";
    String SMS_TPL = "template/sms/common.tpl";
    // ############## 消息发送类型码定义 [END] ####################

    // ############## Freemarker [START] ##################
    /**
     * 放入Freemarker中的数据根KEY，在数据已经是MAP时，可不用
     */
    String FREEMARKER_ROOT_KEY = "root";
    // ############## Freemarker [END] ####################

    // ############## Freemarker [START] ##################
    /**
     * 调用短信发送平台接口的数据模板
     */
    String WS_TPL_SMS = "template/ws/sms.xml";
    /**
     * 会员分配，SAP接口
     */
    String WS_TPL_SAP_PARTITION_MEMBER = "template/ws/sap/partition-member.xml";

    /**
     * 默认密码
     */
    String USER_DEFAULT_PASSWORD = "123456";
    // ############## Freemarker [END] ##################

    int METHOD_EXEC_OK = 1;
    int METHOD_EXEC_ERROR = -1;

    /**
     * 系统默认超级管理员的角色ID
     */
    Integer ROLE_ID_ADMIN = 1;

    /**
     * 系统默认门店店长的角色ID
     */
    Integer ROLE_ID_STORE_MANAGER = 2;


    /**
     * 系统默认专柜店长的角色ID
     */
    Integer ROLE_ID_BRAND_STORE_MANAGER = 3;

    /**
     * 系统默认导购员的角色ID
     */
    Integer ROLE_ID_SALES = 4;

    String PORTALS_CREATE_BY = "portals";
}
