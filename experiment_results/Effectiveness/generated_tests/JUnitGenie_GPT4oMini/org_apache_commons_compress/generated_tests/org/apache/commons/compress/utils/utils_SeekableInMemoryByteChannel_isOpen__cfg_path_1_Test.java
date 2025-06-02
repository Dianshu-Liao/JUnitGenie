package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class utils_SeekableInMemoryByteChannel_isOpen__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsOpen() {
        // Create an instance of SeekableInMemoryByteChannel
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();

        // Since the 'closed' variable is initialized to false by default,
        // calling isOpen() should return true. We need to set it to true to test the isOpen() method.
        try {
            // Access the private 'closed' field using reflection to set it to true
            java.lang.reflect.Field closedField = SeekableInMemoryByteChannel.class.getDeclaredField("closed");
            closedField.setAccessible(true);
            java.util.concurrent.atomic.AtomicBoolean closed = (java.util.concurrent.atomic.AtomicBoolean) closedField.get(channel);
            closed.set(true); // Set closed to true

            // Now, isOpen() should return false
            assertFalse(channel.isOpen());
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}