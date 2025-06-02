package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonFactory_createParser_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCreateParserWithValidContent() {
        JsonFactory jsonFactory = new JsonFactory();
        String content = "{\"key\":\"value\"}"; // valid JSON content

        try {
            JsonParser parser = jsonFactory.createParser(content);
            assertNotNull(parser);
            // Additional assertions can be added to verify parser behavior
        } catch (IOException e) {
            fail("IOException should not have been thrown for valid content");
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithEmptyContent() {
        JsonFactory jsonFactory = new JsonFactory();
        String content = ""; // empty content

        try {
            JsonParser parser = jsonFactory.createParser(content);
            assertNotNull(parser);
            // Additional assertions can be added to verify parser behavior
        } catch (IOException e) {
            fail("IOException should not have been thrown for empty content");
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithLongContent() {
        JsonFactory jsonFactory = new JsonFactory();
        StringBuilder longContent = new StringBuilder();
        for (int i = 0; i < 90000; i++) {
            longContent.append("a"); // creating a long string
        }

        try {
            JsonParser parser = jsonFactory.createParser(longContent.toString());
            assertNotNull(parser);
            // Additional assertions can be added to verify parser behavior
        } catch (IOException e) {
            fail("IOException should not have been thrown for long content");
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithNullContent() {
        JsonFactory jsonFactory = new JsonFactory();
        String content = null; // null content

        try {
            JsonParser parser = jsonFactory.createParser(content);
            fail("Exception should have been thrown for null content");
        } catch (NullPointerException e) {
            // Expected exception, as createParser should throw NullPointerException for null input
        } catch (IOException e) {
            fail("IOException should not have been thrown for null content");
        }
    }


}