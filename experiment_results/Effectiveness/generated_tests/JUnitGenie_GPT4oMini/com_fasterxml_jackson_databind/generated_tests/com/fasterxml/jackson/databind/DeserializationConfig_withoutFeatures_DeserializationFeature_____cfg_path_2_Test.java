package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class DeserializationConfig_withoutFeatures_DeserializationFeature_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithoutFeatures() {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper(); // Create an ObjectMapper instance
        DeserializationConfig config = objectMapper.getDeserializationConfig(); // Get the DeserializationConfig from ObjectMapper
        DeserializationFeature[] features = new DeserializationFeature[] {  };

        // Act
        DeserializationConfig result = config.withoutFeatures(features);

        // Assert
        assertSame(config, result); // Assuming _deserFeatures does not change
    }


}