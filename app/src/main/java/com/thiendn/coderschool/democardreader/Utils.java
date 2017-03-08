package com.thiendn.coderschool.democardreader;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by thiendn on 21/02/2017.
 */

public class Utils {
    private static SecureRandom random = new SecureRandom();

    public static String getRandomString(){
        return new BigInteger(130, random).toString(32);
    }
}
