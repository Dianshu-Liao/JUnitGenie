package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;
import static org.junit.Assert.assertNull;

public class text_ExtendedMessageFormat_getFormat_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetFormatWithNullRegistry() {
        try {
            // Create an instance of ExtendedMessageFormat with a null registry
            ExtendedMessageFormat format = new ExtendedMessageFormat("test");

            // Use reflection to access the private method getFormat
            Method method = ExtendedMessageFormat.class.getDeclaredMethod("getFormat", String.class);
            method.setAccessible(true);

            // Call the method with a sample input
            Object result = method.invoke(format, "sampleDesc");

            // Assert that the result is null since the registry is not initialized
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}