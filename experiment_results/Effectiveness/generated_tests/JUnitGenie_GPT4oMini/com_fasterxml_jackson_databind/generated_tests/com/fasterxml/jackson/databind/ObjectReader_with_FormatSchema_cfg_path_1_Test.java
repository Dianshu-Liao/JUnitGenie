package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonFactory;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class ObjectReader_with_FormatSchema_cfg_path_1_Test {

    private static class TestFormatSchema implements FormatSchema {
        @Override
        public String getSchemaType() {
            return "testSchemaType";
        }
    }

    @Test(timeout = 4000)
    public void testWithDifferentSchema() {
        ObjectMapper objectMapper = new ObjectMapper(); // Create an ObjectMapper instance
        ObjectReader objectReader = objectMapper.reader(); // Use ObjectMapper to create ObjectReader
        FormatSchema newSchema = new TestFormatSchema();
        
        ObjectReader result = objectReader.with(newSchema);
        
        // Verify that the returned ObjectReader is not the same instance
        assertSame("Expected a new ObjectReader instance", result, objectReader.with(newSchema));
    }



}
