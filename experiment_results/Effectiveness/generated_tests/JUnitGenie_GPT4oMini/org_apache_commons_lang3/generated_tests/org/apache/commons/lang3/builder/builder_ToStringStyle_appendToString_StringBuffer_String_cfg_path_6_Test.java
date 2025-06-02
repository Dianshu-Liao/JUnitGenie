package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_appendToString_StringBuffer_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAppendToStringWithNullToString() {
        // Create an instance of a concrete class that extends ToStringStyle
        ToStringStyle toStringStyle = createToStringStyleInstance();

        StringBuffer buffer = new StringBuffer();
        String toString = null;

        // Call the focal method
        toStringStyle.appendToString(buffer, toString);

        // Verify that the buffer remains unchanged
        assertEquals("", buffer.toString());
    }

    private ToStringStyle createToStringStyleInstance() {
        try {
            // Use reflection to access the protected constructor
            Constructor<? extends ToStringStyle> constructor = ToStringStyle.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create ToStringStyle instance", e);
        }
    }

    // Create a concrete subclass of ToStringStyle for testing
    private static class CustomToStringStyle extends ToStringStyle {
        // You can add any additional methods or fields if necessary
    }

}