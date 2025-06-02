package org.apache.commons.compress.harmony.archive.internal.nls;

import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Messages_getString_6_0_Test {

    @BeforeEach
    public void setUp() {
        ResourceBundle bundle = ResourceBundle.getBundle("testMessages", Locale.ENGLISH);
        setPrivateField(Messages.class, "bundle", bundle);
    }

    private void setPrivateField(Class<?> clazz, String fieldName, Object value) {
        try {
            // Fixed the buggy line
            java.lang.reflect.Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(null, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetStringWithExistingKey() {
        String msg = "greeting";
        Object[] args = new Object[] { "World" };
        // Assuming the resource bundle has "greeting" mapped to "Hello, {0}!"
        String expected = "Hello, World!";
        String result = Messages.getString(msg, args);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithMissingKey() {
        String msg = "nonExistingKey";
        Object[] args = new Object[] { "Test" };
        // Since the key does not exist, it should return the key itself
        String expected = "nonExistingKey";
        String result = Messages.getString(msg, args);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithNullBundle() {
        setPrivateField(Messages.class, "bundle", null);
        String msg = "anyKey";
        Object[] args = new Object[] { "Test" };
        // Since the bundle is null, it should return the key itself
        String expected = "anyKey";
        String result = Messages.getString(msg, args);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithNullMessage() {
        String msg = null;
        Object[] args = new Object[] { "Test" };
        // Since the message is null, it should return null
        String expected = null;
        String result = Messages.getString(msg, args);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithEmptyMessage() {
        String msg = "";
        Object[] args = new Object[] { "Test" };
        // Since the message is empty, it should return an empty string
        String expected = "";
        String result = Messages.getString(msg, args);
        assertEquals(expected, result);
    }

    @Test
    public void testGetStringWithFormattingArgs() {
        String msg = "welcome";
        Object[] args = new Object[] { "John" };
        // Assuming the resource bundle has "welcome" mapped to "Welcome, {0}!"
        String expected = "Welcome, John!";
        String result = Messages.getString(msg, args);
        assertEquals(expected, result);
    }
}
