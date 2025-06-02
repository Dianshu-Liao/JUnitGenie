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
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_0_0_Test {

    @Test
    public void testApr1Crypt() throws Exception {
        // Arrange
        byte[] keyBytes = "testPassword".getBytes();
        // Act
        String result = invokeApr1Crypt(keyBytes);
        // Assert
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with the APR1_PREFIX");
    }

    private String invokeApr1Crypt(byte[] keyBytes) throws Exception {
        // Use reflection to access the private method
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", byte[].class);
        method.setAccessible(true);
        return (String) method.invoke(null, (Object) keyBytes);
    }
}
