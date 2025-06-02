package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_setContentEnd_String_cfg_path_2_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implementing the abstract methods (if any) is necessary for instantiation
        // For this example, we can leave them empty or provide minimal implementations
    }

    @Test(timeout = 4000)
    public void testSetContentEnd() {
        try {
            // Create an instance of the concrete class
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            
            // Access the protected method using reflection
            Method method = ToStringStyle.class.getDeclaredMethod("setContentEnd", String.class);
            method.setAccessible(true);
            
            // Test with a non-null value
            String testContentEnd = "Test Content";
            method.invoke(style, testContentEnd);
            
            // Verify the contentEnd field is set correctly
            String contentEndField = (String) ToStringStyle.class.getDeclaredField("contentEnd").get(style);
            assertEquals(testContentEnd, contentEndField);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}