package com.huajun56.common.util;


import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密工具类
 * Created by Bond(China) on 2016/11/25.
 */
public final class MD5 {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5.class);
    private static final String ALGORITHM_NAME = "MD5";

    private MD5() {
    }

    /**
     * MD5 加密
     *
     * @param bts
     * @return
     */
    public static String encrypt(byte[] bts) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM_NAME);
            digest.update(bts);
            return new String(Hex.encodeHex(digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("[MD5 Encrypt]", e);
            throw new IllegalStateException(e);
        }
    }

    /**
     * MD5 加密
     *
     * @param content
     * @param charset
     * @return
     */
    public static String encrypt(String content, String charset) {
        try {
            return encrypt(content.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("[MD5 Encrypt]", e);
            throw new IllegalStateException(e);
        }
    }
}
