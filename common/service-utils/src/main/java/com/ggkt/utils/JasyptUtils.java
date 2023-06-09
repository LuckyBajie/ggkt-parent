package com.ggkt.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.iv.NoIvGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JasyptUtils {

    private final static String YOUR_SALT_PASSWORD = "";
    private final static List<String> SOURCE_STRS = new ArrayList<>();

    public static void main(String[] args) {
        initData();
        PBEWITHHMACSHA512ANDAES_256();
//        PBEWithMD5AndDES();

    }

    private static void initData() {
        SOURCE_STRS.addAll(Arrays.asList(
                "",
                ""
        ));
    }

    private static void PBEWITHHMACSHA512ANDAES_256() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        // 加密方式
        // PBEWithMD5AndDES
        // PBEWITHHMACSHA512ANDAES_256
        // config.setAlgorithm("PBEWithMD5AndDES");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        // 盐值
        config.setPassword(YOUR_SALT_PASSWORD);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        // 加密明文
        List<String> encryptedList = SOURCE_STRS.stream().map(encryptor::encrypt)
                .collect(Collectors.toList());
        // 解密密文
        List<String> decryptedList = encryptedList.stream().map(encryptor::decrypt)
                .collect(Collectors.toList());
        System.out.println("原串：" + SOURCE_STRS);
        System.out.println("加密串：" + encryptedList);
        System.out.println("解密串：" + decryptedList);
        ;
    }

    /**
     * 这个加密方式不好用
     */
    public static void PBEWithMD5AndDES() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        standardPBEStringEncryptor.setPassword("glmall-salt2023040");
        standardPBEStringEncryptor.setIvGenerator(new NoIvGenerator());
        String root1 = standardPBEStringEncryptor.encrypt("root");
        String root2 = standardPBEStringEncryptor.encrypt("root");
        System.out.println(root1);
        System.out.println(root2);

        // 解密密文
        String decryptValue1 = standardPBEStringEncryptor.decrypt(root1);
        String decryptValue2 = standardPBEStringEncryptor.decrypt(root2);
        System.out.println(decryptValue1);
        System.out.println(decryptValue2);
    }
}
