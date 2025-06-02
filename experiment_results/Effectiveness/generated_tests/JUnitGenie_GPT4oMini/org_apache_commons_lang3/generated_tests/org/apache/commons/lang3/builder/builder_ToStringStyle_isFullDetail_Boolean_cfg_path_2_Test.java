package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import static org.junit.Assert.assertTrue;

public class builder_ToStringStyle_isFullDetail_Boolean_cfg_path_2_Test {

    private class TestToStringStyle extends ToStringStyle {
        // Implementing the abstract methods if any are required
    }

    @Test(timeout = 4000)
    public void testIsFullDetailWithNull() {
        try {
            TestToStringStyle style = new TestToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("isFullDetail", Boolean.class);
            method.setAccessible(true);
            
            // Accessing the private field defaultFullDetail
            Field field = ToStringStyle.class.getDeclaredField("defaultFullDetail");
            field.setAccessible(true);
            field.setBoolean(style, true); // Setting the defaultFullDetail to true
            
            // Invoking the method with null
            boolean result = (Boolean) method.invoke(style, (Boolean) null);
            assertTrue(result); // Expecting true since defaultFullDetail is true
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsFullDetailWithTrue() {
        try {
            TestToStringStyle style = new TestToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("isFullDetail", Boolean.class);
            method.setAccessible(true);
            
            // Invoking the method with true
            boolean result = (Boolean) method.invoke(style, Boolean.TRUE);
            assertTrue(result); // Expecting true
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsFullDetailWithFalse() {
        try {
            TestToStringStyle style = new TestToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("isFullDetail", Boolean.class);
            method.setAccessible(true);
            
            // Invoking the method with false
            boolean result = (Boolean) method.invoke(style, Boolean.FALSE);
            assertTrue(!result); // Expecting false
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}