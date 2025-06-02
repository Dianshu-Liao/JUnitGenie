package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class builder_ToStringStyle_isFullDetail_Boolean_cfg_path_1_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implement abstract methods if necessary
    }

    @Test(timeout = 4000)
    public void testIsFullDetailWithNull() {
        try {
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("isFullDetail", Boolean.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(style, (Boolean) null);
            assertFalse(result); // Assuming defaultFullDetail is false
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsFullDetailWithTrue() {
        try {
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("isFullDetail", Boolean.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(style, Boolean.TRUE);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsFullDetailWithFalse() {
        try {
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            Method method = ToStringStyle.class.getDeclaredMethod("isFullDetail", Boolean.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(style, Boolean.FALSE);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}