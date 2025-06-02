package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_4_0_Test {

    @Test
    public void testApr1CryptWithValidInputs() {
        String key = "password";
        String salt = "salt";
        String expected = Md5Crypt.apr1Crypt(key.getBytes(StandardCharsets.UTF_8), "$apr1$salt");
        String result = Md5Crypt.apr1Crypt(key, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithNullSalt() {
        String key = "password";
        String salt = null;
        String expected = Md5Crypt.apr1Crypt(key.getBytes(StandardCharsets.UTF_8), "$apr1$");
        String result = Md5Crypt.apr1Crypt(key, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithEmptySalt() {
        String key = "password";
        String salt = "";
        String expected = Md5Crypt.apr1Crypt(key.getBytes(StandardCharsets.UTF_8), "$apr1$");
        String result = Md5Crypt.apr1Crypt(key, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithSpecialCharacters() {
        String key = "p@ssw0rd!";
        String salt = "s@lt!";
        String expected = Md5Crypt.apr1Crypt(key.getBytes(StandardCharsets.UTF_8), "$apr1$s@lt!");
        String result = Md5Crypt.apr1Crypt(key, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithLongKey() {
        String key = "thisIsAVeryLongPasswordThatExceedsNormalLength";
        String salt = "longSalt";
        String expected = Md5Crypt.apr1Crypt(key.getBytes(StandardCharsets.UTF_8), "$apr1$longSalt");
        String result = Md5Crypt.apr1Crypt(key, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithNumericSalt() {
        String key = "password";
        String salt = "123456";
        String expected = Md5Crypt.apr1Crypt(key.getBytes(StandardCharsets.UTF_8), "$apr1$123456");
        String result = Md5Crypt.apr1Crypt(key, salt);
        assertEquals(expected, result);
    }
}
