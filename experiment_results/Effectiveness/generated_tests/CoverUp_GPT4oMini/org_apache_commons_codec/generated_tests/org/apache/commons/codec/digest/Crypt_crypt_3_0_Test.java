package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.Crypt;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class Crypt_crypt_3_0_Test {

    @Test
    public void testCryptWithValidSalt() throws Exception {
        String key = "mySecretKey";
        // Example of a SHA512 salt
        String salt = "$6$rounds=5000$abcdefgh$";
        String expected = (String) invokePrivateMethod("crypt", key.getBytes(StandardCharsets.UTF_8), salt);
        String result = Crypt.crypt(key, salt);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void testCryptWithNullSalt() throws Exception {
        String key = "mySecretKey";
        String salt = null;
        String expected = (String) invokePrivateMethod("crypt", key.getBytes(StandardCharsets.UTF_8), null);
        String result = Crypt.crypt(key, salt);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void testCryptWithEmptySalt() throws Exception {
        String key = "mySecretKey";
        String salt = "";
        String expected = (String) invokePrivateMethod("crypt", key.getBytes(StandardCharsets.UTF_8), salt);
        String result = Crypt.crypt(key, salt);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = Crypt.class.getDeclaredMethod(methodName, byte[].class, String.class);
        method.setAccessible(true);
        return method.invoke(null, args);
    }
}
