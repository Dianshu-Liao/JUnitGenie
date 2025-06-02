package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class utils_SeekableInMemoryByteChannel_resize_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testResize() {
        try {
            // Initialize a SeekableInMemoryByteChannel with some data
            SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel(new byte[]{1, 2, 3});

            // Access the private resize method using reflection
            Method resizeMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
            resizeMethod.setAccessible(true);

            // Invoke resize method with newLength less than NAIVE_RESIZE_LIMIT
            int newLength = 10; // Assuming NAIVE_RESIZE_LIMIT (1073741823) is a lot larger than this
            resizeMethod.invoke(channel, newLength);

            // Use reflection again to access the private data field
            java.lang.reflect.Field dataField = SeekableInMemoryByteChannel.class.getDeclaredField("data");
            dataField.setAccessible(true);
            byte[] dataAfterResize = (byte[]) dataField.get(channel);

            // Verify that the data is resized correctly
            assertArrayEquals(new byte[10], dataAfterResize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}