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

public class Messages_getString_2_0_Test {

    @BeforeEach
    public void setUp() {
        // Set up the ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("testMessages", Locale.ENGLISH);
        Messages.setLocale(Locale.ENGLISH, "testMessages");
    }

    @Test
    public void testGetString_withValidStringAndChar() throws Exception {
        String result = invokeGetString("test.key", 'A');
        assertEquals("Expected output for key 'test.key' with argument 'A'", result);
    }

    @Test
    public void testGetString_withNullString() throws Exception {
        String result = invokeGetString(null, 'A');
        assertEquals("Expected output for key 'null' with argument 'A'", result);
    }

    @Test
    public void testGetString_withEmptyString() throws Exception {
        String result = invokeGetString("", 'A');
        assertEquals("Expected output for key '' with argument 'A'", result);
    }

    @Test
    public void testGetString_withInvalidString() throws Exception {
        String result = invokeGetString("invalid.key", 'A');
        // Fallback to the key itself
        assertEquals("invalid.key", result);
    }

    @Test
    public void testGetString_withDifferentChar() throws Exception {
        String result = invokeGetString("test.key", 'B');
        assertEquals("Expected output for key 'test.key' with argument 'B'", result);
    }

    private String invokeGetString(String msg, char arg) throws Exception {
        Method method = Messages.class.getDeclaredMethod("getString", String.class, char.class);
        method.setAccessible(true);
        return (String) method.invoke(null, msg, arg);
    }
}
