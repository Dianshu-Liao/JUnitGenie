package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JacksonFeatureSet_isEnabled_4_4_Test {

    private JacksonFeatureSet featureSet;

    private Feature mockFeature;

    @BeforeEach
    public void setUp() {
        // Assuming a bitmask of 5 (binary 0101) means features 0 and 2 are enabled
        featureSet = new JacksonFeatureSet(5);
        mockFeature = Mockito.mock(Feature.class);
    }

    @Test
    public void testIsEnabled_FeatureEnabled() {
        // Given that the feature's mask is 1 (binary 0001)
        Mockito.when(mockFeature.getMask()).thenReturn(1);
        assertTrue(featureSet.isEnabled((JacksonFeature) mockFeature), "Feature should be enabled.");
        // Given that the feature's mask is 4 (binary 0100)
        Mockito.when(mockFeature.getMask()).thenReturn(4);
        assertTrue(featureSet.isEnabled((JacksonFeature) mockFeature), "Feature should be enabled.");
    }

    @Test
    public void testIsEnabled_FeatureDisabled() {
        // Given that the feature's mask is 2 (binary 0010)
        Mockito.when(mockFeature.getMask()).thenReturn(2);
        assertFalse(featureSet.isEnabled((JacksonFeature) mockFeature), "Feature should not be enabled.");
        // Given that the feature's mask is 8 (binary 1000)
        Mockito.when(mockFeature.getMask()).thenReturn(8);
        assertFalse(featureSet.isEnabled((JacksonFeature) mockFeature), "Feature should not be enabled.");
    }

    // Mocked Feature interface
    interface Feature {

        int getMask();
    }
}
