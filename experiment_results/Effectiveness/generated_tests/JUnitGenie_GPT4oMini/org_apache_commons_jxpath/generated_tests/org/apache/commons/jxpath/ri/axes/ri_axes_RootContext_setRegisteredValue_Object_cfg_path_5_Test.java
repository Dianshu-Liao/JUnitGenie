package org.apache.commons.jxpath.ri.axes;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_axes_RootContext_setRegisteredValue_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSetRegisteredValue() {
        // Arrange
        RootContext context = new RootContext(null, null);
        Object testValue = new Object();

        // Act
        int result = context.setRegisteredValue(testValue);

        // Assert
        assertEquals(0, result); // The first available register should be 0
    }

    @Test(timeout = 4000)
    public void testSetRegisteredValueWhenRegistersAreNull() {
        // Arrange
        RootContext context = new RootContext(null, null);
        Object testValue = new Object();

        // Act
        int result = context.setRegisteredValue(testValue);

        // Assert
        assertEquals(0, result); // The first available register should be 0
    }

    @Test(timeout = 4000)
    public void testSetRegisteredValueWhenAvailableRegisterIsMax() {
        // Arrange
        RootContext context = new RootContext(null, null);
        for (int i = 0; i < 4; i++) {
            context.setRegisteredValue(new Object()); // Fill the registers
        }

        // Act
        int result = context.setRegisteredValue(new Object()); // This should return -1

        // Assert
        assertEquals(-1, result); // Should indicate no available register
    }

}