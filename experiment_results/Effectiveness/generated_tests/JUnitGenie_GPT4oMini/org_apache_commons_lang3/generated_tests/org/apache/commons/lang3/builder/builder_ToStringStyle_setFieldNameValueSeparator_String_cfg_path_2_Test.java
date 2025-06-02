package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_setFieldNameValueSeparator_String_cfg_path_2_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implement abstract methods if necessary
        @Override
        public String toString() {
            return "ConcreteToStringStyle{}";
        }
    }

    @Test(timeout = 4000)
    public void testSetFieldNameValueSeparator() {
        try {
            // Create an instance of the concrete class
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            
            // Access the protected method using reflection
            Method method = ToStringStyle.class.getDeclaredMethod("setFieldNameValueSeparator", String.class);
            method.setAccessible(true);
            
            // Test with a non-null value
            String separator = ",";
            method.invoke(style, separator);
            
            // Use reflection to access the private field
            Method getFieldNameValueSeparatorMethod = ToStringStyle.class.getDeclaredMethod("getFieldNameValueSeparator");
            getFieldNameValueSeparatorMethod.setAccessible(true);
            String actualSeparator = (String) getFieldNameValueSeparatorMethod.invoke(style);
            
            assertEquals(separator, actualSeparator);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}