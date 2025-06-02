package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.UnixCrypt;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.regex.Pattern;

class UnixCrypt_crypt_2_0_Test {

    @Test
    void testCryptWithNullSalt() throws Exception {
        byte[] input = "testInput".getBytes();
        String result = invokeCryptMethod(input);
        assertNotNull(result);
        // Check the length of the result
        assertEquals(13, result.length());
    }

    @Test
    void testCryptWithValidSalt() throws Exception {
        byte[] input = "testInput".getBytes();
        // Valid salt
        String salt = "ab";
        String result = UnixCrypt.crypt(input, salt);
        assertNotNull(result);
        // Check the length of the result
        assertEquals(13, result.length());
    }

    @Test
    void testCryptWithInvalidSalt() {
        byte[] input = "testInput".getBytes();
        // Invalid salt
        String invalidSalt = "1";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(input, invalidSalt);
        });
        assertEquals("Invalid salt value: " + invalidSalt, thrown.getMessage());
    }

    @Test
    void testCryptWithEmptyInput() throws Exception {
        byte[] input = "".getBytes();
        String result = invokeCryptMethod(input);
        assertNotNull(result);
        // Check the length of the result
        assertEquals(13, result.length());
    }

    private String invokeCryptMethod(byte[] input) throws Exception {
        Method method = UnixCrypt.class.getDeclaredMethod("crypt", byte[].class);
        method.setAccessible(true);
        return (String) method.invoke(null, (Object) input);
    }
}
