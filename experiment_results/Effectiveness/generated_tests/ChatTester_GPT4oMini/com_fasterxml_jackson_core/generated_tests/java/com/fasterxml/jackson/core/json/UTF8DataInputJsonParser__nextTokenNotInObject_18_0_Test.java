package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser__nextTokenNotInObject_18_0_Test {

    private UTF8DataInputJsonParser parser;

    private DataInput mockInputData;

    private ByteQuadsCanonicalizer mockSymbols;

    @BeforeEach
    public void setUp() {
        mockInputData = mock(DataInput.class);
        mockSymbols = mock(ByteQuadsCanonicalizer.class);
        parser = new UTF8DataInputJsonParser(null, 0, mockInputData, null, mockSymbols, 0);
    }

    @Test
    public void testNextTokenNotInObject_ValueString() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.VALUE_STRING, '"');
    }

    @Test
    public void testNextTokenNotInObject_StartArray() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.START_ARRAY, '[');
    }

    @Test
    public void testNextTokenNotInObject_StartObject() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.START_OBJECT, '{');
    }

    @Test
    public void testNextTokenNotInObject_ValueTrue() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.VALUE_TRUE, 't');
    }

    @Test
    public void testNextTokenNotInObject_ValueFalse() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.VALUE_FALSE, 'f');
    }

    @Test
    public void testNextTokenNotInObject_ValueNull() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.VALUE_NULL, 'n');
    }

    @Test
    public void testNextTokenNotInObject_NegativeNumber() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.VALUE_NUMBER_FLOAT, '-');
    }

    @Test
    public void testNextTokenNotInObject_PositiveNumber() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.VALUE_NUMBER_FLOAT, '1');
    }

    @Test
    public void testNextTokenNotInObject_UnexpectedValue() throws Exception {
        invokeNextTokenNotInObjectAndAssert(JsonToken.NOT_AVAILABLE, 'x');
    }

    private void invokeNextTokenNotInObjectAndAssert(JsonToken expectedToken, int inputChar) throws Exception {
        Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_nextTokenNotInObject", int.class);
        method.setAccessible(true);
        // Simulating input
        parser._nextByte = inputChar;
        JsonToken actualToken = (JsonToken) method.invoke(parser, inputChar);
        assertEquals(expectedToken, actualToken);
    }
}
