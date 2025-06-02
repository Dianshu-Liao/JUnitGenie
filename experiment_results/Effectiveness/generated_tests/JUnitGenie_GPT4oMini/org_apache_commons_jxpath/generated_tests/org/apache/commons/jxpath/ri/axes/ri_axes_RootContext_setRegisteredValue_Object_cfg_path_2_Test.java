package org.apache.commons.jxpath.ri.axes;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_axes_RootContext_setRegisteredValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetRegisteredValue() {
        // Arrange
        RootContext context = new RootContext(null, null);
        
        // Act
        int result1 = context.setRegisteredValue(RootContext.UNKNOWN_VALUE);
        int result2 = context.setRegisteredValue(new Object());
        int result3 = context.setRegisteredValue(new Object());

        // Assert
        assertEquals(0, result1); // First entry should be index 0
        assertEquals(1, result2); // Second entry should be index 1
        assertEquals(2, result3); // Third entry should be index 2
    }

    @Test(timeout = 4000)
    public void testSetRegisteredValueWhenFull() {
        // Arrange
        RootContext context = new RootContext(null, null);
        context.setRegisteredValue(RootContext.UNKNOWN_VALUE);
        context.setRegisteredValue(new Object());
        context.setRegisteredValue(new Object());
        context.setRegisteredValue(new Object()); // Filling the register

        // Act
        int result = context.setRegisteredValue(new Object()); // Attempt to exceed max
        
        // Assert
        assertEquals(-1, result); // Should return -1, indicating no available slots
    }

}