package org.apache.commons.compress.harmony.archive.internal.nls;

import java.lang.reflect.Field;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Messages_getString_1_0_Test {

    @BeforeEach
    public void setUp() throws Exception {
        // Reset the bundle before each test using reflection
        Field bundleField = Messages.class.getDeclaredField("bundle");
        bundleField.setAccessible(true);
        // Set the static bundle field to null
        bundleField.set(null, null);
    }

    @Test
    public void testGetString_BundleIsNull_ReturnsInputMessage() {
        String inputMessage = "Test message";
        String result = Messages.getString(inputMessage);
        assertEquals(inputMessage, result, "Expected the returned message to be the same as the input message when bundle is null");
    }

    @Test
    public void testGetString_BundleHasMessage_ReturnsMessage() {
        ResourceBundle mockBundle = mock(ResourceBundle.class);
        when(mockBundle.getString("testKey")).thenReturn("Test message from bundle");
        // Set the mock bundle
        try {
            setBundle(mockBundle);
        } catch (Exception e) {
            fail("Setting the bundle should not throw an exception: " + e.getMessage());
        }
        String result = Messages.getString("testKey");
        assertEquals("Test message from bundle", result, "Expected the returned message to be from the bundle");
    }

    @Test
    public void testGetString_MessageNotFound_ReturnsMissingMessage() {
        ResourceBundle mockBundle = mock(ResourceBundle.class);
        when(mockBundle.getString("nonExistentKey")).thenThrow(new MissingResourceException("Key not found", "Bundle", "nonExistentKey"));
        // Set the mock bundle
        try {
            setBundle(mockBundle);
        } catch (Exception e) {
            fail("Setting the bundle should not throw an exception: " + e.getMessage());
        }
        String result = Messages.getString("nonExistentKey");
        assertEquals("Missing message: nonExistentKey", result, "Expected the returned message to indicate the key is missing");
    }

    private void setBundle(ResourceBundle bundle) throws Exception {
        Field bundleField = Messages.class.getDeclaredField("bundle");
        bundleField.setAccessible(true);
        // Set the static bundle field to the provided bundle
        bundleField.set(null, bundle);
    }
}
