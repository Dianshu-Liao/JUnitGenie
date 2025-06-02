package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_MultilineRecursiveToStringStyle_appendDetail_StringBuffer_String_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAppendDetail_withNonPrimitiveAndNonStringValue() {
        // Arrange
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = new Object(); // A non-primitive and non-string object

        try {
            // Act
            style.appendDetail(buffer, fieldName, value);
            
            // Assert
            assertNotNull(buffer.toString()); // Check that something was appended to the buffer
            assertTrue(buffer.toString().contains("testField")); // Ensure the field name is part of the output
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}