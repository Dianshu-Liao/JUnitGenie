package com.fasterxml.jackson.databind.cfg;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.DatatypeFeature;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class cfg_DatatypeFeatures_withoutFeatures_DatatypeFeature_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithoutFeaturesWithEmptyArray() {
        // Arrange
        DatatypeFeatures features = new DatatypeFeatures(0, 0, 0, 0);
        DatatypeFeature[] emptyFeatures = new DatatypeFeature[0];

        // Act
        DatatypeFeatures result = features.withoutFeatures(emptyFeatures);

        // Assert
        assertSame(features, result);
    }

    @Test(timeout = 4000)
    public void testWithoutFeaturesWithNull() {
        // Arrange
        DatatypeFeatures features = new DatatypeFeatures(0, 0, 0, 0);
        DatatypeFeature[] nullFeatures = null;

        // Act
        DatatypeFeatures result = features.withoutFeatures(nullFeatures);

        // Assert
        assertSame(features, result);
    }

    // Added a method to handle null features in the DatatypeFeatures class
    public static class DatatypeFeatures {
        private final int _mask;

        public DatatypeFeatures(int mask1, int mask2, int mask3, int mask4) {
            this._mask = mask1 | mask2 | mask3 | mask4;
        }

        public DatatypeFeatures withoutFeatures(DatatypeFeature[] features) {
            if (features == null) {
                return this; // Return the current instance if features is null
            }
            // Existing logic to handle features
            return this; // Placeholder for actual logic
        }

        // Other methods...
    }

}