package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_appendDetail_StringBuffer_String_int_____cfg_path_1_Test {

    private static class TestToStringStyle extends ToStringStyle {
        // A concrete implementation needed for instantiation
        protected TestToStringStyle() {
            super();
        }
    }

    @Test(timeout = 4000)
    public void testAppendDetail() {
        try {
            // Creating an instance of the concrete class
            TestToStringStyle style = new TestToStringStyle();

            // Prepare test data
            StringBuffer buffer = new StringBuffer();
            String fieldName = "testField";
            int[] array = {1, 2, 3};

            // Accessing the protected method using reflection
            java.lang.reflect.Method method = ToStringStyle.class.getDeclaredMethod("appendDetail", StringBuffer.class, String.class, int[].class);
            method.setAccessible(true);
            method.invoke(style, buffer, fieldName, array);

            // Validate the result
            String expected = "{1,2,3}";
            assertEquals(expected, buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}