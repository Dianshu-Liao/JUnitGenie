package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import java.util.function.Supplier;
import static org.junit.Assert.assertEquals;

public class ObjectUtils_toString_Object_Supplier_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToString_WithNonNullObject() {
        // Arrange
        Object obj = new Object() {
            @Override
            public String toString() {
                return "Custom Object";
            }
        };
        Supplier<String> supplier = () -> "Default String";

        // Act
        String result = ObjectUtils.toString(obj, supplier);

        // Assert
        assertEquals("Custom Object", result);
    }

    @Test(timeout = 4000)
    public void testToString_WithNullObject() {
        // Arrange
        Object obj = null;
        Supplier<String> supplier = () -> "Default String";

        // Act
        String result = ObjectUtils.toString(obj, supplier);

        // Assert
        assertEquals("Default String", result);
    }

}