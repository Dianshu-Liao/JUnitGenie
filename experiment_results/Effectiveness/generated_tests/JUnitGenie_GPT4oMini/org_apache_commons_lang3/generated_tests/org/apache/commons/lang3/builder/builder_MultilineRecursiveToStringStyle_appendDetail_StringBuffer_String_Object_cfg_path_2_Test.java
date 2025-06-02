package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_MultilineRecursiveToStringStyle_appendDetail_StringBuffer_String_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendDetailWithNonPrimitiveWrapper() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = new Object(); // Non-primitive wrapper object

        try {
            style.appendDetail(buffer, fieldName, value);
            // Verify the buffer content after appending
            assertNotNull(buffer.toString());
            assertTrue(buffer.toString().contains("testField"));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendDetailWithString() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = "testValue"; // String value

        try {
            style.appendDetail(buffer, fieldName, value);
            // Verify the buffer content after appending
            assertNotNull(buffer.toString());
            assertTrue(buffer.toString().contains("testField"));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendDetailWithPrimitiveWrapper() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = Integer.valueOf(5); // Primitive wrapper object

        try {
            style.appendDetail(buffer, fieldName, value);
            // Verify the buffer content after appending
            assertNotNull(buffer.toString());
            assertTrue(buffer.toString().contains("testField"));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}