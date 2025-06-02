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

public class Sha2Crypt_sha256Crypt_0_0_Test {

    @Test
    public void testSha256CryptWithoutSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        assertNotNull(result, "The result should not be null");
        assertEquals(true, result.startsWith(Sha2Crypt.SHA256_PREFIX), "The result should start with the SHA256 prefix");
    }

    @Test
    public void testSha256CryptWithCustomSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$5$somesalt";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result, "The result should not be null");
        assertEquals(true, result.startsWith(salt), "The result should start with the provided salt");
    }

    @Test
    public void testSha256CryptWithEmptySalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "";
        String result = Sha2Crypt.sha256Crypt(keyBytes, salt);
        assertNotNull(result, "The result should not be null");
        assertEquals(true, result.startsWith(Sha2Crypt.SHA256_PREFIX), "The result should start with the SHA256 prefix when empty salt is provided");
    }

    @Test
    public void testSha256CryptWithNullSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String result = Sha2Crypt.sha256Crypt(keyBytes, null);
        assertNotNull(result, "The result should not be null");
        assertEquals(true, result.startsWith(Sha2Crypt.SHA256_PREFIX), "The result should start with the SHA256 prefix when null salt is provided");
    }

    @Test
    public void testSha256CryptWithLongKey() {
        byte[] keyBytes = "thisisaverylongpasswordthatshouldstillwork".getBytes(StandardCharsets.UTF_8);
        String result = Sha2Crypt.sha256Crypt(keyBytes);
        assertNotNull(result, "The result should not be null");
        assertEquals(true, result.startsWith(Sha2Crypt.SHA256_PREFIX), "The result should start with the SHA256 prefix");
    }
}
