package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.lang.reflect.Field;

public class util_ByteArrayBuilder_reset__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReset() {
        // Arrange
        ByteArrayBuilder builder = new ByteArrayBuilder();
        // Simulate some state before reset
        builder.append((byte) 1); // Correcting the append method to accept a single byte
        builder.append((byte) 2);
        builder.append((byte) 3);

        // Act
        builder.reset();

        // Assert
        // Check that _pastLen and _currBlockPtr are reset to 0
        // Using reflection to access private fields
        try {
            Field pastLenField = ByteArrayBuilder.class.getDeclaredField("_pastLen");
            pastLenField.setAccessible(true);
            int pastLen = (int) pastLenField.get(builder);
            assertTrue(pastLen == 0);

            Field currBlockPtrField = ByteArrayBuilder.class.getDeclaredField("_currBlockPtr");
            currBlockPtrField.setAccessible(true);
            int currBlockPtr = (int) currBlockPtrField.get(builder);
            assertTrue(currBlockPtr == 0);

            Field pastBlocksField = ByteArrayBuilder.class.getDeclaredField("_pastBlocks");
            pastBlocksField.setAccessible(true);
            List<byte[]> pastBlocks = (List<byte[]>) pastBlocksField.get(builder); // Changed to List
            assertTrue(pastBlocks.isEmpty());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}