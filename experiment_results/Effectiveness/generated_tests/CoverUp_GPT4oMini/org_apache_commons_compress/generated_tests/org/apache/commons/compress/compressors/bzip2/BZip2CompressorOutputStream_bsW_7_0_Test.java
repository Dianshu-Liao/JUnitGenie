package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class BZip2CompressorOutputStream_bsW_7_0_Test {

    private BZip2CompressorOutputStream compressorOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        compressorOutputStream = new BZip2CompressorOutputStream(outputStream);
    }

    @Test
    void testBsW() throws Exception {
        // Prepare parameters
        // Number of bits to write
        int n = 8;
        // Value to write
        int v = 0b10101010;
        // Use reflection to access the private method
        Method bsWMethod = BZip2CompressorOutputStream.class.getDeclaredMethod("bsW", int.class, int.class);
        bsWMethod.setAccessible(true);
        // Call the method
        bsWMethod.invoke(compressorOutputStream, n, v);
        // Verify the output
        byte[] expectedOutput = { (byte) 0b10101010 };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
        // Test boundary condition where bsLive is exactly 8
        // Clear the output stream
        outputStream.reset();
        // Number of bits to write
        n = 8;
        // Value to write
        v = 0b11111111;
        // Call the method again
        bsWMethod.invoke(compressorOutputStream, n, v);
        // Verify the output
        expectedOutput = new byte[] { (byte) 0b11111111 };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
        // Test when bsLive is more than 8
        // Clear the output stream
        outputStream.reset();
        // Number of bits to write
        n = 16;
        // Value to write
        v = 0b1111111111111111;
        // Call the method again
        bsWMethod.invoke(compressorOutputStream, n, v);
        // Verify the output
        expectedOutput = new byte[] { (byte) 0b11111111, (byte) 0b11111111 };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }
}
