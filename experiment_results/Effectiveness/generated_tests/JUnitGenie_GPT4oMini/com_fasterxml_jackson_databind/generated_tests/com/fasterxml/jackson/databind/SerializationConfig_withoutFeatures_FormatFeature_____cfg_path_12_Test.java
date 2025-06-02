package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig_withoutFeatures_FormatFeature_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testWithoutFeatures() {
        // Arrange
        SerializationConfig originalConfig = new JsonMapper().getSerializationConfig(); // Use JsonMapper to get SerializationConfig
        // Correct usage of feature
        JsonGenerator.Feature[] features = new JsonGenerator.Feature[] { JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS };

        // Act
        SerializationConfig newConfig = null;
        try {
            newConfig = originalConfig.withoutFeatures(features);
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }

        // Assert
        assertNotNull(newConfig);
        // Additional assertions can be added here to verify the state of newConfig
    }

    @Test(timeout = 4000)
    public void testWithoutFeaturesWithNoFeatures() {
        // Arrange
        SerializationConfig originalConfig = new JsonMapper().getSerializationConfig(); // Use JsonMapper to get SerializationConfig
        JsonGenerator.Feature[] features = new JsonGenerator.Feature[0];

        // Act
        SerializationConfig newConfig = null;
        try {
            newConfig = originalConfig.withoutFeatures(features);
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }

        // Assert
        assertSame(originalConfig, newConfig);
    }

    // Additional test cases can be added to cover more scenarios


}