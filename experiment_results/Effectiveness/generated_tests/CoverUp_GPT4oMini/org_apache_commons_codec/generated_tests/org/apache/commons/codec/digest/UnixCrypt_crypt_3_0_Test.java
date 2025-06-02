package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.UnixCrypt;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Pattern;

class UnixCrypt_crypt_3_0_Test {

    @Test
    void testCryptWithValidSalt() throws Exception {
        UnixCrypt unixCrypt = new UnixCrypt();
        byte[] original = "password".getBytes();
        String salt = "./";
        String result = invokeCryptMethod(unixCrypt, original, salt);
        assertNotNull(result);
        // Check if the salt is preserved
        assertEquals("./", result.substring(0, 2));
    }

    @Test
    void testCryptWithNullSalt() throws Exception {
        UnixCrypt unixCrypt = new UnixCrypt();
        byte[] original = "password".getBytes();
        String result = invokeCryptMethod(unixCrypt, original, null);
        assertNotNull(result);
        // Check if result length is appropriate
        assertTrue(result.length() >= 13);
    }

    @Test
    void testCryptWithInvalidSalt() {
        UnixCrypt unixCrypt = new UnixCrypt();
        byte[] original = "password".getBytes();
        String invalidSalt = "invalid_salt";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeCryptMethod(unixCrypt, original, invalidSalt);
        });
        assertEquals("Invalid salt value: " + invalidSalt, thrown.getMessage());
    }

    @Test
    void testCryptWithShortSalt() throws Exception {
        UnixCrypt unixCrypt = new UnixCrypt();
        byte[] original = "password".getBytes();
        String shortSalt = ".";
        String result = invokeCryptMethod(unixCrypt, original, shortSalt);
        assertNotNull(result);
        // Check if the salt is preserved
        assertEquals(".", result.substring(0, 1));
    }

    private String invokeCryptMethod(UnixCrypt unixCrypt, byte[] original, String salt) throws Exception {
        Method cryptMethod = UnixCrypt.class.getDeclaredMethod("crypt", byte[].class, String.class);
        cryptMethod.setAccessible(true);
        return (String) cryptMethod.invoke(unixCrypt, original, salt);
    }
}
