package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_MultilineRecursiveToStringStyle_appendDetail_StringBuffer_String_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendDetailWithNonWrapperClass() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = new Object(); // Non-wrapper class

        try {
            style.appendDetail(buffer, fieldName, value);
            assertNotNull(buffer.toString());
        } catch (Exception e) {
            fail("Exception should not have been thrown for non-wrapper class");
        }
    }

    @Test(timeout = 4000)
    public void testAppendDetailWithString() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = "testValue"; // String is a valid case

        try {
            style.appendDetail(buffer, fieldName, value);
            assertNotNull(buffer.toString());
        } catch (Exception e) {
            fail("Exception should not have been thrown for String value");
        }
    }

    @Test(timeout = 4000)
    public void testAppendDetailWithPrimitiveWrapper() {
        MultilineRecursiveToStringStyle style = new MultilineRecursiveToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = Integer.valueOf(5); // Wrapper class

        try {
            style.appendDetail(buffer, fieldName, value);
            assertTrue(buffer.length() == 0); // Should call super and not append
        } catch (Exception e) {
            fail("Exception should not have been thrown for wrapper class");
        }
    }

}