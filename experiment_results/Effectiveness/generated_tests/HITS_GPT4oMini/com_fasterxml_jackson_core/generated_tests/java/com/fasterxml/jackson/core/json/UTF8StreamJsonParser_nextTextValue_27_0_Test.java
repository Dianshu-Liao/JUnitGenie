package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
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

public class UTF8StreamJsonParser_nextTextValue_27_0_Test {

    private UTF8StreamJsonParser parser;

    private final String testJson = "{\"fieldName\":\"value\"}";

    @BeforeEach
    public void setUp() throws IOException {
        ByteQuadsCanonicalizer symbolTable = ByteQuadsCanonicalizer.createRoot();
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext context = new IOContext(null, bufferRecycler, true);
        JsonFactory factory = new JsonFactory();
        ObjectCodec codec = factory.getCodec();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(testJson.getBytes());
        parser = new UTF8StreamJsonParser(context, 0, inputStream, codec, symbolTable, null, 0, 0, true);
        // Move to the first token
        parser.nextToken();
    }

    @Test
    public void testNextTextValue_FieldName() throws IOException {
        // Move to the field name
        parser.nextToken();
        String result = parser.nextTextValue();
        assertEquals("value", result);
    }

    @Test
    public void testNextTextValue_ValueString() throws IOException {
        // Move to the field name
        parser.nextToken();
        // Move to the value
        parser.nextToken();
        String result = parser.nextTextValue();
        assertEquals("value", result);
    }

    @Test
    public void testNextTextValue_NoValue() throws IOException {
        // Move to the field name
        parser.nextToken();
        // Move to the value
        parser.nextToken();
        // Move to the end of the object
        parser.nextToken();
        String result = parser.nextTextValue();
        assertNull(result);
    }

    @Test
    public void testNextTextValue_IncompleteToken() throws IOException {
        String incompleteJson = "{\"fieldName\":\"value";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(incompleteJson.getBytes());
        parser = new UTF8StreamJsonParser(new IOContext(null, new BufferRecycler(), true), 0, inputStream, null, ByteQuadsCanonicalizer.createRoot(), null, 0, 0, true);
        // Move to the field name
        parser.nextToken();
        String result = parser.nextTextValue();
        // The method should finish the string
        assertEquals("value", result);
    }

    @Test
    public void testNextTextValue_EmptyFieldName() throws IOException {
        String emptyJson = "{\"fieldName\":}";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(emptyJson.getBytes());
        parser = new UTF8StreamJsonParser(new IOContext(null, new BufferRecycler(), true), 0, inputStream, null, ByteQuadsCanonicalizer.createRoot(), null, 0, 0, true);
        // Move to the field name
        parser.nextToken();
        String result = parser.nextTextValue();
        // No value associated with the field
        assertNull(result);
    }
}
