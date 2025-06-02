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

public class Messages_getString_6_0_Test {

    @BeforeAll
    public static void setUp() {
        // Set up a ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("testResources", Locale.ENGLISH);
        Messages.setLocale(Locale.ENGLISH, "testResources");
    }

    @Test
    public void testGetStringWithValidKey() {
        String result = Messages.getString("greeting", new Object[] { "World" });
        assertEquals("Hello, World!", result, "The message should be formatted correctly with arguments.");
    }

    @Test
    public void testGetStringWithMissingKey() {
        String result = Messages.getString("missingKey", new Object[] {});
        assertEquals("missingKey", result, "The message should return the key itself if the key is missing.");
    }

    @Test
    public void testGetStringWithNullArguments() {
        String result = Messages.getString("greeting", new Object[] { null });
        assertEquals("Hello, <null>!", result, "The message should handle null arguments correctly.");
    }

    @Test
    public void testGetStringWithEscapedBraces() {
        String result = Messages.getString("escapedBraces", new Object[] { "Test" });
        assertEquals("This is a \\{Test\\} example.", result, "The message should handle escaped braces correctly.");
    }

    @Test
    public void testGetStringWithMissingArgument() {
        String result = Messages.getString("greetingWithMissingArg", new Object[] {});
        assertEquals("Hello, <missing argument>!", result, "The message should indicate a missing argument.");
    }

    @Test
    public void testGetStringWithEmptyArguments() {
        String result = Messages.getString("greeting", new Object[] {});
        assertEquals("Hello, <missing argument>!", result, "The message should handle empty arguments correctly.");
    }

    @Test
    public void testGetStringWithInvalidFormat() {
        String result = Messages.getString("invalidFormat", new Object[] { "arg1", "arg2" });
        assertEquals("This is an invalid format: {0} and {1}", result, "The message should handle invalid format strings.");
    }

    @Test
    public void testGetStringWithNullKey() {
        String result = Messages.getString(null, new Object[] {});
        assertNull(result, "The message should return null if the key is null.");
    }
}
