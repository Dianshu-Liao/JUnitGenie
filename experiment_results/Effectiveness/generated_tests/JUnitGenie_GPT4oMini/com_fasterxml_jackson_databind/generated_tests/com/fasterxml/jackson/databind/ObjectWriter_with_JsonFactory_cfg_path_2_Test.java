package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ObjectWriter_with_JsonFactory_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithDifferentJsonFactory() {
        try {
            // Create an instance of ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Create a JsonFactory instance that is different from _generatorFactory
            JsonFactory jsonFactory = new JsonFactory();

            // Create an instance of ObjectWriter using the ObjectMapper
            ObjectWriter objectWriter = objectMapper.writer();

            // Call the focal method with a different JsonFactory
            ObjectWriter result = objectWriter.with(jsonFactory);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}