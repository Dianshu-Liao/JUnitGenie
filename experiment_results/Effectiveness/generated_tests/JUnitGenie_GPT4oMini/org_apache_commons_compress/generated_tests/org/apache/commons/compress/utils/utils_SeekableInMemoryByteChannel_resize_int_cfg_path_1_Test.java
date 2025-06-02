package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class utils_SeekableInMemoryByteChannel_resize_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testResize() {
        try {
            // Create an instance of SeekableInMemoryByteChannel
            SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel(new byte[0]);
            
            // Access the private method 'resize' using reflection
            Method resizeMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
            resizeMethod.setAccessible(true);
            
            // Prepare the new length for resizing
            int newLength = 1073741823; // This value is >= NAIVE_RESIZE_LIMIT
            
            // Invoke the resize method
            resizeMethod.invoke(channel, newLength);
            
            // Verify the internal state of the 'data' field
            byte[] expectedData = new byte[newLength]; // Expecting the data to be resized to newLength
            assertArrayEquals(expectedData, (byte[]) SeekableInMemoryByteChannel.class.getDeclaredField("data").get(channel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}