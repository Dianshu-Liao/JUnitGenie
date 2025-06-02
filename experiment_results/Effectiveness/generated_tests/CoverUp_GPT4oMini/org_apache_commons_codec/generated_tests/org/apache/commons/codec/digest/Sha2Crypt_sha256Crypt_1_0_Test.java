package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.Sha2Crypt;
import java.lang.reflect.Method;
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

class Sha2Crypt_sha256Crypt_1_0_Test {

    @Test
    void testSha256CryptWithValidSalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=5000$somesalt";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith("$5$"));
        assertTrue(result.contains("somesalt"));
    }

    @Test
    void testSha256CryptWithNullSalt() {
        byte[] keyBytes = "password".getBytes();
        String result = Sha2Crypt.sha256Crypt(keyBytes, null);
        assertNotNull(result);
        assertTrue(result.startsWith("$5$"));
        assertTrue(result.contains("rounds="));
    }

    @Test
    void testSha256CryptWithEmptySalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt);
        });
        assertEquals("Invalid salt value: ", exception.getMessage().substring(0, 21));
    }

    @Test
    void testSha256CryptWithInvalidSaltFormat() {
        byte[] keyBytes = "password".getBytes();
        String salt = "invalidsaltformat";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt);
        });
        assertEquals("Invalid salt value: invalidsaltformat", exception.getMessage());
    }

    @Test
    void testSha256CryptWithCustomRounds() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=10000$somesalt";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith("$5$"));
        assertTrue(result.contains("somesalt"));
    }

//    @Test
//    void testSha256CryptWithMaxRounds() {
//        byte[] keyBytes = "password".getBytes();
//        String salt = "$5$rounds=999999999$somesalt";
//        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
//        assertNotNull(result);
//        assertTrue(result.startsWith("$5$"));
//        assertTrue(result.contains("somesalt"));
//    }

    @Test
    void testSha256CryptWithMinRounds() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=1000$somesalt";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith("$5$"));
        assertTrue(result.contains("somesalt"));
    }

//    @Test
//    void testSha256CryptWithTooHighRounds() {
//        byte[] keyBytes = "password".getBytes();
//        String salt = "$5$rounds=1000000000$somesalt";
//        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
//        assertNotNull(result);
//        assertTrue(result.startsWith("$5$"));
//        assertTrue(result.contains("somesalt"));
//    }

    @Test
    void testSha256CryptWithSaltLengthExceeding16Chars() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=5000$abcdefghijklmnopqr";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt);
        });
        assertEquals("Invalid salt value: " + salt, exception.getMessage());
    }
}
