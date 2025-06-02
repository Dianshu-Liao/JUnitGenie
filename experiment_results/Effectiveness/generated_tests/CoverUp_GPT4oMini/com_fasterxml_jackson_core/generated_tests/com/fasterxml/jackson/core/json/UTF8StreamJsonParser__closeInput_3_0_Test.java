package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser__closeInput_3_0_Test {

    private UTF8StreamJsonParser parser;

    private IOContext ioContext;

    private ByteQuadsCanonicalizer symbols;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        ioContext = new IOContext(null, null, null, null, null, true);
        // Use a method to create a default instance
        symbols = ByteQuadsCanonicalizer.createRoot();
    }

    @Test
    void testCloseInputWhenInputStreamIsNull() throws Exception {
        parser = new UTF8StreamJsonParser(ioContext, 0, null, null, symbols, null, 0, 0, true);
        invokeCloseInput(parser);
        assertNull(getInputStream(parser));
    }

    @Test
    void testCloseInputWhenResourceIsManaged() throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, symbols, null, 0, 0, true);
        invokeCloseInput(parser);
        assertNull(getInputStream(parser));
    }

    @Test
    void testCloseInputWhenAutoCloseSourceEnabled() throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, symbols, null, 0, 0, true);
        setAutoCloseSource(parser, true);
        invokeCloseInput(parser);
        assertNull(getInputStream(parser));
    }

    @Test
    void testCloseInputWhenResourceIsNotManagedAndAutoCloseDisabled() throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3 });
        parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, symbols, null, 0, 0, true);
        setAutoCloseSource(parser, false);
        invokeCloseInput(parser);
        assertNotNull(getInputStream(parser));
    }

    private void invokeCloseInput(UTF8StreamJsonParser parser) throws Exception {
        Method closeInputMethod = UTF8StreamJsonParser.class.getDeclaredMethod("_closeInput");
        closeInputMethod.setAccessible(true);
        closeInputMethod.invoke(parser);
    }

    private InputStream getInputStream(UTF8StreamJsonParser parser) throws Exception {
        return (InputStream) parser.getClass().getDeclaredField("_inputStream").get(parser);
    }

    private void setAutoCloseSource(UTF8StreamJsonParser parser, boolean value) throws Exception {
        parser.getClass().getDeclaredField("_ioContext").set(parser, new IOContext(null, null, null, null, null, value));
    }
}
