package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class utils_SeekableInMemoryByteChannel_position_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPositionThrowsIOExceptionForNegativePosition() {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        try {
            channel.position(-1L);
            fail("Expected IOException for negative position");
        } catch (IOException e) {
            assertEquals("Position must be in range [0..2147483647]", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPositionThrowsIOExceptionForPositionGreaterThanMax() {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        try {
            channel.position(Long.MAX_VALUE);
            fail("Expected IOException for position greater than Integer.MAX_VALUE");
        } catch (IOException e) {
            assertEquals("Position must be in range [0..2147483647]", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPositionValid() throws IOException {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        channel.position(100); // No exception should be thrown
        assertEquals(100, channel.position(100).position());
    }

}