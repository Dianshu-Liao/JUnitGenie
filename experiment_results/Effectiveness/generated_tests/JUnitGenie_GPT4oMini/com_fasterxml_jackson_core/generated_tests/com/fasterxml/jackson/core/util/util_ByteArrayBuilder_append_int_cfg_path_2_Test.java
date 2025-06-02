package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ByteArrayBuilder_append_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWhenAllocMoreIsCalled() {
        // Arrange
        ByteArrayBuilder builder = new ByteArrayBuilder(1); // Initialize with a small size
        builder.append(100); // Fill the first block

        // Act
        try {
            builder.append(200); // This should trigger _allocMore()
        } catch (Exception e) {
            fail("Exception should not be thrown during append: " + e.getMessage());
        }

        // Assert
        // Verify that the second byte was added correctly
        // Since we cannot directly access _currBlock, we would need to use reflection or additional methods to verify
    }

    @Test(timeout = 4000)
    public void testAppendWithValidInput() {
        // Arrange
        ByteArrayBuilder builder = new ByteArrayBuilder(2); // Initialize with a size of 2
        builder.append(50); // Fill the first block
        builder.append(100); // Fill the second block

        // Act
        try {
            builder.append(150); // This should not trigger _allocMore()
        } catch (Exception e) {
            fail("Exception should not be thrown during append: " + e.getMessage());
        }

        // Assert
        // Verify that the bytes were added correctly
        // Again, we would need to use reflection or additional methods to verify
    }

}