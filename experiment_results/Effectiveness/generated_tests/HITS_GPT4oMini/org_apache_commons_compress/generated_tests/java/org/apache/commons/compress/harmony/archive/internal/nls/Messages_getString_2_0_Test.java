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

public class Messages_getString_2_0_Test {

    @BeforeAll
    public static void setUp() {
        // Set up a mock ResourceBundle for testing
        ResourceBundle bundle = ResourceBundle.getBundle("TestMessages", Locale.getDefault());
        Messages.setLocale(Locale.getDefault(), "TestMessages");
    }

    @Test
    public void testGetStringWithValidMessage() {
        String messageKey = "greeting";
        char arg = 'A';
        // Assuming the resource bundle has this entry
        String expected = "Hello, A";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithDifferentChar() {
        String messageKey = "greeting";
        char arg = 'B';
        // Assuming the resource bundle has this entry
        String expected = "Hello, B";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithNonexistentKey() {
        String messageKey = "nonexistent";
        char arg = 'C';
        // Fallback to the key itself
        String expected = "nonexistent";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithNullKey() {
        String messageKey = null;
        char arg = 'D';
        // Assuming the resource bundle has this entry for null
        String expected = "null";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithEmptyKey() {
        String messageKey = "";
        char arg = 'E';
        // Assuming the resource bundle has this entry for empty string
        String expected = "";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithNullArgument() {
        String messageKey = "greeting";
        // Null character
        char arg = '\0';
        // Assuming the resource bundle has this entry
        String expected = "Hello, ";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithSpecialCharacter() {
        String messageKey = "greeting";
        // Special character
        char arg = '@';
        // Assuming the resource bundle has this entry
        String expected = "Hello, @";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithWhitespaceCharacter() {
        String messageKey = "greeting";
        // Whitespace character
        char arg = ' ';
        // Assuming the resource bundle has this entry
        String expected = "Hello,  ";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetStringWithNullBundle() {
        // Ensure the bundle is null and the method handles it gracefully
        Messages.setLocale(Locale.getDefault(), null);
        String messageKey = "greeting";
        char arg = 'A';
        // Fallback to the key itself
        String expected = "greeting";
        String actual = Messages.getString(messageKey, arg);
        assertEquals(expected, actual);
    }
}
