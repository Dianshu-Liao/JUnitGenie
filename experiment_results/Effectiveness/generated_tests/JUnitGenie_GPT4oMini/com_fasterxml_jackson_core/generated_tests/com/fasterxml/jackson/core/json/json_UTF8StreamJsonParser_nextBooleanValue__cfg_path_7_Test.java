package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser_nextBooleanValue__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsTrue() {
        try {
            // Setup the parser with a JSON input that contains 'true'
            String json = "{\"key\": true}";
            IOContext ioContext = new IOContext(null, null, false);
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, 
                new ByteArrayInputStream(json.getBytes()), null, null, null, 0, 0, false);
            parser.nextToken(); // Move to FIELD_NAME
            parser.nextToken(); // Move to VALUE_TRUE

            // Test execution
            Boolean result = parser.nextBooleanValue();
            assertEquals(Boolean.TRUE, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsFalse() {
        try {
            // Setup the parser with a JSON input that contains 'false'
            String json = "{\"key\": false}";
            IOContext ioContext = new IOContext(null, null, false);
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, 
                new ByteArrayInputStream(json.getBytes()), null, null, null, 0, 0, false);
            parser.nextToken(); // Move to FIELD_NAME
            parser.nextToken(); // Move to VALUE_FALSE

            // Test execution
            Boolean result = parser.nextBooleanValue();
            assertEquals(Boolean.FALSE, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsNullForOtherTokens() {
        try {
            // Setup the parser with a JSON input that contains an array start
            String json = "{\"key\": [1, 2, 3]}";
            IOContext ioContext = new IOContext(null, null, false);
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, 
                new ByteArrayInputStream(json.getBytes()), null, null, null, 0, 0, false);
            parser.nextToken(); // Move to FIELD_NAME
            parser.nextToken(); // Move to START_ARRAY

            // Test execution
            Boolean result = parser.nextBooleanValue();
            assertEquals(null, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}