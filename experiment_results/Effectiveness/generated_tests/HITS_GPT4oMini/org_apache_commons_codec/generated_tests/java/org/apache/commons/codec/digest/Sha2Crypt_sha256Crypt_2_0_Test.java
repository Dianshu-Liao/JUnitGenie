package org.apache.commons.codec.digest;

import java.security.SecureRandom;
import java.util.Random;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sha2Crypt_sha256Crypt_2_0_Test {

    @Test
    void testSha256CryptWithNullSalt() {
        byte[] keyBytes = "password".getBytes();
        Random random = new SecureRandom();
        String result = Sha2Crypt.sha256Crypt(keyBytes, null, random);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256CryptWithEmptySalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "";
        Random random = new SecureRandom();
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256CryptWithValidSalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=5000$somesalt";
        Random random = new SecureRandom();
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
        assertNotNull(result);
        // Check if it starts with $5$
        assertTrue(result.startsWith(salt.substring(0, 3)));
    }

    @Test
    void testSha256CryptWithInvalidSalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "invalidsalt";
        Random random = new SecureRandom();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt, random);
        });
        assertEquals("Invalid salt value: invalidsalt", exception.getMessage());
    }

    @Test
    void testSha256CryptWithNullKeyBytes() {
        String salt = "$5$rounds=5000$somesalt";
        Random random = new SecureRandom();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Sha2Crypt.sha256Crypt(null, salt, random);
        });
        assertEquals("keyBytes must not be null", exception.getMessage());
    }

    @Test
    void testSha256CryptWithNullRandom() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$5$rounds=5000$somesalt";
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt, null);
        });
        assertEquals("random must not be null", exception.getMessage());
    }
}
