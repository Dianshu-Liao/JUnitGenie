package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser_getValueAsInt__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetValueAsIntWithValueNumberFloat() {
        // Setup
        String json = "123.45"; // Example JSON input
        InputStream inputStream = new ByteArrayInputStream(json.getBytes());
        JsonFactory factory = new JsonFactory();
        
        try (JsonParser parser = factory.createParser(inputStream)) {
            // Move to the first token
            parser.nextToken(); // This should move to VALUE_NUMBER_FLOAT

            // Execute
            int result = parser.getIntValue(); // Get the int value from the parser

            // Verify
            assertEquals(123, result); // Assuming the parser converts the float to int correctly
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueAsIntWithValueNumberInt() {
        // Setup
        String json = "123"; // Example JSON input
        InputStream inputStream = new ByteArrayInputStream(json.getBytes());
        JsonFactory factory = new JsonFactory();
        
        try (JsonParser parser = factory.createParser(inputStream)) {
            // Move to the first token
            parser.nextToken(); // This should move to VALUE_NUMBER_INT

            // Execute
            int result = parser.getIntValue(); // Get the int value from the parser

            // Verify
            assertEquals(123, result); // Expecting the same integer value
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}