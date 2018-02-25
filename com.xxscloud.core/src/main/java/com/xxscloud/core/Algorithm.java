package com.xxscloud.core;

import com.sun.istack.internal.Nullable;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


/**
 * @author 李小双 2018.1.1
 * 算法封装类库
 */
public final class Algorithm {


    /**
     * 隐藏.
     */
    private Algorithm() {

    }

    /**
     * MD5 加密算法.
     *
     * @param text 加密内容.
     * @return 签名结果.
     */
    @Nullable
    public static String md5Encryption(final String text) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(text.getBytes("utf-8"));
            byte[] resultByte = messageDigest.digest();
            final int value = 256;
            final int size = 16;

            StringBuilder resultBuffer = new StringBuilder();
            for (int temp : resultByte) {
                if (temp < 0) {
                    temp += value;
                } else if (temp < size) {
                    resultBuffer.append("0");
                }
                resultBuffer.append(Integer.toHexString(temp));
            }
            String result = resultBuffer.toString();
            return Utils.isNullOrEmpty(result) ? null : result.toUpperCase();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 计算文件的MD5.
     *
     * @param file 文件的字节数
     * @return MD5 值
     */
    @Nullable
    public static String md5Encryption(final MappedByteBuffer file) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(file);
            final int startIndex = 1;
            final int value = 16;
            BigInteger bigInteger = new BigInteger(startIndex, md5.digest());
            String result = bigInteger.toString(value);
            return Utils.isNullOrEmpty(result) ? null : result.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * RSA 加密算法.
     *
     * @param text 加密内容
     * @param key  秘钥
     * @return 签名结果
     */
    @Nullable
    public static String rsaEncryption(final String text, final String key) {
        return "RSA";
    }

    /**
     * RSA 加密算法.
     *
     * @param signature 签名内容
     * @param key       秘钥
     * @return 数据源
     */
    @Nullable
    public static String rsaDecryption(final String signature, final String key) {
        return "RSA";
    }

    /**
     * AES 加密算法.
     *
     * @param text 加密内容
     * @param key  秘钥
     * @return 签名结果
     */
    @Nullable
    public static String aesEncryption(final String text, final String key) {
        //秘钥长度
        final int keyLength = 16;
        if (Objects.equals(keyLength, key.length())) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
                byte[] resultByte = cipher.doFinal(text.getBytes("utf-8"));
                String result = Base64.encodeBase64String(resultByte);
                return Utils.isNullOrEmpty(result) ? null : result.toUpperCase();
            } catch (NoSuchPaddingException | NoSuchAlgorithmException | UnsupportedEncodingException |
                    InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * AES 解密算法.
     *
     * @param signature 签名内容
     * @param key       秘钥
     * @return 数据源
     */
    @Nullable
    public static String aesDecryption(final String signature, final String key) {
        //秘钥长度
        final int keyLength = 16;
        if (Objects.equals(keyLength, key.length())) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
                byte[] resultByte = cipher.doFinal(Base64.decodeBase64(signature));
                String result = new String(resultByte, "UTF-8");
                return Utils.isNullOrEmpty(result) ? null : result.toUpperCase();
            } catch (BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException |
                    InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * HmacSHA1 加密.
     *
     * @param text 加密内容
     * @param key  Key
     * @return 处理结果
     */
    @Nullable
    public static String hmacSha1Encryption(final String text, final String key) {
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes("utf-8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKey);
            byte[] textBytes = text.getBytes("utf-8");
            String result = Base64.encodeBase64String(mac.doFinal(textBytes));
            return Utils.isNullOrEmpty(result) ? null : result.replace("\r\n", "").toUpperCase();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }


}
