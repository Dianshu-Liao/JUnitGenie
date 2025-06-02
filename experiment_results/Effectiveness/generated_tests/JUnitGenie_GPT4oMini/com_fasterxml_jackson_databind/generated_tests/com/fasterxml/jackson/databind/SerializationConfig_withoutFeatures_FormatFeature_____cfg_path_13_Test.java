package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig_withoutFeatures_FormatFeature_____cfg_path_13_Test {


    @Test(timeout = 4000)
    public void testWithoutFeaturesWithNoFeatures() {
        JsonMapper jsonMapper = JsonMapper.builder().build();
        SerializationConfig config = jsonMapper.getSerializationConfig();
        SerializationFeature[] features = new SerializationFeature[]{};
        
        SerializationConfig result = config.withoutFeatures(features);
        
        // Add assertions to verify the expected behavior
        assertSame(config, result); // Expecting the same instance to be returned
    }



}
