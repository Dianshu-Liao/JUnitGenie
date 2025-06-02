package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import org.junit.Test;
import java.io.IOException;

public class JsonFactory_createParser_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateParserWithValidInput() {
        JsonFactory jsonFactory = new JsonFactory();
        byte[] data = new byte[]{1, 2, 3, 4, 5}; // Example byte array
        int offset = 0;
        int len = data.length;

        try {
            JsonParser parser = jsonFactory.createParser(data, offset, len);
            // Add assertions to verify the parser's state if necessary
        } catch (IOException e) {
            // Handle the IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithNullInputDecorator() {
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory._inputDecorator = null; // Simulate null InputDecorator
        byte[] data = new byte[]{1, 2, 3, 4, 5}; // Example byte array
        int offset = 0;
        int len = data.length;

        try {
            JsonParser parser = jsonFactory.createParser(data, offset, len);
            // Add assertions to verify the parser's state if necessary
        } catch (IOException e) {
            // Handle the IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithInvalidRange() {
        JsonFactory jsonFactory = new JsonFactory();
        byte[] data = new byte[]{1, 2, 3, 4, 5}; // Example byte array
        int offset = -1; // Invalid offset
        int len = data.length;

        try {
            jsonFactory.createParser(data, offset, len);
        } catch (IllegalArgumentException e) {
            // Expected exception for invalid range
            System.out.println("Caught expected IllegalArgumentException: " + e.getMessage());
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }


}