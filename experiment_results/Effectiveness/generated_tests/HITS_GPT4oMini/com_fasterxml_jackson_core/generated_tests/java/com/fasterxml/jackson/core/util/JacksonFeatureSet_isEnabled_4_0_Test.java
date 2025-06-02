package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JacksonFeatureSet_isEnabled_4_0_Test {

    private JacksonFeatureSet featureSet;

    @BeforeEach
    public void setUp() {
        // Assuming constructor takes an int to initialize _enabled
        featureSet = new JacksonFeatureSet(0);
    }

    @Test
    public void testIsEnabled_WhenFeatureIsEnabled_ShouldReturnTrue() {
        // Arrange
        featureSet._enabled = 0b1010;
        JacksonFeature feature = mock(JacksonFeature.class);
        when(feature.getMask()).thenReturn(0b0010);
        // Act
        boolean result = featureSet.isEnabled(feature);
        // Assert
        assertTrue(result, "Expected feature to be enabled.");
    }

    @Test
    public void testIsEnabled_WhenFeatureIsNotEnabled_ShouldReturnFalse() {
        // Arrange
        featureSet._enabled = 0b1010;
        JacksonFeature feature = mock(JacksonFeature.class);
        when(feature.getMask()).thenReturn(0b0001);
        // Act
        boolean result = featureSet.isEnabled(feature);
        // Assert
        assertFalse(result, "Expected feature to be disabled.");
    }

    @Test
    public void testIsEnabled_WhenNoFeaturesEnabled_ShouldReturnFalse() {
        // Arrange
        featureSet._enabled = 0b0000;
        JacksonFeature feature = mock(JacksonFeature.class);
        when(feature.getMask()).thenReturn(0b0010);
        // Act
        boolean result = featureSet.isEnabled(feature);
        // Assert
        assertFalse(result, "Expected feature to be disabled when no features are enabled.");
    }

    @Test
    public void testIsEnabled_WhenFeatureMaskIsZero_ShouldReturnFalse() {
        // Arrange
        featureSet._enabled = 0b1010;
        JacksonFeature feature = mock(JacksonFeature.class);
        when(feature.getMask()).thenReturn(0b0000);
        // Act
        boolean result = featureSet.isEnabled(feature);
        // Assert
        assertFalse(result, "Expected feature to be disabled when feature mask is zero.");
    }

    @Test
    public void testIsEnabled_WhenFeatureMaskIsNegative_ShouldReturnTrue() {
        // Arrange
        featureSet._enabled = 0b1010;
        JacksonFeature feature = mock(JacksonFeature.class);
        when(feature.getMask()).thenReturn(-1);
        // Act
        boolean result = featureSet.isEnabled(feature);
        // Assert
        assertTrue(result, "Expected feature to be enabled when mask is negative (all bits set).");
    }
}
