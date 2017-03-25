package com.huajun56.common.util;

import com.huajun56.common.exception.ServiceException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 常用的操作工具集锦
 *
 * @author Bond(China)
 * @version 1.0.0
 */
public final class $ {

    private $() {
    }

    /**
     * 判断是否为空
     *
     * @param object 需要被判定的对象
     * @return Boolean
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 判断是否为空
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(String object) {
        return StringUtils.isEmpty(object);
    }

    /**
     * 判断是否为空
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(List object) {
        return CollectionUtils.isEmpty(object);
    }

    /**
     * 是否相等
     *
     * @param v1 Value1
     * @param v2 Value2
     * @return Boolean
     */
    public static boolean isEqual(Integer v1, Integer v2) {

        if (isNull(v1) || isNull(v2)) {
            return false;
        }
        return v1.equals(v2);
    }

    /**
     * 是否相等
     *
     * @param v1 Value1
     * @param v2 Value2
     * @return Boolean
     */
    public static boolean isEqual(Long v1, Long v2) {

        if (isNull(v1) || isNull(v2)) {
            return false;
        }
        return v1.equals(v2);
    }

    /**
     * 是否相等
     *
     * @param v1 Value1
     * @param v2 Value2
     * @return Boolean
     */
    public static boolean isEqual(String v1, String v2) {

        if (isNull(v1) || isNull(v2)) {
            return false;
        }
        return v1.equals(v2);
    }

    /**
     * 非0均为true, 0 OR NULL 为false
     *
     * @param integer
     * @return
     */
    public static boolean toBool(Integer integer) {
        if ($.isNull(integer)) {
            return false;
        }
        return !$.isEqual(integer, 0);
    }



    /**
     * 判断对象是否为NULL
     *
     * @param o
     * @throws ServiceException
     */
    public static void assertIsNull(Object o) throws ServiceException {
        if ($.isNull(o)) {
            throw new ServiceException(ExceptionCode.REQUIRED_NOT_NULL);
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param o
     * @throws ServiceException
     */
    public static void assertIsNull(String o) throws ServiceException {
        if ($.isEmpty(o)) {
            throw new ServiceException(ExceptionCode.REQUIRED_NOT_NULL);
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param o1
     * @param o2
     * @throws ServiceException
     */
    public static void assertEquals(String o1, String o2) throws ServiceException {
        if ($.isEqual(o1, o2)) {
            throw new ServiceException(ExceptionCode.ILLEGAL_PARAMETER);
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param o1
     * @param o2
     * @throws ServiceException
     */
    public static void assertEquals(Integer o1, Integer o2) throws ServiceException {
        if ($.isEqual(o1, o2)) {
            throw new ServiceException(ExceptionCode.ILLEGAL_PARAMETER);
        }
    }

    /**
     * 校验
     */
    public static enum Validator {

        PHONE("[1][34578][0-9]{9}"), EMAIL("(\\w+((-\\w+)|(\\.\\w+))*)\\+\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+"), CHINESE("[\\u4e00-\\u9fa5]{1,20}");

        private String reg;

        private Validator(String reg) {
            this.reg = reg;
        }

        public boolean match(String val) {
            Pattern pattern = Pattern.compile(this.reg);
            return pattern.matcher(val).matches();
        }
    }

}
