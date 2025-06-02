package org.apache.commons.jxpath.ri.axes;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_axes_RootContext_setRegisteredValue_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetRegisteredValueWhenRegistersIsNull() {
        // Arrange
        RootContext context = new RootContext(null, null);
        Object value = new Object();

        // Act
        int result = context.setRegisteredValue(value);

        // Assert
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSetRegisteredValueWhenAvailableRegisterIsLessThanMax() {
        // Arrange
        RootContext context = new RootContext(null, null);
        context.setRegisteredValue(new Object()); // Fill the first register
        Object value = new Object();

        // Act
        int result = context.setRegisteredValue(value);

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSetRegisteredValueWhenAvailableRegisterIsMax() {
        // Arrange
        RootContext context = new RootContext(null, null);
        for (int i = 0; i < 4; i++) {
            context.setRegisteredValue(new Object()); // Fill all registers
        }
        Object value = new Object();

        // Act
        int result = context.setRegisteredValue(value);

        // Assert
        assertEquals(-1, result);
    }

}