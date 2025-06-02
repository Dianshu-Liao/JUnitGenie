package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream_bsFinishedWithStream_4_0_Test {

    private BZip2CompressorOutputStream bZip2CompressorOutputStream;

    private ByteArrayOutputStream outputStream;

//    @BeforeEach
//    public void setUp() throws IOException {
//        outputStream = new ByteArrayOutputStream();
//        bZip2CompressorOutputStream = new BZip2CompressorOutputStream(outputStream);
//    }

    @Test
    public void testBsFinishedWithStream_SingleByte() throws Exception {
        // Set private fields using reflection
        // 255 in the first byte
        setPrivateField(bZip2CompressorOutputStream, "bsBuff", 0xFF000000);
        // 8 bits to write
        setPrivateField(bZip2CompressorOutputStream, "bsLive", 8);
        // Invoke the private method
        Method method = BZip2CompressorOutputStream.class.getDeclaredMethod("bsFinishedWithStream");
        method.setAccessible(true);
        method.invoke(bZip2CompressorOutputStream);
        // Verify the output
        assertEquals(1, outputStream.size());
        assertEquals((byte) 0xFF, outputStream.toByteArray()[0]);
    }

    @Test
    public void testBsFinishedWithStream_MultipleBytes() throws Exception {
        // Set private fields for multiple bytes
        // 255 in all four bytes
        setPrivateField(bZip2CompressorOutputStream, "bsBuff", 0xFFFFFFFF);
        // 32 bits to write
        setPrivateField(bZip2CompressorOutputStream, "bsLive", 32);
        // Invoke the private method
        Method method = BZip2CompressorOutputStream.class.getDeclaredMethod("bsFinishedWithStream");
        method.setAccessible(true);
        method.invoke(bZip2CompressorOutputStream);
        // Verify the output
        byte[] output = outputStream.toByteArray();
        assertEquals(4, output.length);
        assertEquals((byte) 0xFF, output[0]);
        assertEquals((byte) 0xFF, output[1]);
        assertEquals((byte) 0xFF, output[2]);
        assertEquals((byte) 0xFF, output[3]);
    }

    @Test
    public void testBsFinishedWithStream_NoBitsToWrite() throws Exception {
        // Set private fields with no bits to write
        // No data
        setPrivateField(bZip2CompressorOutputStream, "bsBuff", 0x00000000);
        // 0 bits to write
        setPrivateField(bZip2CompressorOutputStream, "bsLive", 0);
        // Invoke the private method
        Method method = BZip2CompressorOutputStream.class.getDeclaredMethod("bsFinishedWithStream");
        method.setAccessible(true);
        method.invoke(bZip2CompressorOutputStream);
        // Verify the output
        assertEquals(0, outputStream.size());
    }

    private void setPrivateField(Object obj, String fieldName, int value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(obj, value);
    }
}
