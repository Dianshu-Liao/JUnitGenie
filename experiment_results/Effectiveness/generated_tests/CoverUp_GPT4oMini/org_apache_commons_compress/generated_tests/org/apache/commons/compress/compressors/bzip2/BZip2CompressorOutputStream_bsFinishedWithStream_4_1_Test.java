package org.apache.commons.compress.compressors.bzip2;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream_bsFinishedWithStream_4_1_Test {

    private BZip2CompressorOutputStream compressorOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        compressorOutputStream = new BZip2CompressorOutputStream(outputStream);
    }

    @Test
    public void testBsFinishedWithStream() throws Exception {
        // Setting up the internal state to test the private method
        // Directly accessing the private fields via reflection
        // 255 in the first byte
        setBsBuff(compressorOutputStream, 0xFF000000);
        // 8 bits to write
        setBsLive(compressorOutputStream, 8);
        // Invoke the private method
        Method method = BZip2CompressorOutputStream.class.getDeclaredMethod("bsFinishedWithStream");
        method.setAccessible(true);
        method.invoke(compressorOutputStream);
        // Verify the output
        // Expecting the first byte to be 255
        byte[] expectedOutput = new byte[] { (byte) 0xFF };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    private void setBsBuff(BZip2CompressorOutputStream compressorOutputStream, int value) throws Exception {
        java.lang.reflect.Field field = BZip2CompressorOutputStream.class.getDeclaredField("bsBuff");
        field.setAccessible(true);
        field.setInt(compressorOutputStream, value);
    }

    private void setBsLive(BZip2CompressorOutputStream compressorOutputStream, int value) throws Exception {
        java.lang.reflect.Field field = BZip2CompressorOutputStream.class.getDeclaredField("bsLive");
        field.setAccessible(true);
        field.setInt(compressorOutputStream, value);
    }
}
