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

public class UTF8StreamJsonParser_getValueAsInt_10_0_Test extends UTF8StreamJsonParser {

    public UTF8StreamJsonParser_getValueAsInt_10_0_Test() {
        super(null, 0, null, null, ByteQuadsCanonicalizer.createRoot(), null, 0, 0, false);
    }

    @BeforeEach
    public void setUp() {
        // Reset parser state for each test
        _currToken = null;
        _numberInt = 0;
        _numTypesValid = 0;
    }

    @Test
    public void testGetValueAsInt_WithIntegerToken() throws IOException {
        // Set up the parser state
        _currToken = JsonToken.VALUE_NUMBER_INT;
        _numberInt = 42;
        _numTypesValid = NR_INT;
        // Call the method under test
        int result = getValueAsInt(0);
        // Verify the result
        assertEquals(42, result);
    }

    @Test
    public void testGetValueAsInt_WithFloatToken() throws IOException {
        // Set up the parser state
        _currToken = JsonToken.VALUE_NUMBER_FLOAT;
        // Initial value before conversion
        _numberInt = 0;
        _numTypesValid = NR_UNKNOWN;
        // Simulate conversion behavior
        // Set expected value after conversion
        _numberInt = 42;
        // Call the method under test
        int result = getValueAsInt(0);
        // Verify the result
        assertEquals(42, result);
    }

    @Test
    public void testGetValueAsInt_WithUnknownToken() throws IOException {
        // Set up the parser state
        _currToken = JsonToken.VALUE_STRING;
        // Call the method under test with a default value
        int result = getValueAsInt(10);
        // Verify the result returns the default value
        assertEquals(10, result);
    }

    @Test
    public void testGetValueAsInt_WithInvalidToken() throws IOException {
        // Set up the parser state
        _currToken = JsonToken.NOT_AVAILABLE;
        // Call the method under test with a default value
        int result = getValueAsInt(5);
        // Verify the result returns the default value
        assertEquals(5, result);
    }
}
