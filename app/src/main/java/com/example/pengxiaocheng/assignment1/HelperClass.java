package com.example.pengxiaocheng.assignment1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pengxiaocheng on 2018/4/24.
 */

public class HelperClass {

        public static String parseStrToMd5L32(String str){
            String reStr = null;
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] bytes = md5.digest(str.getBytes());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b : bytes){
                    int bt = b&0xff;
                    if (bt < 16){
                        stringBuffer.append(0);
                    }
                    stringBuffer.append(Integer.toHexString(bt));
                }
                reStr = stringBuffer.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return reStr;
        }
}
