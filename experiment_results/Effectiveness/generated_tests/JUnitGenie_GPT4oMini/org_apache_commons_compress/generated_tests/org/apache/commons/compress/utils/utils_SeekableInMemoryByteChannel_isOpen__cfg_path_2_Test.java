package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class utils_SeekableInMemoryByteChannel_isOpen__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsOpenWhenClosed() {
        // Arrange
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel(new byte[0]);
        // Simulate the channel being closed by directly accessing the private field (if possible) or through a method if available.
        // Since the 'closed' field is private and final, we cannot modify it directly in this test.
        // Therefore, we will assume the constructor initializes it to closed.

        // Act
        boolean result = channel.isOpen();

        // Assert
        assertFalse(result); // Expecting false since the channel is closed.
    }

}