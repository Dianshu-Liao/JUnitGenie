package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.assertNotSame;

public class DeserializationConfig_withFeatures_Feature_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithFeatures() {
        // Create an instance of DeserializationConfig using ObjectMapper
        DeserializationConfig originalConfig = createDeserializationConfig();

        // Define features to be used in the test
        JsonParser.Feature[] features = new JsonParser.Feature[] {
            JsonParser.Feature.ALLOW_COMMENTS,
            JsonParser.Feature.ALLOW_SINGLE_QUOTES
        };

        // Call the focal method
        DeserializationConfig newConfig = originalConfig.withFeatures(features);

        // Assert that the returned object is not the same as the original
        assertNotSame("The returned config should not be the same as the original config", newConfig, originalConfig);
    }

    private DeserializationConfig createDeserializationConfig() {
        // Use ObjectMapper to create an instance of DeserializationConfig
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.getDeserializationConfig();
    }

}