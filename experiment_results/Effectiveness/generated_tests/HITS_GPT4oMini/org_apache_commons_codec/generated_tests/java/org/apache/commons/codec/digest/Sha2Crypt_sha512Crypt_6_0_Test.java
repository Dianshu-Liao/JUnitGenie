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

public class Sha2Crypt_sha512Crypt_6_0_Test {

    @Test
    public void testSha512CryptWithValidInputs() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$6$rounds=5000$somesalt$";
        Random random = new SecureRandom();
        String result = Sha2Crypt.sha512Crypt(keyBytes, salt, random);
        assertNotNull(result, "The result should not be null");
    }

    @Test
    public void testSha512CryptWithNullSalt() {
        byte[] keyBytes = "password".getBytes();
        Random random = new SecureRandom();
        String result = Sha2Crypt.sha512Crypt(keyBytes, null, random);
        assertNotNull(result, "The result should not be null when salt is null");
    }

    @Test
    public void testSha512CryptWithEmptySalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "";
        Random random = new SecureRandom();
        String result = Sha2Crypt.sha512Crypt(keyBytes, salt, random);
        assertNotNull(result, "The result should not be null when salt is empty");
    }

    @Test
    public void testSha512CryptWithInvalidSaltFormat() {
        byte[] keyBytes = "password".getBytes();
        String salt = "invalid_salt_format";
        Random random = new SecureRandom();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha512Crypt(keyBytes, salt, random);
        });
        assertNotNull(exception);
    }

    @Test
    public void testSha512CryptWithLongSalt() {
        byte[] keyBytes = "password".getBytes();
        String salt = "$6$rounds=5000$longsaltlongsalt$";
        Random random = new SecureRandom();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Sha2Crypt.sha512Crypt(keyBytes, salt, random);
        });
        assertNotNull(exception);
    }
}
