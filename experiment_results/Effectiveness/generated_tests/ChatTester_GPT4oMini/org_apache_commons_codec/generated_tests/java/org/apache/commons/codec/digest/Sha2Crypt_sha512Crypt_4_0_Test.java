package org.apache.commons.codec.digest;

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
    public void testSha512Crypt_ValidInput() throws Exception {
        // Given
        byte[] keyBytes = "testPassword".getBytes();
        // When
        String result = invokeSha512Crypt(keyBytes);
        // Then
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX), "Result should start with SHA512_PREFIX");
        assertTrue(result.length() > 0, "Result should not be empty");
    }

    @Test
    public void testSha512Crypt_EmptyInput() throws Exception {
        // Given
        byte[] keyBytes = "".getBytes();
        // When
        String result = invokeSha512Crypt(keyBytes);
        // Then
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA512_PREFIX), "Result should start with SHA512_PREFIX");
        assertTrue(result.length() > 0, "Result should not be empty");
    }

    @Test
    public void testSha512Crypt_NullInput() throws Exception {
        // Given
        byte[] keyBytes = null;
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            invokeSha512Crypt(keyBytes);
        });
    }

    private String invokeSha512Crypt(byte[] keyBytes) throws Exception {
        // Use reflection to access the private method
        Method method = Sha2Crypt.class.getDeclaredMethod("sha512Crypt", byte[].class);
        method.setAccessible(true);
        return (String) method.invoke(null, (Object) keyBytes);
    }
}
