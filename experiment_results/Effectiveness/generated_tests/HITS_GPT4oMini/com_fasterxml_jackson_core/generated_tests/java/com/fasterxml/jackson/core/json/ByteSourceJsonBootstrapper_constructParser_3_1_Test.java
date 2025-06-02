package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.util.VersionUtil;

class ByteSourceJsonBootstrapper_constructParser_3_1_Test {

    private ByteSourceJsonBootstrapper bootstrapper;

    private IOContext ioContext;

    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        // Prepare the input stream for testing
        byte[] inputData = "{\"key\":\"value\"}".getBytes();
        inputStream = new ByteArrayInputStream(inputData);
        // Create a StreamReadConstraints instance
        StreamReadConstraints streamReadConstraints = StreamReadConstraints.defaults();
        // Create a BufferRecycler instance
        BufferRecycler bufferRecycler = new BufferRecycler();
        // Create an IOContext instance using the non-deprecated constructor
        ioContext = new IOContext(streamReadConstraints, bufferRecycler, null, true);
        // Initialize ByteSourceJsonBootstrapper
        bootstrapper = new ByteSourceJsonBootstrapper(ioContext, inputStream);
    }

    @Test
    void testConstructParserWithUTF8() throws IOException {
        // Create ByteQuadsCanonicalizer instance
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot();
        // Create CharsToNameCanonicalizer instance using makeChild
        CharsToNameCanonicalizer charsToNameCanonicalizer = CharsToNameCanonicalizer.createRoot();
        // Call the method to test
        JsonParser parser = bootstrapper.constructParser(0, null, byteQuadsCanonicalizer, charsToNameCanonicalizer, 0);
        // Verify the parser is not null
        assertNotNull(parser);
    }
}
