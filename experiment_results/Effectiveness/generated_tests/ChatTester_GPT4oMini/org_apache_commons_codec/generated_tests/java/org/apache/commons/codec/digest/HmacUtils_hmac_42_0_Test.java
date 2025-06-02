package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class HmacUtils_hmac_42_0_Test {

    private HmacUtils hmacUtils;

    private Mac macMock;

    @BeforeEach
    public void setUp() throws Exception {
        macMock = mock(Mac.class);
        Constructor<HmacUtils> constructor = HmacUtils.class.getDeclaredConstructor(Mac.class);
        constructor.setAccessible(true);
        hmacUtils = constructor.newInstance(macMock);
    }

    @Test
    public void testHmac() throws Exception {
        // Given
        byte[] input = "testInput".getBytes();
        byte[] expectedOutput = "expectedOutput".getBytes();
        // When
        when(macMock.doFinal(input)).thenReturn(expectedOutput);
        byte[] actualOutput = hmacUtils.hmac(input);
        // Then
        assertArrayEquals(expectedOutput, actualOutput);
        verify(macMock).doFinal(input);
    }

    @Test
    public void testHmacWithNullInput() {
        // Given
        byte[] input = null;
        // When & Then
        assertThrows(NullPointerException.class, () -> {
            hmacUtils.hmac(input);
        });
    }

    @Test
    public void testHmacWithEmptyInput() throws Exception {
        // Given
        byte[] input = new byte[0];
        byte[] expectedOutput = "emptyOutput".getBytes();
        // When
        when(macMock.doFinal(input)).thenReturn(expectedOutput);
        byte[] actualOutput = hmacUtils.hmac(input);
        // Then
        assertArrayEquals(expectedOutput, actualOutput);
        verify(macMock).doFinal(input);
    }
}
