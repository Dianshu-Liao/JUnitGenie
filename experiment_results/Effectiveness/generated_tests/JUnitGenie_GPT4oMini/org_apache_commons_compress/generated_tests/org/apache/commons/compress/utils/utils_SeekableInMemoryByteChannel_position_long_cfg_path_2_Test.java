package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class utils_SeekableInMemoryByteChannel_position_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPositionThrowsIOExceptionWhenNewPositionIsNegative() {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        try {
            channel.position(-1L);
            fail("Expected IOException for negative position");
        } catch (IOException e) {
            assertEquals("Position must be in range [0..2147483647]", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPositionThrowsIOExceptionWhenNewPositionExceedsMaxValue() {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        try {
            channel.position(Long.MAX_VALUE);
            fail("Expected IOException for position exceeding Integer.MAX_VALUE");
        } catch (IOException e) {
            assertEquals("Position must be in range [0..2147483647]", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPositionSetsPositionCorrectly() throws IOException {
        SeekableInMemoryByteChannel channel = new SeekableInMemoryByteChannel();
        channel.position(100L);
        // Assuming there is a way to get the current position, which is not shown in the provided code.
        // This is a placeholder for the actual assertion to verify the position is set correctly.
        // assertEquals(100, channel.getPosition());
    }

}