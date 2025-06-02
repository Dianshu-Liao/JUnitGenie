package org.apache.commons.codec.digest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.security.Key;

class HmacUtils_hmac_44_0_Test {

    private HmacUtils hmacUtils;

    private Mac mockMac;

    @BeforeEach
    void setUp() throws Exception {
        // Mock the Mac instance
        mockMac = mock(Mac.class);
        when(mockMac.doFinal()).thenReturn(new byte[] { 1, 2, 3, 4, 5 });
        // Use reflection to create an instance of HmacUtils with the private constructor
        hmacUtils = createHmacUtilsInstance(mockMac);
    }

    private HmacUtils createHmacUtilsInstance(Mac mac) throws Exception {
        // Use reflection to access the private constructor
        java.lang.reflect.Constructor<HmacUtils> constructor = HmacUtils.class.getDeclaredConstructor(Mac.class);
        constructor.setAccessible(true);
        return constructor.newInstance(mac);
    }

    @Test
    void testHmacWithValidFile() throws Exception {
        // Create a temporary file with some content
        File tempFile = File.createTempFile("testFile", ".txt");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write("test content".getBytes(StandardCharsets.UTF_8));
        }
        // Call the hmac method
        byte[] result = hmacUtils.hmac(tempFile);
        // Verify the result
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, result);
        // Verify that mac.update was called with the correct data
        verify(mockMac, times(1)).update(any(byte[].class), anyInt(), anyInt());
        verify(mockMac, times(1)).doFinal();
    }

    @Test
    void testHmacWithEmptyFile() throws Exception {
        // Create a temporary empty file
        File tempFile = File.createTempFile("emptyFile", ".txt");
        // Call the hmac method
        byte[] result = hmacUtils.hmac(tempFile);
        // Verify the result
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, result);
        // Verify that mac.update was called with no data
        verify(mockMac, times(1)).update(any(byte[].class), anyInt(), anyInt());
        verify(mockMac, times(1)).doFinal();
    }

    @Test
    void testHmacWithIOException() {
        // Create a file that does not exist
        File nonExistentFile = new File("nonExistentFile.txt");
        // Call the hmac method and expect an IOException
        assertThrows(IOException.class, () -> {
            hmacUtils.hmac(nonExistentFile);
        });
    }
}
