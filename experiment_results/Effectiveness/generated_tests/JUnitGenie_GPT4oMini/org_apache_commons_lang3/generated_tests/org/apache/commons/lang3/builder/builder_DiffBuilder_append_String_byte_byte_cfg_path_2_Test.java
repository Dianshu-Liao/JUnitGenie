package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_DiffBuilder_append_String_byte_byte_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentBytes() {
        // Arrange
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.SHORT_PREFIX_STYLE);
        String fieldName = "testField";
        byte lhs = 1;
        byte rhs = 2;

        // Act
        DiffBuilder result = diffBuilder.append(fieldName, lhs, rhs);

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualBytes() {
        // Arrange
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.SHORT_PREFIX_STYLE);
        String fieldName = "testField";
        byte lhs = 1;
        byte rhs = 1;

        // Act
        DiffBuilder result = diffBuilder.append(fieldName, lhs, rhs);

        // Assert
        assertEquals(diffBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualsField() {
        // Arrange
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.SHORT_PREFIX_STYLE);
        String fieldName = "testField";
        byte lhs = 1;
        byte rhs = 2;

        // Set the equals field to true
        try {
            java.lang.reflect.Field equalsField = DiffBuilder.class.getDeclaredField("equals");
            equalsField.setAccessible(true);
            equalsField.set(diffBuilder, true);
        } catch (Exception e) {
            fail("Failed to set equals field: " + e.getMessage());
        }

        // Act
        DiffBuilder result = diffBuilder.append(fieldName, lhs, rhs);

        // Assert
        assertEquals(diffBuilder, result);
    }

}