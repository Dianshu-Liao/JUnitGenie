package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.util.Random;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_1_0_Test {

    @Test
    public void testApr1Crypt() throws Exception {
        // Arrange
        byte[] keyBytes = "testKey".getBytes();
        Random random = Mockito.mock(Random.class);
        // Mocking random behavior
        Mockito.when(random.nextInt(Mockito.anyInt())).thenReturn(0);
        // Act
        String result = invokeApr1Crypt(keyBytes, random);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }

    private String invokeApr1Crypt(byte[] keyBytes, Random random) throws Exception {
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", byte[].class, Random.class);
        method.setAccessible(true);
        return (String) method.invoke(null, keyBytes, random);
    }
}
