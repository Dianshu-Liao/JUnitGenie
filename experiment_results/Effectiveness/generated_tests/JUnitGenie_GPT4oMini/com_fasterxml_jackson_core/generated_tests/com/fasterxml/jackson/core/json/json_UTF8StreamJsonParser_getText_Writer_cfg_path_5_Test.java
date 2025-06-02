package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonFactory;
import org.junit.Test;
import java.io.StringWriter;
import java.io.Writer;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser_getText_Writer_cfg_path_5_Test {

    private JsonFactory factory = new JsonFactory();

    @Test(timeout = 4000)
    public void testGetTextWithValueString() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        JsonParser parser = factory.createParser("\"testString\""); // Simulate VALUE_STRING token

        // Act
        parser.nextToken(); // Move to the VALUE_STRING token
        parser.getText(writer); // Get text into writer
        int result = writer.toString().length(); // Measure length of the written text

        // Assert
        assertEquals("Expected length of text buffer", 10, result); // "testString".length() == 10
    }

    @Test(timeout = 4000)
    public void testGetTextWithFieldName() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        JsonParser parser = factory.createParser("{\"testField\": 123}"); // Simulate FIELD_NAME token

        // Act
        parser.nextToken(); // Move to the FIELD_NAME token
        parser.getText(writer); // Get text into writer
        int result = writer.toString().length(); // Measure length of the written text

        // Assert
        assertEquals("Expected length of field name", 9, result); // "testField".length() == 9
    }

    @Test(timeout = 4000)
    public void testGetTextWithNumericToken() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        JsonParser parser = factory.createParser("123"); // Simulate numeric token

        // Act
        parser.nextToken(); // Move to the VALUE_NUMBER token
        parser.getText(writer); // Get text into writer
        int result = writer.toString().length(); // Measure length of the written text

        // Assert
        assertEquals("Expected length of numeric text buffer", 3, result); // "123".length() == 3
    }

    @Test(timeout = 4000)
    public void testGetTextWithNullToken() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        JsonParser parser = factory.createParser("null"); // Simulate null token

        // Act
        parser.nextToken(); // Move to the null token
        parser.getText(writer); // Get text into writer
        int result = writer.toString().length(); // Measure length of the written text

        // Assert
        assertEquals("Expected length to be 0 for null token", 0, result);
    }


}