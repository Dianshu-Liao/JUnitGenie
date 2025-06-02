package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_MultilineRecursiveToStringStyle_appendDetail_StringBuffer_String_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendDetailWithNonPrimitiveWrapper() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = new Object(); // Non-primitive wrapper object

        try {
            style.appendDetail(buffer, fieldName, value);
            // Validate the output in the buffer
            String expectedOutput = "Object details"; // Replace with expected output based on ReflectionToStringBuilder.toString(value, style)
            assertEquals(expectedOutput, buffer.toString());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAppendDetailWithString() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = "testString"; // String object

        try {
            style.appendDetail(buffer, fieldName, value);
            // Validate the output in the buffer
            String expectedOutput = "testString"; // Expected output for String
            assertEquals(expectedOutput, buffer.toString());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}