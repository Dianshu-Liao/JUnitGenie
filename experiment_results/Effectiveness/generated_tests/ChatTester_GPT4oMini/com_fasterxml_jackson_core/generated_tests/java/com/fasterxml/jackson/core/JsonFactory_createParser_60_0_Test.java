package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_60_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_WithValidContent() throws IOException {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        JsonParser parser = jsonFactory.createParser(content);
        assertNotNull(parser);
        // Additional assertions can be added here to verify parser state
    }

    @Test
    public void testCreateParser_WithEmptyContent() {
        char[] content = new char[0];
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(content);
        });
    }

    @Test
    public void testCreateParser_WithNullContent() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed the ambiguous method reference by casting to char[]
            jsonFactory.createParser((char[]) null);
        });
    }
}
