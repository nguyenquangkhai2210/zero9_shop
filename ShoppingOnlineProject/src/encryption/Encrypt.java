/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author PhuNDSE63159
 */
public class Encrypt {

    /**
     * encrypt password by using MD5
     *
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String password) throws NoSuchAlgorithmException {
        MessageDigest msg;
        msg = MessageDigest.getInstance("MD5");
        String newPass = new BigInteger(1, msg.digest(password.getBytes())).toString(16);
        return newPass;
    }

}
