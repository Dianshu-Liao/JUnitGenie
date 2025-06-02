package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.Channels;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.fail;

public class utils_FixedLengthBlockOutputStream_writeBlock__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteBlock() {
        // Setup
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WritableByteChannel writableByteChannel = Channels.newChannel(byteArrayOutputStream);
        int blockSize = 10; // Example block size
        FixedLengthBlockOutputStream stream = new FixedLengthBlockOutputStream(writableByteChannel, blockSize);
        
        // Prepare the buffer with data
        ByteBuffer buffer = ByteBuffer.allocate(blockSize);
        for (int i = 0; i < blockSize; i++) {
            buffer.put((byte) i);
        }
        buffer.flip(); // Prepare buffer for writing

        // Use reflection to access the private method
        try {
            Method writeBlockMethod = FixedLengthBlockOutputStream.class.getDeclaredMethod("writeBlock");
            writeBlockMethod.setAccessible(true);
            writeBlockMethod.invoke(stream);
        } catch (Exception e) {
            fail("Exception thrown while invoking writeBlock: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteBlockThrowsIOException() {
        // Setup
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WritableByteChannel writableByteChannel = Channels.newChannel(byteArrayOutputStream);
        int blockSize = 10; // Example block size
        FixedLengthBlockOutputStream stream = new FixedLengthBlockOutputStream(writableByteChannel, blockSize);
        
        // Prepare the buffer with insufficient data
        ByteBuffer buffer = ByteBuffer.allocate(blockSize - 1); // Less than blockSize
        for (int i = 0; i < blockSize - 1; i++) {
            buffer.put((byte) i);
        }
        buffer.flip(); // Prepare buffer for writing

        // Use reflection to access the private method
        try {
            Method writeBlockMethod = FixedLengthBlockOutputStream.class.getDeclaredMethod("writeBlock");
            writeBlockMethod.setAccessible(true);
            writeBlockMethod.invoke(stream);
            fail("Expected IOException was not thrown");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                fail("Unexpected exception thrown: " + e.getCause().getMessage());
            }
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}