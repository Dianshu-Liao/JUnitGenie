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
        // Set up ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("testMessages", Locale.ENGLISH);
        Messages.setLocale(Locale.ENGLISH, "testMessages");
    }

    @Test
    public void testGetStringWithValidKey() {
        String result = Messages.getString("greeting", null);
        assertEquals("Hello, World!", result, "The greeting message should match the expected value.");
    }

    @Test
    public void testGetStringWithValidKeyAndArgument() {
        String result = Messages.getString("farewell", "John");
        assertEquals("Goodbye, John!", result, "The farewell message should include the provided name.");
    }

    @Test
    public void testGetStringWithInvalidKey() {
        String result = Messages.getString("invalidKey", null);
        assertEquals("invalidKey", result, "Should return the key itself when the key is not found.");
    }

    @Test
    public void testGetStringWithNullKey() {
        String result = Messages.getString(null, null);
        assertNull(result, "Should return null when the key is null.");
    }

    @Test
    public void testGetStringWithNullArgument() {
        String result = Messages.getString("greeting", null);
        assertEquals("Hello, World!", result, "The greeting message should match the expected value with a null argument.");
    }

    @Test
    public void testGetStringWithMultipleArguments() {
        String result = Messages.getString("welcome", new Object[] { "Alice", "Wonderland" });
        assertEquals("Welcome to Wonderland, Alice!", result, "The welcome message should include both provided arguments.");
    }
}
