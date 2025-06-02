package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ByteArrayBuilder_append_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppend() {
        ByteArrayBuilder builder = new ByteArrayBuilder(10); // Initialize with a capacity of 10
        builder.append(65); // Append a value (ASCII for 'A')

        // Access the private field _currBlockPtr using reflection
        try {
            java.lang.reflect.Field currBlockPtrField = ByteArrayBuilder.class.getDeclaredField("_currBlockPtr");
            currBlockPtrField.setAccessible(true);
            int currBlockPtr = (int) currBlockPtrField.get(builder);
            assertEquals(1, currBlockPtr); // Check if the pointer has moved to 1

            // Access the private field _currBlock using reflection
            java.lang.reflect.Field currBlockField = ByteArrayBuilder.class.getDeclaredField("_currBlock");
            currBlockField.setAccessible(true);
            byte[] currBlock = (byte[]) currBlockField.get(builder);
            assertEquals(65, currBlock[0]); // Check if the first element is 65 (byte representation of 'A')
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }

}