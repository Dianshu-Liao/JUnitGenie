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

public class Crypt_crypt_0_0_Test {

    @Test
    public void testCryptWithValidKeyBytes() throws Exception {
        // Arrange
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        // Act
        String result = invokeCryptMethod(keyBytes);
        // Assert
        assertNotNull(result);
    }

    @Test
    public void testCryptWithNullKeyBytes() throws Exception {
        // Arrange
        byte[] keyBytes = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> invokeCryptMethod(keyBytes));
    }

    private String invokeCryptMethod(byte[] keyBytes) throws Exception {
        Method method = Crypt.class.getDeclaredMethod("crypt", byte[].class);
        method.setAccessible(true);
        return (String) method.invoke(null, keyBytes);
    }
}
