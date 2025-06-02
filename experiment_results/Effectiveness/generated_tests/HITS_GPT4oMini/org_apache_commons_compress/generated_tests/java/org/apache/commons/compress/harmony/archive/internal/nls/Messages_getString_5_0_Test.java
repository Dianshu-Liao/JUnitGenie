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
public class Messages_getString_5_0_Test {

    private ResourceBundle mockBundle;

    @BeforeEach
    public void setUp() {
        mockBundle = mock(ResourceBundle.class);
        // Assuming a method to set the locale and resource
        Messages.setLocale(Locale.getDefault(), "messages");
        // We need to set the bundle in the Messages class if possible
        // If not, we can assume the getString method uses the default bundle
    }

    @Test
    public void testGetString_WithValidMessageAndTwoArguments() {
        String messageKey = "greeting";
        Object arg1 = "John";
        Object arg2 = "Doe";
        when(mockBundle.getString(messageKey)).thenReturn("Hello {0} {1}");
        String result = Messages.getString(messageKey, arg1, arg2);
        assertEquals("Hello John Doe", result);
    }

    @Test
    public void testGetString_WithValidMessageAndNullArguments() {
        String messageKey = "greeting";
        Object arg1 = null;
        Object arg2 = null;
        when(mockBundle.getString(messageKey)).thenReturn("Hello {0} {1}");
        String result = Messages.getString(messageKey, arg1, arg2);
        assertEquals("Hello null null", result);
    }

    @Test
    public void testGetString_WithInvalidMessageKey() {
        String messageKey = "invalidKey";
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        when(mockBundle.getString(messageKey)).thenThrow(new MissingResourceException("Not found", ResourceBundle.class.getName(), messageKey));
        String result = Messages.getString(messageKey, arg1, arg2);
        assertEquals("invalidKey", result);
    }

    @Test
    public void testGetString_WithEmptyMessageKey() {
        String messageKey = "";
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        when(mockBundle.getString(messageKey)).thenReturn("");
        String result = Messages.getString(messageKey, arg1, arg2);
        assertEquals("", result);
    }

    @Test
    public void testGetString_WithNullMessageKey() {
        String messageKey = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        String result = Messages.getString(messageKey, arg1, arg2);
        assertNull(result);
    }
}
