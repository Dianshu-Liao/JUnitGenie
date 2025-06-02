package org.apache.commons.compress.harmony.archive.internal.nls;

import java.util.Locale;
import java.util.ResourceBundle;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.Objects;

public class Messages_getString_4_0_Test {

    @BeforeAll
    public static void setUp() {
        // Set up a mock ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("testMessages");
        // Assuming this sets the bundle appropriately
        Messages.setLocale(Locale.ENGLISH, "testMessages");
    }

    @Test
    public void testGetStringWithValidKeyAndArgument() {
        // Assuming this key exists in the testMessages bundle
        String msgKey = "greeting";
        String arg = "World";
        // Expected output from the resource bundle
        String expected = "Hello, World";
        String result = Messages.getString(msgKey, arg);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithNullArgument() {
        // Assuming this key exists in the testMessages bundle
        String msgKey = "welcome";
        // Expected output when argument is null
        String expected = "Welcome, null";
        String result = Messages.getString(msgKey, null);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithEmptyKey() {
        // Testing with an empty key
        String msgKey = "";
        String arg = "Test";
        // Expected output for empty key
        String expected = "Test";
        String result = Messages.getString(msgKey, arg);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithNonExistentKey() {
        // Key that does not exist
        String msgKey = "nonExistentKey";
        String arg = "Test";
        // Assuming it returns the key itself if not found
        String expected = "nonExistentKey";
        String result = Messages.getString(msgKey, arg);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithMultipleArguments() {
        // Assuming this key exists in the testMessages bundle
        String msgKey = "greetingWithArgs";
        String arg1 = "John";
        String arg2 = "Doe";
        // Expected output when multiple arguments are used
        String expected = "Hello, John Doe";
        String result = Messages.getString(msgKey, new Object[] { arg1, arg2 });
        assertEquals(expected, result);
    }

    // Reflection to invoke private methods if necessary
    private String invokePrivateMethod(String methodName, Object... args) throws Exception {
        java.lang.reflect.Method method = Messages.class.getDeclaredMethod(methodName, String.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(null, args);
    }
}
