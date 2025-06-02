package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Test;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class json_UTF8StreamJsonParser_nextBooleanValue__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testNextBooleanValue_FieldName_ValueTrue() {
        try {
            // Setup
            IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
            InputStream inputStream = new ByteArrayInputStream("{\"fieldName\": true}".getBytes()); // Create a valid InputStream
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, null, null, 0, 0, false);
            setParserTokens(parser, JsonToken.FIELD_NAME, JsonToken.VALUE_TRUE);

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertTrue(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValue_FieldName_ValueFalse() {
        try {
            // Setup
            IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
            InputStream inputStream = new ByteArrayInputStream("{\"fieldName\": false}".getBytes()); // Create a valid InputStream
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, null, null, 0, 0, false);
            setParserTokens(parser, JsonToken.FIELD_NAME, JsonToken.VALUE_FALSE);

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertFalse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValue_FieldName_StartArray() {
        try {
            // Setup
            IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
            InputStream inputStream = new ByteArrayInputStream("{\"fieldName\": []}".getBytes()); // Create a valid InputStream
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, null, null, 0, 0, false);
            setParserTokens(parser, JsonToken.FIELD_NAME, JsonToken.START_ARRAY);

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertNull(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValue_FieldName_StartObject() {
        try {
            // Setup
            IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
            InputStream inputStream = new ByteArrayInputStream("{\"fieldName\": {}}".getBytes()); // Create a valid InputStream
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, null, null, 0, 0, false);
            setParserTokens(parser, JsonToken.FIELD_NAME, JsonToken.START_OBJECT);

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertNull(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValue_NonFieldName() {
        try {
            // Setup
            IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
            InputStream inputStream = new ByteArrayInputStream("{\"fieldName\": true}".getBytes()); // Create a valid InputStream
            UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, null, null, 0, 0, false);
            setParserTokens(parser, JsonToken.VALUE_TRUE, null);

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertTrue(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setParserTokens(UTF8StreamJsonParser parser, JsonToken currToken, JsonToken nextToken) {
        // Use reflection to set the protected fields
        try {
            java.lang.reflect.Field currTokenField = UTF8StreamJsonParser.class.getDeclaredField("_currToken");
            currTokenField.setAccessible(true);
            currTokenField.set(parser, currToken);

            java.lang.reflect.Field nextTokenField = UTF8StreamJsonParser.class.getDeclaredField("_nextToken");
            nextTokenField.setAccessible(true);
            nextTokenField.set(parser, nextToken);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}