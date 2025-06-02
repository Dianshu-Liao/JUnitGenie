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

    private static ResourceBundle bundle;

    @BeforeAll
    public static void setUp() {
        // Mock ResourceBundle for testing
        bundle = mock(ResourceBundle.class);
        Messages.setLocale(Locale.ENGLISH, "testResource");
        // Using reflection to set the private static bundle field
        try {
            java.lang.reflect.Field field = Messages.class.getDeclaredField("bundle");
            field.setAccessible(true);
            field.set(null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetStringWithValidChar() {
        // Arrange
        String msgKey = "test.message";
        char arg = 'A';
        String expectedMessage = "This is a test message with A";
        // Mock the behavior of the ResourceBundle
        when(bundle.getString(msgKey)).thenReturn(expectedMessage);
        // Act
        String result = Messages.getString(msgKey, arg);
        // Assert
        assertEquals(expectedMessage, result);
    }

    @Test
    public void testGetStringWithDifferentChar() {
        // Arrange
        String msgKey = "test.message";
        char arg = 'B';
        String expectedMessage = "This is a test message with B";
        // Mock the behavior of the ResourceBundle
        when(bundle.getString(msgKey)).thenReturn(expectedMessage);
        // Act
        String result = Messages.getString(msgKey, arg);
        // Assert
        assertEquals(expectedMessage, result);
    }

    @Test
    public void testGetStringWithNullMsg() {
        // Arrange
        String msgKey = null;
        char arg = 'C';
        // Act
        String result = Messages.getString(msgKey, arg);
        // Assert
        // Assuming getString handles null as "null" + arg
        assertEquals("nullC", result);
    }

    @Test
    public void testGetStringWithEmptyMsg() {
        // Arrange
        String msgKey = "";
        char arg = 'D';
        String expectedMessage = "This is a test message with D";
        // Mock the behavior of the ResourceBundle
        when(bundle.getString(msgKey)).thenReturn(expectedMessage);
        // Act
        String result = Messages.getString(msgKey, arg);
        // Assert
        assertEquals(expectedMessage, result);
    }

    @Test
    public void testGetStringWithMissingResource() {
        // Arrange
        String msgKey = "missing.message";
        char arg = 'E';
        // Mock the behavior of the ResourceBundle to throw an exception
        when(bundle.getString(msgKey)).thenThrow(new java.util.MissingResourceException("Missing resource", "bundle", msgKey));
        // Act
        String result = Messages.getString(msgKey, arg);
        // Assert
        // Assuming getString handles missing resource as "null" + arg
        assertEquals("nullE", result);
    }
}
