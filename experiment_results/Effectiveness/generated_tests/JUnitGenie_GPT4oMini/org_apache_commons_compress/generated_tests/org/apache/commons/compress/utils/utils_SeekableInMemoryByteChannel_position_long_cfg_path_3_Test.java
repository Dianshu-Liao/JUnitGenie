package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.junit.Test;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import static org.junit.Assert.*;

public class utils_SeekableInMemoryByteChannel_position_long_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPositionValid() {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        try {
            SeekableByteChannel result = channel.position(100);
            assertNotNull(result);
        } catch (IOException e) {
            fail("IOException should not have been thrown for valid position");
        }
    }

    @Test(timeout = 4000)
    public void testPositionNegative() {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        try {
            channel.position(-1);
            fail("Expected IOException for negative position");
        } catch (IOException e) {
            assertEquals("Position must be in range [0..2147483647]", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPositionTooLarge() {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        try {
            channel.position(Long.MAX_VALUE);
            fail("Expected IOException for position greater than Integer.MAX_VALUE");
        } catch (IOException e) {
            assertEquals("Position must be in range [0..2147483647]", e.getMessage());
        }
    }


}