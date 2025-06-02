package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class HmacUtils_hmac_46_0_Test {

    private HmacUtils hmacUtils;

    private Mac mockMac;

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException, InvalidKeyException {
        // Mocking the Mac class
        mockMac = mock(Mac.class);
        // Repairing the buggy line: using SecretKeySpec to create a key
        Key key = new SecretKeySpec(new byte[0], "HmacSHA256");
        mockMac.init(key);
        // Using string for algorithm
        hmacUtils = new HmacUtils("HmacSHA256", new byte[0]);
    }

    @Test
    public void testHmacWithValidInput() throws Exception {
        // Arrange
        String valueToDigest = "testValue";
        // Example expected output
        byte[] expectedHmac = new byte[] { 1, 2, 3, 4 };
        // Mocking the behavior of the Mac class
        when(mockMac.doFinal(StringUtils.getBytesUtf8(valueToDigest))).thenReturn(expectedHmac);
        // Act
        byte[] actualHmac = hmacUtils.hmac(valueToDigest);
        // Assert
        assertNotNull(actualHmac);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmacWithNullInput() throws Exception {
        // Arrange
        byte[] expectedHmac = new byte[] { 1, 2, 3, 4 };
        // Mocking the behavior of the Mac class when null is passed
        when(mockMac.doFinal(StringUtils.getBytesUtf8(null))).thenReturn(expectedHmac);
        // Act
        byte[] actualHmac = hmacUtils.hmac((String) null);
        // Assert
        assertNotNull(actualHmac);
        assertArrayEquals(expectedHmac, actualHmac);
    }

    @Test
    public void testHmacWithEmptyInput() throws Exception {
        // Arrange
        String valueToDigest = "";
        // Example expected output for empty input
        byte[] expectedHmac = new byte[] { 5, 6, 7, 8 };
        // Mocking the behavior of the Mac class
        when(mockMac.doFinal(StringUtils.getBytesUtf8(valueToDigest))).thenReturn(expectedHmac);
        // Act
        byte[] actualHmac = hmacUtils.hmac(valueToDigest);
        // Assert
        assertNotNull(actualHmac);
        assertArrayEquals(expectedHmac, actualHmac);
    }
}
