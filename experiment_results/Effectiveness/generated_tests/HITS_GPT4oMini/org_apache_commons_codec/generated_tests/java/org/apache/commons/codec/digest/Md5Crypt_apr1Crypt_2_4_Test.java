package org.apache.commons.codec.digest;

import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_2_4_Test {

    @Test
    public void testApr1CryptWithNullSalt() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String result = Md5Crypt.apr1Crypt(keyBytes, (String) null);
        assertEquals("$apr1$testKey", result.substring(0, 12));
    }

    @Test
    public void testApr1CryptWithEmptySalt() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String result = Md5Crypt.apr1Crypt(keyBytes, "");
        assertEquals("$apr1$", result.substring(0, 6));
    }

    @Test
    public void testApr1CryptWithValidSalt() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String salt = "validSalt";
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        assertEquals("$apr1$validSalt", result.substring(0, 15));
    }

    @Test
    public void testApr1CryptWithSaltStartingWithPrefix() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String salt = "$apr1$alreadyHasPrefix";
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        assertEquals("$apr1$alreadyHasPrefix", result.substring(0, 25));
    }
}
