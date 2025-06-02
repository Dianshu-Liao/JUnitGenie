package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__decorate_90_0_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    private InputDecorator inputDecorator;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        ioContext = Mockito.mock(IOContext.class);
        inputDecorator = Mockito.mock(InputDecorator.class);
        jsonFactory.setInputDecorator(inputDecorator);
    }

    @Test
    public void testDecorateWithInputDecoratorReturnsDecoratedReader() throws IOException {
        String input = "test input";
        Reader reader = new StringReader(input);
        Reader decoratedReader = new StringReader("decorated input");
        when(inputDecorator.decorate(eq(ioContext), any(Reader.class))).thenReturn(decoratedReader);
        Reader result = jsonFactory._decorate((Reader) reader, ioContext);
        assertNotNull(result);
        assertEquals("decorated input", readAll(result));
    }

    @Test
    public void testDecorateWithoutInputDecoratorReturnsOriginalReader() throws IOException {
        String input = "test input";
        Reader reader = new StringReader(input);
        jsonFactory.setInputDecorator(null);
        Reader result = jsonFactory._decorate((Reader) reader, ioContext);
        assertNotNull(result);
        assertEquals(input, readAll(result));
    }

    @Test
    public void testDecorateWithNullReaderReturnsNull() throws IOException {
        Reader result = jsonFactory._decorate((Reader) null, ioContext);
        assertNull(result);
    }

    @Test
    public void testDecorateWithNullIOContextReturnsOriginalReader() throws IOException {
        String input = "test input";
        Reader reader = new StringReader(input);
        Reader result = jsonFactory._decorate((Reader) reader, null);
        assertNotNull(result);
        assertEquals(input, readAll(result));
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        return sb.toString();
    }
}
