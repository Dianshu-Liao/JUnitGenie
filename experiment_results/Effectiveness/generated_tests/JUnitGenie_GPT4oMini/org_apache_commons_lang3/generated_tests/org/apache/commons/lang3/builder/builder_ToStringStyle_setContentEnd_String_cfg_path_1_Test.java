package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_setContentEnd_String_cfg_path_1_Test {

    private class ToStringStyleImpl extends ToStringStyle {
        // Implement abstract methods if needed but for this test we only need to access setContentEnd
    }

    @Test(timeout = 4000)
    public void testSetContentEnd_WithNull() {
        try {
            // Create an instance of the concrete class
            ToStringStyleImpl toStringStyle = new ToStringStyleImpl();
            
            // Access the protected method using reflection
            Method setContentEndMethod = ToStringStyle.class.getDeclaredMethod("setContentEnd", String.class);
            setContentEndMethod.setAccessible(true);
            
            // Call the method with null to simulate the test case
            setContentEndMethod.invoke(toStringStyle, (String) null);
            
            // Verify that contentEnd is set to EMPTY
            String contentEndValue = (String) ToStringStyle.class.getDeclaredField("contentEnd").get(toStringStyle);
            assertEquals("", contentEndValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSetContentEnd_WithNonNull() {
        try {
            // Create an instance of the concrete class
            ToStringStyleImpl toStringStyle = new ToStringStyleImpl();
            
            // Access the protected method using reflection
            Method setContentEndMethod = ToStringStyle.class.getDeclaredMethod("setContentEnd", String.class);
            setContentEndMethod.setAccessible(true);
            
            // Call the method with a valid string
            String testValue = "Test Content End";
            setContentEndMethod.invoke(toStringStyle, testValue);
            
            // Verify that contentEnd is set to the test value
            String contentEndValue = (String) ToStringStyle.class.getDeclaredField("contentEnd").get(toStringStyle);
            assertEquals(testValue, contentEndValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}