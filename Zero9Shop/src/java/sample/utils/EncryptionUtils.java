/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author THANH HUNG
 */
public class EncryptionUtils {
    public static String md5(String password) throws NoSuchAlgorithmException {
        MessageDigest msg;
        msg = MessageDigest.getInstance("MD5");
        String newPass = new BigInteger(1, msg.digest(password.getBytes())).toString(16);
        return newPass;
    }
}
