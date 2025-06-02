package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_DiffBuilder_append_String_boolean_boolean_cfg_path_1_Test {
    
    @Test(timeout = 4000)
    public void testAppendMethod() {
        // Arrange
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), null);
        String fieldName = "exampleField";
        boolean lhs = true;
        boolean rhs = false;

        // Act
        DiffBuilder result = diffBuilder.append(fieldName, lhs, rhs);
        
        // Assert
        assertNotNull(result);
    }

}