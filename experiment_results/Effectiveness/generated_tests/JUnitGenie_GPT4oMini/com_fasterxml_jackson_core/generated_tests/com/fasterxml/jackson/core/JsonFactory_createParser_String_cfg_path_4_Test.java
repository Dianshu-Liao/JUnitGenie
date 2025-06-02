package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonFactory_createParser_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCreateParserWithValidContent() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        String content = "{\"key\":\"value\"}"; // valid JSON string

        // Act
        JsonParser jsonParser = null;
        try {
            jsonParser = jsonFactory.createParser(content);
        } catch (IOException e) {
            fail("IOException should not have been thrown for valid content");
        }

        // Assert
        assertNotNull("JsonParser should not be null", jsonParser);
        // Additional assertions can be added to ensure proper parsing
    }

    @Test(timeout = 4000)
    public void testCreateParserWithEmptyContent() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        String content = ""; // empty JSON string

        // Act
        JsonParser jsonParser = null;
        try {
            jsonParser = jsonFactory.createParser(content);
        } catch (IOException e) {
            fail("IOException should not have been thrown for empty content");
        }

        // Assert
        assertNotNull("JsonParser should not be null", jsonParser);
        // Additional assertions can be added to ensure proper handling of empty content
    }

    @Test(timeout = 4000)
    public void testCreateParserWithLongContent() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        StringBuilder longContent = new StringBuilder();
        for (int i = 0; i < 82000; i++) { // exceed the 64kB limit
            longContent.append("a");
        }

        // Act
        JsonParser jsonParser = null;
        try {
            jsonParser = jsonFactory.createParser(longContent.toString());
        } catch (IOException e) {
            fail("IOException should not have been thrown for long content");
        }

        // Assert
        assertNotNull("JsonParser should not be null", jsonParser);
        // Additional assertions can be added to ensure proper parsing of the long content
    }

}