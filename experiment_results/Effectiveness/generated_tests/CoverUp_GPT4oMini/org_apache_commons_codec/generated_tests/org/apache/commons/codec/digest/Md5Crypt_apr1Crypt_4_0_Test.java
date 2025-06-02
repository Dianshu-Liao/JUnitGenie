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

public class Md5Crypt_apr1Crypt_4_0_Test {

    @Test
    public void testApr1CryptWithValidInput() throws Exception {
        String key = "myPassword";
        String salt = "mySalt";
        // Invoke the focal method using reflection
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", String.class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, key, salt);
        // Validate the result is not null and matches expected format
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }

    @Test
    public void testApr1CryptWithNullSalt() throws Exception {
        String key = "myPassword";
        String salt = null;
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", String.class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, key, salt);
        // Validate the result is not null and matches expected format
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }

    @Test
    public void testApr1CryptWithEmptySalt() throws Exception {
        String key = "myPassword";
        String salt = "";
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", String.class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, key, salt);
        // Validate the result is not null and matches expected format
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }

    @Test
    public void testApr1CryptWithSaltWithoutPrefix() throws Exception {
        String key = "myPassword";
        String salt = "saltWithoutPrefix";
        Method method = Md5Crypt.class.getDeclaredMethod("apr1Crypt", String.class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, key, salt);
        // Validate the result is not null and matches expected format
        assertNotNull(result);
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX));
    }
}
