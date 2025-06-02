package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig_withFeatures_FormatFeature_____cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testWithFeatures() {
        // Arrange
        SerializationConfig originalConfig = JsonMapper.builder().build().getSerializationConfig();
        JsonGenerator.Feature[] features = new JsonGenerator.Feature[] { JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS }; // Corrected usage

        // Act
        SerializationConfig newConfig = originalConfig.withFeatures(features);

        // Assert
        assertNotNull(newConfig);
        assertNotSame(originalConfig, newConfig);
        // Additional assertions can be added based on expected behavior after invoking withFeatures()
    }

    @Test(timeout = 4000)
    public void testWithNoFeatures() {
        // Arrange
        SerializationConfig originalConfig = JsonMapper.builder().build().getSerializationConfig();
        JsonGenerator.Feature[] features = new JsonGenerator.Feature[0];

        // Act
        SerializationConfig newConfig = originalConfig.withFeatures(features);

        // Assert
        assertSame(originalConfig, newConfig);
    }

}