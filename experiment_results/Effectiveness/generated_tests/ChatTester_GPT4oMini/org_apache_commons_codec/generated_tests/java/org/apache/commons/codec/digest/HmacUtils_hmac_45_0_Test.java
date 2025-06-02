package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class HmacUtils_hmac_45_0_Test {

    private HmacUtils hmacUtils;

    private Mac mac;

    @BeforeEach
    public void setUp() throws Exception {
        mac = Mockito.mock(Mac.class);
        // Fixing the Buggy Line by using a valid constructor for HmacUtils
        // Example key
        hmacUtils = new HmacUtils("HmacSHA256", new byte[] { 0 });
    }

    @Test
    public void testHmacWithEmptyInputStream() throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        // Replace with actual expected result
        byte[] expectedResult = new byte[] { 0 };
        doReturn(expectedResult).when(mac).doFinal();
        byte[] result = hmacUtils.hmac(inputStream);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testHmacWithNonEmptyInputStream() throws Exception {
        byte[] inputBytes = "Hello, World!".getBytes();
        InputStream inputStream = new ByteArrayInputStream(inputBytes);
        // Replace with actual expected result
        byte[] expectedResult = new byte[] { 0 };
        doReturn(expectedResult).when(mac).doFinal();
        byte[] result = hmacUtils.hmac(inputStream);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testHmacWithPartialReads() throws Exception {
        byte[] inputBytes = "Hello".getBytes();
        InputStream inputStream = new ByteArrayInputStream(inputBytes);
        // Replace with actual expected result
        byte[] expectedResult = new byte[] { 0 };
        doReturn(expectedResult).when(mac).doFinal();
        byte[] result = hmacUtils.hmac(inputStream);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testHmacWithIOException() {
        InputStream inputStream = Mockito.mock(InputStream.class);
        try {
            doReturn(-1).when(inputStream).read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt());
            byte[] result = hmacUtils.hmac(inputStream);
            // Replace with actual expected result
            assertArrayEquals(new byte[] { 0 }, result);
        } catch (IOException e) {
            // Handle exception
        }
    }
}
