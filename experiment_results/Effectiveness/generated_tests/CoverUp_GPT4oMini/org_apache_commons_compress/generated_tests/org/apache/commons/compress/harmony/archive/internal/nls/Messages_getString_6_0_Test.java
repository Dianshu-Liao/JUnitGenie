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

class // Additional tests can be added here to cover more scenarios
Messages_getString_6_0_Test {

    @BeforeEach
    void setUp() {
        // Reset the ResourceBundle before each test
        Messages.setLocale(Locale.ENGLISH, "messages");
    }

    @Test
    void testGetStringWithValidKey() {
        // Assuming the resource bundle contains a key "hello" with value "Hello, {0}!"
        String result = Messages.getString("hello", new Object[] { "World" });
        assertEquals("Hello, World!", result);
    }

    @Test
    void testGetStringWithMissingKey() {
        // Assuming the resource bundle does not contain a key "missingKey"
        String result = Messages.getString("missingKey", new Object[] {});
        assertEquals("missingKey", result);
    }

    @Test
    void testGetStringWithNullArgs() {
        // Test with null args
        String result = Messages.getString("hello", null);
        assertEquals("Hello, <null>!", result);
    }

    @Test
    void testGetStringWithEmptyArgs() {
        // Test with empty args
        String result = Messages.getString("hello", new Object[] {});
        assertEquals("Hello, <missing argument>!", result);
    }

    @Test
    void testGetStringWithEscapedBraces() {
        // Test with escaped braces
        String result = Messages.getString("escapedBraces", new Object[] { "Test" });
        assertEquals("This is a \\{Test\\} example.", result);
    }

    @Test
    void testGetStringWithInvalidFormat() {
        // Test with an invalid format
        String result = Messages.getString("invalidFormat", new Object[] { "Test" });
        assertEquals("invalidFormat", result);
    }
}
