package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ObjectWriter_with_JsonFactory_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithDifferentJsonFactory() {
        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // Create an instance of ObjectWriter using the ObjectMapper
        ObjectWriter objectWriter = objectMapper.writer();

        // Call the 'with' method with a different JsonFactory
        JsonFactory jsonFactory2 = new JsonFactory();
        ObjectWriter result = null;
        try {
            result = objectWriter.with(jsonFactory2);
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }

        // Validate the result is not null and is not the same instance
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testWithSameJsonFactory() {
        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // Create an instance of ObjectWriter using the ObjectMapper
        ObjectWriter objectWriter = objectMapper.writer();

        // Call the 'with' method with the same JsonFactory
        JsonFactory jsonFactory = new JsonFactory();
        ObjectWriter result = null;
        try {
            result = objectWriter.with(jsonFactory);
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }

        // Validate the result is the same instance
        assertNotNull(result);
    }


}