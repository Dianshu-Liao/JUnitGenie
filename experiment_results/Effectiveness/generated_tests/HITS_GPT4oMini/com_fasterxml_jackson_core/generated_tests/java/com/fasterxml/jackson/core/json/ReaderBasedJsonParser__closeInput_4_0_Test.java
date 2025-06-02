package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser__closeInput_4_0_Test {

    private ReaderBasedJsonParser parser;

    private Reader mockReader;

    private IOContext mockIOContext;

    @BeforeEach
    public void setUp() {
        mockReader = mock(Reader.class);
        mockIOContext = mock(IOContext.class);
        // Create a constructor for ReaderBasedJsonParser with necessary parameters
        parser = new ReaderBasedJsonParser(mockIOContext, 0, mockReader, null, null);
    }

    @Test
    public void testCloseInput_WhenReaderIsNotNullAndResourceIsManaged() throws IOException {
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        parser._closeInput();
        verify(mockReader, times(1)).close();
        assertNull(parser._reader);
    }

    @Test
    public void testCloseInput_WhenReaderIsNotNullAndAutoCloseSourceIsEnabled() throws IOException {
        when(mockIOContext.isResourceManaged()).thenReturn(false);
        when(parser.isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)).thenReturn(true);
        parser._closeInput();
        verify(mockReader, times(1)).close();
        assertNull(parser._reader);
    }

    @Test
    public void testCloseInput_WhenReaderIsNotNullAndNeitherResourceManagedNorAutoCloseSource() throws IOException {
        when(mockIOContext.isResourceManaged()).thenReturn(false);
        when(parser.isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)).thenReturn(false);
        parser._closeInput();
        verify(mockReader, times(0)).close();
        assertNull(parser._reader);
    }

    @Test
    public void testCloseInput_WhenReaderIsNull() throws IOException {
        parser._reader = null;
        parser._closeInput();
        verify(mockReader, times(0)).close();
        assertNull(parser._reader);
    }
}
