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

public class Sha2Crypt_sha512Crypt_4_0_Test {

    @Test
    public void testSha512CryptWithNullSalt() throws Exception {
        // Arrange
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        Sha2Crypt sha2Crypt = new Sha2Crypt();
        // Act
        Method method = Sha2Crypt.class.getDeclaredMethod("sha512Crypt", byte[].class);
        method.setAccessible(true);
        String result = (String) method.invoke(sha2Crypt, keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
    }

    @Test
    public void testSha512CryptWithValidSalt() throws Exception {
        // Arrange
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$somesalt";
        Sha2Crypt sha2Crypt = new Sha2Crypt();
        // Act
        Method method = Sha2Crypt.class.getDeclaredMethod("sha512Crypt", byte[].class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(sha2Crypt, keyBytes, salt);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
    }

    @Test
    public void testSha512CryptWithEmptyKey() throws Exception {
        // Arrange
        byte[] keyBytes = "".getBytes(StandardCharsets.UTF_8);
        Sha2Crypt sha2Crypt = new Sha2Crypt();
        // Act
        Method method = Sha2Crypt.class.getDeclaredMethod("sha512Crypt", byte[].class);
        method.setAccessible(true);
        String result = (String) method.invoke(sha2Crypt, keyBytes);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX));
    }
}
