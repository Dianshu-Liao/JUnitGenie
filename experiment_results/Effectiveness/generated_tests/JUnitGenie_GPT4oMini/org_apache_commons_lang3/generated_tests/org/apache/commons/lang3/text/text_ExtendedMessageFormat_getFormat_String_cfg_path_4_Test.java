package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.commons.lang3.text.FormatFactory;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import static org.junit.Assert.assertNull;

public class text_ExtendedMessageFormat_getFormat_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetFormatReturnsNullWhenRegistryIsNull() {
        try {
            // Create an instance of ExtendedMessageFormat with a null registry
            Map<String, FormatFactory> registry = null;
            ExtendedMessageFormat format = new ExtendedMessageFormat("test", Locale.ENGLISH, registry);
            
            // Access the private method getFormat using reflection
            Method method = ExtendedMessageFormat.class.getDeclaredMethod("getFormat", String.class);
            method.setAccessible(true);
            
            // Call the method with a test description
            String desc = "test";
            Object result = method.invoke(format, desc);
            
            // Assert the result is null as expected
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetFormatReturnsNullWhenFactoryIsNull() {
        try {
            // Create a mock registry with a factory entry for testing
            Map<String, FormatFactory> registry = new HashMap<>();
            registry.put("test", null); // Simulating a null factory
            
            ExtendedMessageFormat format = new ExtendedMessageFormat("test", Locale.ENGLISH, registry);
            
            // Access the private method getFormat using reflection
            Method method = ExtendedMessageFormat.class.getDeclaredMethod("getFormat", String.class);
            method.setAccessible(true);

            // Call the method with a test description
            String desc = "test";
            Object result = method.invoke(format, desc);

            // Assert that the result is null as the factory is null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Additional tests for different conditions can be added here...

}