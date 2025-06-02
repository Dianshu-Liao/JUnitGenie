package org.apache.commons.compress.harmony.archive.internal.nls;

import java.lang.reflect.Field;
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

public class Messages_getString_1_1_Test {

    @BeforeEach
    public void setUp() throws Exception {
        // Reset the ResourceBundle before each test
        setBundle(null);
    }

    @Test
    public void testGetStringWhenBundleIsNull() {
        String msg = "Test message";
        String result = Messages.getString(msg);
        assertEquals(msg, result, "Expected the returned message to be the same as the input when bundle is null");
    }

    @Test
    public void testGetStringWhenKeyExists() throws Exception {
        // Set up a ResourceBundle with a known key
        ResourceBundle bundle = ResourceBundle.getBundle("testMessages", Locale.getDefault());
        setBundle(bundle);
        String msgKey = "greeting";
        // Assuming this key exists in the testMessages.properties file
        String expectedMessage = "Hello, World!";
        String result = Messages.getString(msgKey);
        assertEquals(expectedMessage, result, "Expected the message to match the one in the ResourceBundle");
    }

    @Test
    public void testGetStringWhenKeyDoesNotExist() throws Exception {
        // Set up a ResourceBundle
        ResourceBundle bundle = ResourceBundle.getBundle("testMessages", Locale.getDefault());
        setBundle(bundle);
        String msgKey = "nonExistentKey";
        String expectedMessage = "Missing message: " + msgKey;
        String result = Messages.getString(msgKey);
        assertEquals(expectedMessage, result, "Expected the message to indicate that the key is missing");
    }

    private void setBundle(ResourceBundle bundle) throws Exception {
        Field field = Messages.class.getDeclaredField("bundle");
        field.setAccessible(true);
        field.set(null, bundle);
    }
}
