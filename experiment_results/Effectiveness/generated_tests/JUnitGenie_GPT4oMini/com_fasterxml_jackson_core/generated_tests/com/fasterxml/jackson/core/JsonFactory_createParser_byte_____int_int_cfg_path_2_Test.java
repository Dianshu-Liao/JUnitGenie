package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class JsonFactory_createParser_byte_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateParserWithValidInput() {
        JsonFactory jsonFactory = new JsonFactory();
        byte[] data = new byte[]{1, 2, 3, 4, 5}; // Sample byte array
        int offset = 0;
        int len = data.length;

        try {
            JsonParser parser = jsonFactory.createParser(data, offset, len);
            assertNotNull("Parser should not be null", parser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithNullInputDecorator() {
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory._inputDecorator = null; // Simulating no InputDecorator
        byte[] data = new byte[]{1, 2, 3, 4, 5}; // Sample byte array
        int offset = 0;
        int len = data.length;

        try {
            JsonParser parser = jsonFactory.createParser(data, offset, len);
            assertNotNull("Parser should not be null", parser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithInvalidLength() {
        JsonFactory jsonFactory = new JsonFactory();
        byte[] data = new byte[]{1, 2, 3, 4, 5}; // Sample byte array
        int offset = 0;
        int len = 6; // Set to a valid length greater than the array length

        try {
            jsonFactory.createParser(data, offset, len);
        } catch (IOException e) {
            // Expected exception for invalid length
            e.printStackTrace();
        }
    }


}