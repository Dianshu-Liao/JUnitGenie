package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

@ExtendWith(MockitoExtension.class)
public class JsonFactory_createParser_62_3_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser() throws IOException {
        // Prepare a DataInput stream with some JSON data
        String jsonData = "{\"key\":\"value\"}";
        DataInput dataInput = new DataInputStream(new ByteArrayInputStream(jsonData.getBytes()));
        // Call the createParser method
        JsonParser parser = jsonFactory.createParser(dataInput);
        // Assertions to validate that the parser is not null and is of the expected type
        assertNotNull(parser);
        assertTrue(parser instanceof JsonParser);
        // Clean up
        parser.close();
    }

    @Test
    public void testCreateParserWithNullInput() {
        // Verify that passing null to createParser throws an exception
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser((DataInput) null);
        });
    }

    @Test
    public void testSetStreamReadConstraints() {
        StreamReadConstraints constraints = StreamReadConstraints.defaults();
        jsonFactory.setStreamReadConstraints(constraints);
        // Assert that the constraints were set correctly
        assertEquals(constraints, jsonFactory._streamReadConstraints);
    }

    @Test
    public void testSetErrorReportConfiguration() {
        ErrorReportConfiguration config = new ErrorReportConfiguration(256, 500);
        jsonFactory.setErrorReportConfiguration(config);
        // Assert that the configuration was set correctly
        assertEquals(config, jsonFactory._errorReportConfiguration);
    }

    @Test
    public void testSetCharacterEscapes() {
        CharacterEscapes escapes = mock(CharacterEscapes.class);
        jsonFactory.setCharacterEscapes(escapes);
        // Assert that the character escapes were set correctly
        assertEquals(escapes, jsonFactory.getCharacterEscapes());
    }

    @Test
    public void testSetRecyclerPool() {
        RecyclerPool<BufferRecycler> pool = JsonRecyclerPools.defaultPool();
        jsonFactory.setRecyclerPool(pool);
        // Assert that the recycler pool was set correctly
        assertEquals(pool, jsonFactory._recyclerPool);
    }
}
