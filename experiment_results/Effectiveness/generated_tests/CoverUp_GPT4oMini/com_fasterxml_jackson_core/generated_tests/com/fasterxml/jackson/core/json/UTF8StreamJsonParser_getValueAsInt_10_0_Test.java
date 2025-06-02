package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_getValueAsInt_10_0_Test {

    private UTF8StreamJsonParser parser;

    @BeforeEach
    public void setUp() throws IOException {
        ByteQuadsCanonicalizer symbolTable = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("{\"key\": 123}".getBytes());
        parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, symbolTable, new byte[1024], 0, 0, false);
        // Move to the first token
        parser.nextToken();
    }

    @Test
    public void testGetValueAsIntWithIntValue() throws IOException {
        // Move to the field
        parser.nextToken();
        // Move to the integer value
        parser.nextToken();
        int result = parser.getValueAsInt(0);
        assertEquals(123, result);
    }

    @Test
    public void testGetValueAsIntWithFloatValue() throws IOException {
        parser = new UTF8StreamJsonParser(new IOContext(null, null, null, null, null, false), 0, new ByteArrayInputStream("{\"key\": 123.45}".getBytes()), null, ByteQuadsCanonicalizer.createRoot(), new byte[1024], 0, 0, false);
        // Move to the first token
        parser.nextToken();
        // Move to the field
        parser.nextToken();
        // Move to the float value
        parser.nextToken();
        int result = parser.getValueAsInt(0);
        // Should convert float to int
        assertEquals(123, result);
    }

    @Test
    public void testGetValueAsIntWithUnknownValue() throws IOException {
        parser = new UTF8StreamJsonParser(new IOContext(null, null, null, null, null, false), 0, new ByteArrayInputStream("{\"key\": \"stringValue\"}".getBytes()), null, ByteQuadsCanonicalizer.createRoot(), new byte[1024], 0, 0, false);
        // Move to the first token
        parser.nextToken();
        // Move to the field
        parser.nextToken();
        // Move to the string value
        parser.nextToken();
        int result = parser.getValueAsInt(10);
        // Should return default value
        assertEquals(10, result);
    }

    @Test
    public void testGetValueAsIntWithNullValue() throws IOException {
        parser = new UTF8StreamJsonParser(new IOContext(null, null, null, null, null, false), 0, new ByteArrayInputStream("{\"key\": null}".getBytes()), null, ByteQuadsCanonicalizer.createRoot(), new byte[1024], 0, 0, false);
        // Move to the first token
        parser.nextToken();
        // Move to the field
        parser.nextToken();
        // Move to the null value
        parser.nextToken();
        int result = parser.getValueAsInt(20);
        // Should return default value
        assertEquals(20, result);
    }
}
