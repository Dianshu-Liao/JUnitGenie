package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class ReaderBasedJsonParser__isNextTokenNameMaybe_25_2_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    @BeforeEach
    void setUp() {
        ioContext = new IOContext(null, null, null, true);
        symbols = CharsToNameCanonicalizer.createRoot();
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"name\":\"value\"}"), null, symbols);
    }

    @Test
    void testIsNextTokenNameMaybe() throws Exception {
        boolean result = parser._isNextTokenNameMaybe(34, "name");
        assertTrue(result, "Expected the token name to match 'name'");
        result = parser._isNextTokenNameMaybe(34, "nonexistent");
        assertTrue(!result, "Expected the token name not to match 'nonexistent'");
    }
}
