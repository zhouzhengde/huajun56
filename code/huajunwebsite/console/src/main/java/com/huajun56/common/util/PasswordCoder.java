package com.huajun56.common.util;


import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author Created by Bond(China) on 2016/7/6.
 */
public final class PasswordCoder {

    private PasswordCoder() {
    }

    /**
     * 密码实例
     */
    public static class PasswordEntity {

        private String salt;

        private String password;

        public String getSalt() {
            return salt;
        }

        public PasswordEntity() {

        }

        public PasswordEntity(String salt, String password) {
            this.salt = salt;
            this.password = password;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    /**
     * 加密
     *
     * @param password
     * @return
     */
    public static PasswordEntity encrypt(String password) {

        String salt = new SecureRandomNumberGenerator().nextBytes(Constants.SALT_SIZE).toHex();

        SimpleHash hash = new SimpleHash(Constants.HASH_ALGORITHM, password, Hex.decode(salt), Constants.HASH_INTERATIONS);

        return new PasswordEntity(salt, hash.toHex());
    }
}
