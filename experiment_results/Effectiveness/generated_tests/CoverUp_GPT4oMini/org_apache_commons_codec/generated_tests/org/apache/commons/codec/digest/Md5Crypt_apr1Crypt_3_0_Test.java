package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.Md5Crypt;
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

public class Md5Crypt_apr1Crypt_3_0_Test {

    @Test
    public void testApr1Crypt() throws Exception {
        // Arrange
        String input = "testPassword";
        Md5Crypt md5Crypt = new Md5Crypt();
        // Act
        String result = invokeApr1Crypt(md5Crypt, input);
        // Assert
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "Result should start with APR1_PREFIX");
    }

    private String invokeApr1Crypt(Md5Crypt md5Crypt, String keyBytes) throws Exception {
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", String.class);
        method.setAccessible(true);
        return (String) method.invoke(md5Crypt, keyBytes);
    }
}
