package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertEquals;

public class utils_SeekableInMemoryByteChannel_resize_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testResize() {
        // Arrange
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel(new byte[0]);
        int newLength = 1073741823; // This value is >= NAIVE_RESIZE_LIMIT

        // Access the private method using reflection
        try {
            Method resizeMethod = SeekableInMemoryByteChannel.class.getDeclaredMethod("resize", int.class);
            resizeMethod.setAccessible(true);

            // Act
            resizeMethod.invoke(channel, newLength);

            // Assert
            // Since the data is resized, we need to check the length of the data array
            assertEquals(newLength, channel.size()); // Assuming size() method returns the current size of the data
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}