package com.huajun56.common.util;

import org.apache.shiro.codec.Hex;
import org.junit.Test;

/**
 * Created by bond on 2017/2/26.
 */
public class PasswordCoderTest {


    @Test
    public void encrypt() throws Exception {

        PasswordCoder.PasswordEntity entity = PasswordCoder.encrypt("123456");

        System.out.println(entity.getPassword());
        System.out.println(entity.getSalt());

    }

    @Test
    public void test() throws Exception{

        String salt = "156d8aaafa1f1a49";//new SecureRandomNumberGenerator().nextBytes(Constants.SALT_SIZE).toHex();

        byte[] bytes = Hex.decode(salt);

        System.out.println(org.apache.shiro.util.ByteSource.Util.bytes(bytes));


//        SimpleHash hash = new SimpleHash(Constants.HASH_ALGORITHM, "123456", salt, Constants.HASH_INTERATIONS);
//        SimpleHash hash2 = new SimpleHash(Constants.HASH_ALGORITHM, "000000", Hex.decode(salt), Constants.HASH_INTERATIONS);
//
//        System.out.println("63351ef36df34711c4dad4cbe9f3de9bbab33d3c");
//        System.out.println(hash.toHex());
//        System.out.println(hash2.toHex());
//        System.out.println(hash.toBase64());
//        System.out.println(hash2.toBase64());
//        System.out.println(hash.toString());
//        System.out.println(hash2.toString());

    }

}