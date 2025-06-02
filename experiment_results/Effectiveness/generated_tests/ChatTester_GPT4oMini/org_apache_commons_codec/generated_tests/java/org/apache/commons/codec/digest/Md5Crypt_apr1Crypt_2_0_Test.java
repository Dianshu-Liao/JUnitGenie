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

public class Md5Crypt_apr1Crypt_2_0_Test {

    @Test
    public void testApr1CryptWithValidSalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "mysalt";
        String expected = Md5Crypt.md5Crypt(keyBytes, "$apr1$mysalt", "$apr1$");
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithNullSalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = null;
        String expected = Md5Crypt.md5Crypt(keyBytes, "$apr1$", "$apr1$");
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithEmptySalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "";
        String expected = Md5Crypt.md5Crypt(keyBytes, "$apr1$", "$apr1$");
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithSaltWithoutPrefix() {
        byte[] keyBytes = "password".getBytes();
        String salt = "saltWithoutPrefix";
        String expected = Md5Crypt.md5Crypt(keyBytes, "$apr1$saltWithoutPrefix", "$apr1$");
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithSaltAlreadyWithPrefix() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$apr1$saltWithPrefix";
        String expected = Md5Crypt.md5Crypt(keyBytes, salt, "$apr1$");
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        assertEquals(expected, result);
    }

    @Test
    public void testApr1CryptWithInvalidInput() {
        byte[] keyBytes = null;
        String salt = "salt";
        assertThrows(NullPointerException.class, () -> {
            Md5Crypt.apr1Crypt(keyBytes, salt);
        });
    }
}
