package org.apache.commons.compress.harmony.archive.internal.nls;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.MissingResourceException;
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
import java.util.Objects;

public class Messages_getString_1_0_Test {

    @BeforeAll
    public static void setUp() {
        // Setting up the ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("TestMessages", Locale.ENGLISH);
        setBundle(bundle);
    }

    private static void setBundle(ResourceBundle bundle) {
        try {
            Method method = Messages.class.getDeclaredMethod("setBundle", ResourceBundle.class);
            method.setAccessible(true);
            method.invoke(null, bundle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetString_ValidKey() {
        String result = Messages.getString("validKey");
        assertEquals("This is a valid message.", result);
    }

    @Test
    public void testGetString_NullBundle() {
        // Simulate null bundle
        setBundle(null);
        String result = Messages.getString("anyKey");
        assertEquals("anyKey", result);
    }

    @Test
    public void testGetString_MissingResourceException() {
        String result = Messages.getString("missingKey");
        assertEquals("Missing message: missingKey", result);
    }

    @Test
    public void testGetString_EmptyKey() {
        String result = Messages.getString("");
        assertEquals("Missing message: ", result);
    }

    // Additional test to ensure setLocale method works as expected
    @Test
    public void testSetLocale() {
        ResourceBundle bundle = Messages.setLocale(Locale.ENGLISH, "TestMessages");
        assertEquals("This is a valid message.", bundle.getString("validKey"));
    }
}
