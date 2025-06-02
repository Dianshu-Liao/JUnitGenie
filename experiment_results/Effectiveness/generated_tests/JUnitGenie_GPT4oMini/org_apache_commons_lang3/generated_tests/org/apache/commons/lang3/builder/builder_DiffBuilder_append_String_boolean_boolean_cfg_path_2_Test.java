package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_DiffBuilder_append_String_boolean_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLhsAndRhs() {
        // Arrange
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.DEFAULT_STYLE);
        String fieldName = "testField";
        boolean lhs = true;
        boolean rhs = false;

        // Act
        DiffBuilder result = diffBuilder.append(fieldName, lhs, rhs);

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualLhsAndRhs() {
        // Arrange
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.DEFAULT_STYLE);
        String fieldName = "testField";
        boolean lhs = true;
        boolean rhs = true;

        // Act
        DiffBuilder result = diffBuilder.append(fieldName, lhs, rhs);

        // Assert
        assertEquals(diffBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualsField() {
        // Arrange
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.DEFAULT_STYLE);
        String fieldName = "testField";
        boolean lhs = false;
        boolean rhs = true;

        // Act
        DiffBuilder result = diffBuilder.append(fieldName, lhs, rhs);

        // Assert
        assertNotNull(result);
    }

}