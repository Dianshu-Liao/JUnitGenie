package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig_withoutFeatures_FormatFeature_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithoutFeatures_withJsonWriteFeature() {
        // Arrange
        FormatFeature[] features = new FormatFeature[]{JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS};

        // Create a default SerializationConfig using a BaseSettings instance
        SerializationConfig config = createDefaultSerializationConfig();

        // Act
        SerializationConfig result = config.withoutFeatures(features);

        // Assert
        assertNotNull(result);
        // Additional assertions can be added based on expected behavior
    }

    @Test(timeout = 4000)
    public void testWithoutFeatures_withoutJsonWriteFeature() {
        // Arrange
        FormatFeature[] features = new FormatFeature[]{};

        // Create a default SerializationConfig using a BaseSettings instance
        SerializationConfig config = createDefaultSerializationConfig();

        // Act
        SerializationConfig result = config.withoutFeatures(features);

        // Assert
        assertNotNull(result);
        // Additional assertions can be added based on expected behavior
    }

    @Test(timeout = 4000)
    public void testWithoutFeatures_emptyFeatures() {
        // Arrange
        FormatFeature[] features = new FormatFeature[0];

        // Create a default SerializationConfig using a BaseSettings instance
        SerializationConfig config = createDefaultSerializationConfig();

        // Act
        SerializationConfig result = config.withoutFeatures(features);

        // Assert
        assertNotNull(result);
        // Additional assertions can be added based on expected behavior
    }

    @Test(timeout = 4000)
    public void testWithoutFeatures_nullFeatures() {
        // Arrange
        FormatFeature[] features = null;

        // Create a default SerializationConfig using a BaseSettings instance
        SerializationConfig config = createDefaultSerializationConfig();

        // Act
        try {
            SerializationConfig result = config.withoutFeatures(features);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Assert
            assertNotNull(e);
            // Additional assertions can be added based on expected exception type
        }
    }

    // Corrected method to create a default SerializationConfig
    private SerializationConfig createDefaultSerializationConfig() {
        // Create a new ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        // Return a new SerializationConfig using the ObjectMapper's default settings
        return objectMapper.getSerializationConfig();
    }

}