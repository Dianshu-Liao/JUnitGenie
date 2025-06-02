package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class Crypt_crypt_1_0_Test {

    @Test
    public void testCryptWithNullSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String result = Crypt.crypt(keyBytes, null);
        assertNotNull(result, "Result should not be null when salt is null");
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX), "Result should start with SHA512 prefix");
    }

    @Test
    public void testCryptWithSHA512Salt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$somesalt";
        String result = Crypt.crypt(keyBytes, salt);
        assertNotNull(result, "Result should not be null when using SHA512 salt");
        assertEquals(Sha2Crypt.sha512Crypt(keyBytes, salt), result, "Result should match expected SHA512 hash");
    }

    @Test
    public void testCryptWithSHA256Salt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$5$somesalt";
        String result = Crypt.crypt(keyBytes, salt);
        assertNotNull(result, "Result should not be null when using SHA256 salt");
        assertEquals(Sha2Crypt.sha256Crypt(keyBytes, salt), result, "Result should match expected SHA256 hash");
    }

    @Test
    public void testCryptWithMD5Salt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "$1$somesalt";
        String result = Crypt.crypt(keyBytes, salt);
        assertNotNull(result, "Result should not be null when using MD5 salt");
        assertEquals(Md5Crypt.md5Crypt(keyBytes, salt), result, "Result should match expected MD5 hash");
    }

    @Test
    public void testCryptWithUnixSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "somesalt";
        String result = Crypt.crypt(keyBytes, salt);
        assertNotNull(result, "Result should not be null when using Unix salt");
        assertEquals(UnixCrypt.crypt(keyBytes, salt), result, "Result should match expected Unix hash");
    }

    @Test
    public void testCryptWithInvalidSalt() {
        byte[] keyBytes = "password".getBytes(StandardCharsets.UTF_8);
        String salt = "invalid_salt";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Crypt.crypt(keyBytes, salt);
        });
        String expectedMessage = "Invalid salt value: " + salt;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Expected exception message should match");
    }
}
