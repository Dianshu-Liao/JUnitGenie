package org.apache.commons.compress.harmony.archive.internal.nls;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Collections;
import java.util.Enumeration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Messages_getString_1_0_Test {

    @BeforeEach
    public void setUp() {
        // Set the bundle to null using reflection
        setBundle(null);
    }

    @Test
    public void testGetStringWithNullBundle() {
        String result = Messages.getString("testKey");
        assertEquals("testKey", result, "Expected message should be the key itself when bundle is null");
    }

    @Test
    public void testGetStringWithMissingKey() {
        // Set up a ResourceBundle that will throw MissingResourceException
        ResourceBundle bundle = new ResourceBundle() {

            @Override
            protected Object handleGetObject(String key) {
                throw new MissingResourceException("Missing resource", "ResourceBundle", key);
            }

            @Override
            public Enumeration<String> getKeys() {
                return Collections.emptyEnumeration();
            }
        };
        // Set the bundle using reflection
        setBundle(bundle);
        String result = Messages.getString("missingKey");
        assertEquals("Missing message: missingKey", result, "Expected message should indicate the key is missing");
    }

    @Test
    public void testGetStringWithExistingKey() {
        // Create a ResourceBundle with a defined key
        ResourceBundle bundle = new ResourceBundle() {

            @Override
            protected Object handleGetObject(String key) {
                if ("existingKey".equals(key)) {
                    return "Existing message";
                }
                throw new MissingResourceException("Missing resource", "ResourceBundle", key);
            }

            @Override
            public Enumeration<String> getKeys() {
                return Collections.enumeration(Collections.singleton("existingKey"));
            }
        };
        // Set the bundle using reflection
        setBundle(bundle);
        String result = Messages.getString("existingKey");
        assertEquals("Existing message", result, "Expected message should match the value in the ResourceBundle");
    }

    @Test
    public void testGetStringWithException() {
        // Simulate the case where the ResourceBundle throws a MissingResourceException
        ResourceBundle bundle = new ResourceBundle() {

            @Override
            protected Object handleGetObject(String key) {
                throw new MissingResourceException("Missing resource", "ResourceBundle", key);
            }

            @Override
            public Enumeration<String> getKeys() {
                return Collections.emptyEnumeration();
            }
        };
        // Set the bundle using reflection
        setBundle(bundle);
        String result = Messages.getString("testKey");
        assertEquals("Missing message: testKey", result, "Expected message should indicate the key is missing");
    }

    private void setBundle(ResourceBundle bundle) {
        try {
            java.lang.reflect.Field field = Messages.class.getDeclaredField("bundle");
            field.setAccessible(true);
            field.set(null, bundle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
