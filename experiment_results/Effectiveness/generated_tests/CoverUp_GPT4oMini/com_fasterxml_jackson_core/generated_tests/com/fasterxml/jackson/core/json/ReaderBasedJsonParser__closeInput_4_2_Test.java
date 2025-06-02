package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class ReaderBasedJsonParser__closeInput_4_2_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    private ObjectCodec codec;

    private Reader reader;

    @BeforeEach
    void setUp() {
        symbols = CharsToNameCanonicalizer.createRoot();
        ioContext = new IOContext(StreamReadConstraints.defaults(), null, null, false);
        reader = mock(Reader.class);
        codec = mock(ObjectCodec.class);
        parser = new ReaderBasedJsonParser(ioContext, 0, reader, codec, symbols);
    }

    @Test
    void testCloseInput_ResourceManaged() throws Exception {
        IOContext context = mock(IOContext.class);
        when(context.isResourceManaged()).thenReturn(true);
        setIoContext(parser, context);
        parser._closeInput();
        assertNull(getReader(parser));
        verify(reader, times(1)).close();
    }

    @Test
    void testCloseInput_AutoCloseSourceEnabled() throws Exception {
        parser.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
        parser._closeInput();
        assertNull(getReader(parser));
        verify(reader, times(1)).close();
    }

    @Test
    void testCloseInput_NoClose() throws Exception {
        IOContext context = mock(IOContext.class);
        when(context.isResourceManaged()).thenReturn(false);
        setIoContext(parser, context);
        parser._closeInput();
        assertNull(getReader(parser));
        verify(reader, never()).close();
    }

    private void setIoContext(ReaderBasedJsonParser parser, IOContext context) throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_ioContext");
        field.setAccessible(true);
        field.set(parser, context);
    }

    private Reader getReader(ReaderBasedJsonParser parser) throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_reader");
        field.setAccessible(true);
        return (Reader) field.get(parser);
    }
}
