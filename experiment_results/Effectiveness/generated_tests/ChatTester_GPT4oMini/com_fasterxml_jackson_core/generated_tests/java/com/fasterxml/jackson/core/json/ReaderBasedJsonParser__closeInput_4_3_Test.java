package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class ReaderBasedJsonParser__closeInput_4_3_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private Reader mockReader;

    private ObjectCodec mockCodec;

    private CharsToNameCanonicalizer mockSymbols;

    @BeforeEach
    void setUp() {
        ioContext = mock(IOContext.class);
        mockReader = mock(Reader.class);
        mockCodec = mock(ObjectCodec.class);
        mockSymbols = mock(CharsToNameCanonicalizer.class);
        parser = new ReaderBasedJsonParser(ioContext, 0, mockReader, mockCodec, mockSymbols);
    }

    @Test
    void testCloseInputWhenReaderIsNotNullAndResourceManaged() throws IOException {
        when(ioContext.isResourceManaged()).thenReturn(true);
        parser._closeInput();
        verify(mockReader).close();
        // Ensure reader is set to null
        assertNull(parser._reader);
    }

    @Test
    void testCloseInputWhenReaderIsNotNullAndAutoCloseSourceEnabled() throws IOException {
        when(ioContext.isResourceManaged()).thenReturn(false);
        parser.enable(ReaderBasedJsonParser.Feature.AUTO_CLOSE_SOURCE);
        parser._closeInput();
        verify(mockReader).close();
        // Ensure reader is set to null
        assertNull(parser._reader);
    }

    @Test
    void testCloseInputWhenReaderIsNotNullAndNeitherResourceManagedNorAutoCloseSourceEnabled() throws IOException {
        when(ioContext.isResourceManaged()).thenReturn(false);
        parser.disable(ReaderBasedJsonParser.Feature.AUTO_CLOSE_SOURCE);
        parser._closeInput();
        // Ensure reader is not closed
        verify(mockReader, never()).close();
        // Ensure reader is set to null
        assertNull(parser._reader);
    }

    @Test
    void testCloseInputWhenReaderIsNull() throws IOException {
        parser._reader = null;
        parser._closeInput();
        // Ensure reader is not closed
        verify(mockReader, never()).close();
    }
}
