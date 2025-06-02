package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_4_0_Test {

    @Test
    public void testApr1Crypt() throws Exception {
        // Given
        String keyBytes = "testKey";
        String salt = "testSalt";
        // When
        String result = invokeApr1Crypt(keyBytes, salt);
        // Then
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "Result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1CryptWithEmptyKey() throws Exception {
        // Given
        String keyBytes = "";
        String salt = "testSalt";
        // When
        String result = invokeApr1Crypt(keyBytes, salt);
        // Then
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "Result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1CryptWithNullKey() throws Exception {
        // Given
        String keyBytes = null;
        String salt = "testSalt";
        // When & Then
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeApr1Crypt(keyBytes, salt);
        });
        assertEquals("keyBytes cannot be null", exception.getMessage());
    }

    @Test
    public void testApr1CryptWithNullSalt() throws Exception {
        // Given
        String keyBytes = "testKey";
        String salt = null;
        // When
        String result = invokeApr1Crypt(keyBytes, salt);
        // Then
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "Result should start with APR1_PREFIX");
    }

    private String invokeApr1Crypt(String keyBytes, String salt) throws Exception {
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", String.class, String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, keyBytes, salt);
    }
}
