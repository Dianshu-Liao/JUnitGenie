package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.regex.Pattern;

public class UnixCrypt_crypt_4_0_Test {

    @Test
    public void testCrypt() throws Exception {
        // Arrange
        String original = "password";
        String expected = invokeCryptMethod(original);
        // Act
        String result = UnixCrypt.crypt(original);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testCryptWithEmptyString() throws Exception {
        // Arrange
        String original = "";
        String expected = invokeCryptMethod(original);
        // Act
        String result = UnixCrypt.crypt(original);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testCryptWithNull() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            // Fixed line
            UnixCrypt.crypt((String) null);
        });
    }

    private String invokeCryptMethod(String original) throws Exception {
        Method method = UnixCrypt.class.getDeclaredMethod("crypt", byte[].class);
        method.setAccessible(true);
        return (String) method.invoke(null, (Object) original.getBytes(StandardCharsets.UTF_8));
    }
}
