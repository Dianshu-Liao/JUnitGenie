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

public class UTF8StreamJsonParser_getValueAsInt_9_2_Test extends UTF8StreamJsonParser {

    public UTF8StreamJsonParser_getValueAsInt_9_2_Test() {
        super(new IOContext(null, null, null, null, null, false), 0, null, null, ByteQuadsCanonicalizer.createRoot(), null, 0, 0, false);
    }

    @Test
    public void testGetValueAsIntWhenTokenIsValueNumberInt() throws IOException {
        _currToken = JsonToken.VALUE_NUMBER_INT;
        _numberInt = 42;
        _numTypesValid = NR_INT;
        int result = getValueAsInt();
        assertEquals(42, result);
    }

    @Test
    public void testGetValueAsIntWhenTokenIsValueNumberFloatAndValid() throws IOException {
        _currToken = JsonToken.VALUE_NUMBER_FLOAT;
        _numberInt = 42;
        _numTypesValid = NR_INT;
        int result = getValueAsInt();
        assertEquals(42, result);
    }

    @Test
    public void testGetValueAsIntWhenTokenIsValueNumberFloatAndConversionNeeded() throws IOException {
        _currToken = JsonToken.VALUE_NUMBER_FLOAT;
        _numTypesValid = NR_UNKNOWN;
        // Default value before parsing
        _numberInt = 0;
        int result = getValueAsInt();
        // Expect default return value since conversion is needed
        assertEquals(0, result);
    }

    @Test
    public void testGetValueAsIntWhenTokenIsNotValueNumber() throws IOException {
        _currToken = JsonToken.VALUE_STRING;
        int result = getValueAsInt();
        // Expect default return value
        assertEquals(0, result);
    }

    @Test
    public void testGetValueAsIntWhenTokenIsNull() throws IOException {
        _currToken = null;
        int result = getValueAsInt();
        // Expect default return value
        assertEquals(0, result);
    }
}
