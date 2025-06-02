package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig_without_SerializationFeature_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithoutFeature() {
        // Arrange
        SerializationConfig config = JsonMapper.builder().build().getSerializationConfig();
        SerializationFeature feature = SerializationFeature.WRITE_DATES_AS_TIMESTAMPS; // Example feature
        // Assuming _serFeatures has WRITE_DATES_AS_TIMESTAMPS bit set
        // You may need to use reflection to set _serFeatures if necessary

        // Act
        SerializationConfig result = config.without(feature);

        // Assert
        assertNotNull(result);
        // Additional assertions can be added here to verify the state of 'result'
    }

    @Test(timeout = 4000)
    public void testWithoutFeatureNoChange() {
        // Arrange
        SerializationConfig config = JsonMapper.builder().build().getSerializationConfig();
        SerializationFeature feature = SerializationFeature.WRITE_DATES_AS_TIMESTAMPS; // Example feature
        // Assuming _serFeatures does not have WRITE_DATES_AS_TIMESTAMPS bit set
        // You may need to use reflection to set _serFeatures if necessary

        // Act
        SerializationConfig result = config.without(feature);

        // Assert
        assertSame(config, result); // Should return the same instance if no change
    }


}