package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_CompareToBuilder_append_byte_byte_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppend_WhenComparisonIsZero_ShouldReturnThis() {
        // Arrange
        CompareToBuilder builder = new CompareToBuilder();
        // Initialize `comparison` to 0, which is the typical starting state
        builder.append((byte) 0, (byte) 0); // Simulating initial setup

        // Act
        CompareToBuilder result = builder.append((byte) 1, (byte) 2);

        // Assert
        assertSame(builder, result);  // should return the same instance
    }

}