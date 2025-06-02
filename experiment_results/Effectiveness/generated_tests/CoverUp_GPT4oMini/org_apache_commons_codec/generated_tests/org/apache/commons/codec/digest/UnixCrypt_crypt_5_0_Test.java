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

public class UnixCrypt_crypt_5_0_Test {

    @Test
    public void testCryptWithValidInputs() throws Exception {
        String original = "myPassword";
        String salt = "ab";
        String expected = invokeCrypt(original, salt);
        // Assuming expected output is known for the given input
        assertEquals(expected, UnixCrypt.crypt(original, salt));
    }

    @Test
    public void testCryptWithNullSalt() throws Exception {
        String original = "myPassword";
        String salt = null;
        String result = invokeCrypt(original, salt);
        // Check that the result is not null and has the expected length
        assertEquals(13, result.length());
    }

    @Test
    public void testCryptWithInvalidSalt() {
        String original = "myPassword";
        // Invalid because it must be at least 2 characters
        String invalidSalt = "1";
        assertThrows(IllegalArgumentException.class, () -> {
            UnixCrypt.crypt(original, invalidSalt);
        });
    }

    @Test
    public void testCryptWithEmptyString() throws Exception {
        String original = "";
        String salt = "ab";
        String result = invokeCrypt(original, salt);
        // Check that the result is as expected for empty string
        assertEquals("ab", result);
    }

    private String invokeCrypt(String original, String salt) throws Exception {
        Method method = UnixCrypt.class.getDeclaredMethod("crypt", String.class, String.class);
        method.setAccessible(true);
        return (String) method.invoke(null, original, salt);
    }
}
