package com.johnsonwang.ssia.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class GenerateCodeUtil {

    private GenerateCodeUtil() {}

    public static String generateCode() {
        String code;

        try {
            SecureRandom random = SecureRandom.getInstanceStrong();

            int c = random.nextInt(9000) + 1000;
            code = String.valueOf(c);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Problem when generating the random code.");
        }

        return code;
    }
}
