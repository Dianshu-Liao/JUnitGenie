package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_append_StringBuffer_String_Object_Boolean_cfg_path_2_Test extends ToStringStyle {

    @Test(timeout = 4000)
    public void testAppendWithNullValue() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = null;
        Boolean fullDetail = false;

        try {
            append(buffer, fieldName, value, fullDetail);
        } catch (Exception e) {
            // Handle the exception if necessary
        }

        String expectedOutput = "testField=null"; // Assuming appendNullText appends "fieldName=null"
        assertEquals(expectedOutput, buffer.toString());
    }

    @Test(timeout = 4000)
    public void testAppendWithNonNullValue() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        Object value = "testValue";
        Boolean fullDetail = true;

        try {
            append(buffer, fieldName, value, fullDetail);
        } catch (Exception e) {
            // Handle the exception if necessary
        }

        String expectedOutput = "testField=testValue"; // Assuming appendInternal appends "fieldName=value"
        assertEquals(expectedOutput, buffer.toString());
    }

}