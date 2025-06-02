package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser_getText_4_1_Test {

    private UTF8DataInputJsonParser parser;

    private DataInput mockInputData;

    private ByteQuadsCanonicalizer mockSymbols;

    @BeforeEach
    public void setUp() {
        mockInputData = mock(DataInput.class);
        mockSymbols = mock(ByteQuadsCanonicalizer.class);
        IOContext mockContext = mock(IOContext.class);
        ObjectCodec mockCodec = mock(ObjectCodec.class);
        parser = new UTF8DataInputJsonParser(mockContext, 0, mockInputData, mockCodec, mockSymbols, 0);
    }

    @Test
    public void testGetTextWithValueStringAndIncompleteToken() throws Exception {
        setField(parser, "_currToken", JsonToken.VALUE_STRING);
        setField(parser, "_tokenIncomplete", true);
        TextBuffer mockTextBuffer = mock(TextBuffer.class);
        setField(parser, "_textBuffer", mockTextBuffer);
        when(invokePrivateMethod(parser, "_finishAndReturnString")).thenReturn("Completed String");
        String result = parser.getText();
        assertEquals("Completed String", result);
        assertFalse((Boolean) getField(parser, "_tokenIncomplete"));
    }

    @Test
    public void testGetTextWithValueStringAndCompleteToken() throws Exception {
        setField(parser, "_currToken", JsonToken.VALUE_STRING);
        setField(parser, "_tokenIncomplete", false);
        TextBuffer mockTextBuffer = mock(TextBuffer.class);
        setField(parser, "_textBuffer", mockTextBuffer);
        when(mockTextBuffer.contentsAsString()).thenReturn("String Content");
        String result = parser.getText();
        assertEquals("String Content", result);
    }

    @Test
    public void testGetTextWithNonStringToken() throws Exception {
        setField(parser, "_currToken", JsonToken.VALUE_NUMBER_INT);
        TextBuffer mockTextBuffer = mock(TextBuffer.class);
        setField(parser, "_textBuffer", mockTextBuffer);
        when(invokePrivateMethod(parser, "_getText2")).thenReturn("Non-string token");
        String result = parser.getText();
        assertEquals("Non-string token", result);
    }

    // Helper methods to set fields and invoke private methods using reflection
    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    private Object invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, getParameterTypes(args));
        method.setAccessible(true);
        return method.invoke(obj, args);
    }

    private Class<?>[] getParameterTypes(Object... args) {
        return Arrays.stream(args).map(arg -> arg.getClass()).toArray(Class<?>[]::new);
    }
}
