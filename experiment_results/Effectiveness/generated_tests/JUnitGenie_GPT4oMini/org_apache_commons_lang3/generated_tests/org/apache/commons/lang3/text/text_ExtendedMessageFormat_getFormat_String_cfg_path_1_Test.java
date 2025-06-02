package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.commons.lang3.text.FormatFactory;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class text_ExtendedMessageFormat_getFormat_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetFormat() {
        try {
            // Prepare the registry with a mock FormatFactory
            Map<String, FormatFactory> registry = new HashMap<>();
            registry.put("testFormat", new FormatFactory() {
                @Override
                public java.text.Format getFormat(String name, String args, Locale locale) {
                    return new java.text.MessageFormat(name + " " + args, locale);
                }
            });

            // Create an instance of ExtendedMessageFormat using reflection
            ExtendedMessageFormat extendedMessageFormat = new ExtendedMessageFormat("test", Locale.ENGLISH, registry);

            // Access the private method getFormat using reflection
            Method method = ExtendedMessageFormat.class.getDeclaredMethod("getFormat", String.class);
            method.setAccessible(true);

            // Call the method with a valid description
            String desc = "testFormat:arg1,arg2";
            Object result = method.invoke(extendedMessageFormat, desc);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}