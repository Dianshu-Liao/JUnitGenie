package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Test;
import java.io.StringWriter;
import java.io.Writer;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser_getText_Writer_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetTextWithValueString() throws IOException {
        Writer writer = new StringWriter();
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser("\"test\"");

        // Move the parser to the VALUE_STRING token
        parser.nextToken();

        int result = parser.getText(writer);
        assertEquals(4, result); // Expecting length of "test"
        assertEquals("test", writer.toString()); // Verify written content
        parser.close();
    }

    @Test(timeout = 4000)
    public void testGetTextWithFieldName() throws IOException {
        Writer writer = new StringWriter();
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser("{\"fieldName\": 1}");

        // Move the parser to the FIELD_NAME token
        parser.nextToken();
        parser.nextToken();

        int result = parser.getText(writer);
        assertEquals(9, result); // Expecting length of "fieldName"
        assertEquals("fieldName", writer.toString()); // Verify written content
        parser.close();
    }

    @Test(timeout = 4000)
    public void testGetTextWithNumericToken() throws IOException {
        Writer writer = new StringWriter();
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser("123");

        // Move the parser to the VALUE_NUMBER token
        parser.nextToken();

        int result = parser.getText(writer);
        assertEquals(3, result); // Expecting length of "123"
        assertEquals("123", writer.toString()); // Verify written content
        parser.close();
    }


}