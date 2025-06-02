package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sha2Crypt_sha512Crypt_4_0_Test {

    @Test
    public void testSha512Crypt_NullSalt() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String result = Sha2Crypt.sha512Crypt(keyBytes);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
    }

    @Test
    public void testSha512Crypt_EmptySalt() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String result = Sha2Crypt.sha512Crypt(keyBytes, "");
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
    }

    @Test
    public void testSha512Crypt_ValidSalt() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$rounds=5000$abcdefgh";
        String result = Sha2Crypt.sha512Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
        assertTrue(result.contains("abcdefgh"));
    }

    @Test
    public void testSha512Crypt_SaltWithSpecialCharacters() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$rounds=5000$@!#$%^&*()";
        String result = Sha2Crypt.sha512Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
        assertTrue(result.contains("@!#$%^&*()"));
    }

    @Test
    public void testSha512Crypt_LongSalt() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$rounds=5000$abcdefghijklmnopqrstuvwxyz";
        String result = Sha2Crypt.sha512Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
        assertTrue(result.contains("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void testSha512Crypt_SaltWithInvalidCharacters() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$rounds=5000$invalid_salt@!";
        String result = Sha2Crypt.sha512Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
        assertTrue(result.contains("invalid_salt@!"));
    }

    @Test
    public void testSha512Crypt_SameInputProducesSameOutput() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$rounds=5000$abcdefgh";
        String result1 = Sha2Crypt.sha512Crypt(keyBytes, salt);
        String result2 = Sha2Crypt.sha512Crypt(keyBytes, salt);
        assertEquals(result1, result2);
    }
}
