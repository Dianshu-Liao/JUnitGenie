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

public class ReaderBasedJsonParser__matchNull_67_4_Test {

    private ReaderBasedJsonParser parser;

    private Reader mockReader;

    private ObjectCodec mockCodec;

    private CharsToNameCanonicalizer mockSymbols;

    private char[] inputBuffer;

    @BeforeEach
    public void setUp() {
        mockReader = Mockito.mock(Reader.class);
        mockCodec = Mockito.mock(ObjectCodec.class);
        mockSymbols = Mockito.mock(CharsToNameCanonicalizer.class);
        inputBuffer = new char[10];
        parser = new ReaderBasedJsonParser(new IOContext(new BufferRecycler(), null, false), 0, mockReader, mockCodec, mockSymbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    public void testMatchNull_ValidInput() throws Exception {
        // Setup valid input for "_matchNull"
        inputBuffer[0] = 'n';
        inputBuffer[1] = 'u';
        inputBuffer[2] = 'l';
        inputBuffer[3] = 'l';
        // Set the input pointer and end using reflection
        setInputPtr(0);
        setInputEnd(4);
        // Invoke the private method using reflection
        invokePrivateMethod("_matchNull");
        assertEquals(4, getInputPtr());
    }

    @Test
    public void testMatchNull_BufferBoundary() throws Exception {
        // Setup input that does not match "null"
        inputBuffer[0] = 'n';
        inputBuffer[1] = 'u';
        inputBuffer[2] = 'l';
        // Invalid character
        inputBuffer[3] = 'x';
        // Set the input pointer and end using reflection
        setInputPtr(0);
        setInputEnd(4);
        // Invoke the private method using reflection
        Exception exception = assertThrows(IOException.class, () -> {
            invokePrivateMethod("_matchNull");
        });
        // Assert that the exception message is as expected
        assertTrue(exception.getMessage().contains("expected/allowed chars"));
    }

    @Test
    public void testMatchNull_InsufficientBuffer() throws Exception {
        // Setup input that does not have enough characters
        setInputPtr(0);
        // Less than required for "null"
        setInputEnd(2);
        // Invoke the private method using reflection
        Exception exception = assertThrows(IOException.class, () -> {
            invokePrivateMethod("_matchNull");
        });
        // Assert that the exception message indicates a buffer boundary issue
        assertTrue(exception.getMessage().contains("buffer boundary"));
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = ReaderBasedJsonParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(parser);
    }

    private void setInputPtr(int value) throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getSuperclass().getDeclaredField("_inputPtr");
        field.setAccessible(true);
        field.setInt(parser, value);
    }

    private int getInputPtr() throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getSuperclass().getDeclaredField("_inputPtr");
        field.setAccessible(true);
        return field.getInt(parser);
    }

    private void setInputEnd(int value) throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getSuperclass().getDeclaredField("_inputEnd");
        field.setAccessible(true);
        field.setInt(parser, value);
    }
}
