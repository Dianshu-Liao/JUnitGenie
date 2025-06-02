package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JacksonFeatureSet_isEnabled_4_0_Test {

    private JacksonFeatureSet featureSet;

    // Mocking the F interface
    public interface F {

        int getMask();
    }

    @BeforeEach
    public void setUp() {
        // Initialize the JacksonFeatureSet with a bitmask
        // Example bitmask
        featureSet = new JacksonFeatureSet(0b1010);
    }

    @Test
    public void testIsEnabled_WhenFeatureIsEnabled() throws Exception {
        // Mock feature with mask that is enabled
        // Mask corresponds to the second bit being set
        F feature = () -> 0b0010;
        // Invoke the private method using reflection
        Method method = JacksonFeatureSet.class.getDeclaredMethod("isEnabled", F.class);
        method.setAccessible(true);
        // Assert that the feature is enabled
        boolean result = (boolean) method.invoke(featureSet, feature);
        assertTrue(result);
    }

    @Test
    public void testIsEnabled_WhenFeatureIsNotEnabled() throws Exception {
        // Mock feature with mask that is not enabled
        // Mask corresponds to the first bit being set
        F feature = () -> 0b0001;
        // Invoke the private method using reflection
        Method method = JacksonFeatureSet.class.getDeclaredMethod("isEnabled", F.class);
        method.setAccessible(true);
        // Assert that the feature is not enabled
        boolean result = (boolean) method.invoke(featureSet, feature);
        assertFalse(result);
    }

    @Test
    public void testIsEnabled_WhenFeatureMaskIsZero() throws Exception {
        // Mock feature with mask of zero
        F feature = () -> 0b0000;
        // Invoke the private method using reflection
        Method method = JacksonFeatureSet.class.getDeclaredMethod("isEnabled", F.class);
        method.setAccessible(true);
        // Assert that the feature is not enabled
        boolean result = (boolean) method.invoke(featureSet, feature);
        assertFalse(result);
    }
}
