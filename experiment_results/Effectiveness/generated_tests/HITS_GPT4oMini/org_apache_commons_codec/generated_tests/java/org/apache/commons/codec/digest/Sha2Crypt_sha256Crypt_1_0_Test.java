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

public class Sha2Crypt_sha256Crypt_1_0_Test {

    @Test
    public void testSha256CryptWithNullSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String result = Sha2Crypt.sha256Crypt(keyBytes, null);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    public void testSha256CryptWithValidSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$5$rounds=5000$somesalt$";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
        assertTrue(result.contains("somesalt"));
    }

    @Test
    public void testSha256CryptWithEmptySalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt);
        });
        assertEquals("Invalid salt value: ", exception.getMessage());
    }

    @Test
    public void testSha256CryptWithInvalidSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$5$invalidsalt$";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt);
        });
        assertEquals("Invalid salt value: $5$invalidsalt$", exception.getMessage());
    }

    @Test
    public void testSha256CryptWithCustomRounds() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$5$rounds=10000$somesalt$";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
        assertTrue(result.contains("somesalt"));
    }

//    @Test
//    public void testSha256CryptWithMaxRounds() {
//        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
//        String salt = "$5$rounds=999999999$somesalt$";
//        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
//        assertNotNull(result);
//        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
//        assertTrue(result.contains("somesalt"));
//    }

    @Test
    public void testSha256CryptWithMinRounds() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$5$rounds=1000$somesalt$";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
        assertTrue(result.contains("somesalt"));
    }

    @Test
    public void testSha256CryptWithRoundsBelowMin() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$5$rounds=500$somesalt$";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha256Crypt(keyBytes, salt);
        });
        assertEquals("Invalid salt value: $5$rounds=500$somesalt$", exception.getMessage());
    }

//    @Test
//    public void testSha256CryptWithRoundsAboveMax() {
//        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
//        String salt = "$5$rounds=1000000000$somesalt$";
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            Sha2Crypt.sha256Crypt(keyBytes, salt);
//        });
//        assertEquals("Invalid salt value: $5$rounds=1000000000$somesalt$", exception.getMessage());
//    }
}
