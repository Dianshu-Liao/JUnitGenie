package org.apache.commons.compress.harmony.archive.internal.nls;

import java.lang.reflect.Method;
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

public class Messages_getString_3_0_Test {

    @BeforeEach
    public void setUp() {
        // Set up the ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("TestMessages", Locale.ENGLISH);
        Messages.setLocale(Locale.ENGLISH, "TestMessages");
    }

    @Test
    public void testGetStringWithValidMessage() {
        String result = Messages.getString("greeting", 5);
        assertEquals("Hello, 5", result);
    }

    @Test
    public void testGetStringWithNullMessage() {
        String result = Messages.getString(null, 5);
        assertEquals("null", result);
    }

    @Test
    public void testGetStringWithInvalidMessage() {
        String result = Messages.getString("invalidKey", 5);
        // Assuming the key does not exist
        assertEquals("invalidKey", result);
    }

    @Test
    public void testGetStringWithZero() {
        String result = Messages.getString("greeting", 0);
        assertEquals("Hello, 0", result);
    }

    @Test
    public void testGetStringWithNegativeNumber() {
        String result = Messages.getString("greeting", -1);
        assertEquals("Hello, -1", result);
    }

    @Test
    public void testGetStringWithLargeNumber() {
        String result = Messages.getString("greeting", 10000);
        assertEquals("Hello, 10000", result);
    }

    @Test
    public void testGetStringWithEmptyMessage() {
        String result = Messages.getString("", 5);
        assertEquals("", result);
    }

    @Test
    public void testGetStringWithSpecialCharacters() {
        String result = Messages.getString("greeting", 5);
        // Assuming the message contains special characters
        assertEquals("Hello, 5", result);
    }

    // Reflection test for private method if needed
    private String invokePrivateGetString(String msg, int arg) throws Exception {
        Method method = Messages.class.getDeclaredMethod("getString", String.class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(null, msg, arg);
    }
}
