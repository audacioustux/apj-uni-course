package com.audacioustux.util;

import java.security.*;

public class MD5 {
    public static String fromString(String string) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(string.getBytes());
            for (int i = 0; i < result.length; i++) {
                String hex = Integer.toHexString(0xff & result[i]);
                if (hex.length() == 1)
                    sb.append('0');
                sb.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
