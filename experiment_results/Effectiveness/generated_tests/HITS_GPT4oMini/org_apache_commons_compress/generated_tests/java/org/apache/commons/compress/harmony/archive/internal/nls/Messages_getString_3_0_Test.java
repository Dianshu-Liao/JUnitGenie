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

public class Messages_getString_3_0_Test {

    @BeforeEach
    public void setUp() {
        // Set up a mock ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("testResource");
        Messages.setLocale(Locale.ENGLISH, "testResource");
    }

    @Test
    public void testGetStringWithValidMessage() {
        String result = Messages.getString("valid.message", 5);
        assertEquals("This is a valid message with number 5", result);
    }

    @Test
    public void testGetStringWithInvalidMessage() {
        String result = Messages.getString("invalid.message", 10);
        assertEquals("invalid.message", result);
    }

    @Test
    public void testGetStringWithNullMessage() {
        String result = Messages.getString(null, 3);
        assertNull(result);
    }

    @Test
    public void testGetStringWithNegativeNumber() {
        String result = Messages.getString("valid.message", -1);
        assertEquals("This is a valid message with number -1", result);
    }

    @Test
    public void testGetStringWithZero() {
        String result = Messages.getString("valid.message", 0);
        assertEquals("This is a valid message with number 0", result);
    }

    @Test
    public void testGetStringWithLargeNumber() {
        String result = Messages.getString("valid.message", 1000000);
        assertEquals("This is a valid message with number 1000000", result);
    }

    @Test
    public void testGetStringWithEmptyMessageKey() {
        String result = Messages.getString("", 5);
        assertEquals("", result);
    }
}
