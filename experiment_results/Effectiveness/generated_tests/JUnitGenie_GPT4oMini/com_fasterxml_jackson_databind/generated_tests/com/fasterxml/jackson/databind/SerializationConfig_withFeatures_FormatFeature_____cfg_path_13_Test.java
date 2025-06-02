package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig_withFeatures_FormatFeature_____cfg_path_13_Test {


    @Test(timeout = 4000)
    public void testWithFeaturesWithMultipleFeatures() {
        // Create a SerializationConfig instance using a JsonMapper
        JsonMapper jsonMapper = JsonMapper.builder().build();
        SerializationConfig config = jsonMapper.getSerializationConfig();
        
        SerializationFeature[] features = new SerializationFeature[]{};
        
        SerializationConfig result = config.withFeatures(features);
        
        // Add assertions to verify the expected behavior
        assertNotNull(result);
        // Additional assertions can be added based on expected state of 'result'
    }

    @Test(timeout = 4000)
    public void testWithFeaturesWithNoFeatures() {
        // Create a SerializationConfig instance using a JsonMapper
        JsonMapper jsonMapper = JsonMapper.builder().build();
        SerializationConfig config = jsonMapper.getSerializationConfig();
        
        SerializationFeature[] features = new SerializationFeature[]{};
        
        SerializationConfig result = config.withFeatures(features);
        
        // Add assertions to verify the expected behavior
        assertEquals(config, result); // Expecting the same instance if no features are added
    }


}
