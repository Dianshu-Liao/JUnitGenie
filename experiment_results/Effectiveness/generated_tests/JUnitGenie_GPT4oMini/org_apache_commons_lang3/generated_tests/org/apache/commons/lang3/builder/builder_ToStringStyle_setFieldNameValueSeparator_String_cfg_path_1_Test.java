package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_setFieldNameValueSeparator_String_cfg_path_1_Test {

    private static class ConcreteToStringStyle extends ToStringStyle {
        // Implement any abstract methods if needed
    }

    @Test(timeout = 4000)
    public void testSetFieldNameValueSeparatorWithNull() {
        try {
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("setFieldNameValueSeparator", String.class);
            method.setAccessible(true); // Allow access to the protected method
            method.invoke(style, (String) null); // Invoke with null to test the CFG path

            // Verify that the fieldNameValueSeparator is set to EMPTY
            Field field = ToStringStyle.class.getDeclaredField("fieldNameValueSeparator");
            field.setAccessible(true); // Allow access to the private field
            String result = (String) field.get(style);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSetFieldNameValueSeparatorWithNonNull() {
        try {
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("setFieldNameValueSeparator", String.class);
            method.setAccessible(true); // Allow access to the protected method
            method.invoke(style, "="); // Invoke with non-null value

            // Verify that the fieldNameValueSeparator is set to "="
            Field field = ToStringStyle.class.getDeclaredField("fieldNameValueSeparator");
            field.setAccessible(true); // Allow access to the private field
            String result = (String) field.get(style);
            assertEquals("=", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}