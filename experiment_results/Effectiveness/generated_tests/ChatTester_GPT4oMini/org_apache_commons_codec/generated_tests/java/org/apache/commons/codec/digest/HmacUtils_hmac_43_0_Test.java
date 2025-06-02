package org.apache.commons.codec.digest;

import java.nio.ByteBuffer;
import javax.crypto.Mac;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class HmacUtils_hmac_43_0_Test {

    private HmacUtils hmacUtils;

    private Mac macMock;

    @BeforeEach
    public void setUp() throws Exception {
        macMock = mock(Mac.class);
        // Repairing the buggy line by using a valid constructor
        // Use a valid algorithm and key
        hmacUtils = new HmacUtils("HmacSHA256", new byte[0]);
    }

    @Test
    public void testHmac_ValidInput() throws Exception {
        // Arrange
        ByteBuffer input = ByteBuffer.wrap("test".getBytes());
        // Example output
        byte[] expectedOutput = new byte[] { 1, 2, 3, 4 };
        when(macMock.doFinal()).thenReturn(expectedOutput);
        // Act
        byte[] result = hmacUtils.hmac(input);
        // Assert
        verify(macMock).update(input);
        verify(macMock).doFinal();
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testHmac_EmptyInput() throws Exception {
        // Arrange
        ByteBuffer input = ByteBuffer.wrap(new byte[] {});
        // Example output
        byte[] expectedOutput = new byte[] { 5, 6, 7, 8 };
        when(macMock.doFinal()).thenReturn(expectedOutput);
        // Act
        byte[] result = hmacUtils.hmac(input);
        // Assert
        verify(macMock).update(input);
        verify(macMock).doFinal();
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testHmac_NullInput() throws Exception {
        // Arrange
        ByteBuffer input = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            hmacUtils.hmac(input);
        });
    }
}
