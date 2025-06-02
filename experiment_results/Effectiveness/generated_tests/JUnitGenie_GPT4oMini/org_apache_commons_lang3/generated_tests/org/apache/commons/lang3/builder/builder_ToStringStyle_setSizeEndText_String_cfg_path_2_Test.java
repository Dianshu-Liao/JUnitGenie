package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_setSizeEndText_String_cfg_path_2_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implement abstract methods if necessary
    }

    @Test(timeout = 4000)
    public void testSetSizeEndText() {
        try {
            // Create an instance of the concrete class
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            
            // Access the protected method using reflection
            Method method = ToStringStyle.class.getDeclaredMethod("setSizeEndText", String.class);
            method.setAccessible(true);
            
            // Test with a non-null value
            String testValue = "Test Size End Text";
            method.invoke(style, testValue);
            // Use reflection to access the private field sizeEndText
            Method getSizeEndTextMethod = ToStringStyle.class.getDeclaredMethod("getSizeEndText");
            getSizeEndTextMethod.setAccessible(true);
            assertEquals(testValue, getSizeEndTextMethod.invoke(style));
            
            // Test with a null value
            method.invoke(style, (String) null);
            assertEquals("", getSizeEndTextMethod.invoke(style)); // Should be empty string as per the method logic
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}