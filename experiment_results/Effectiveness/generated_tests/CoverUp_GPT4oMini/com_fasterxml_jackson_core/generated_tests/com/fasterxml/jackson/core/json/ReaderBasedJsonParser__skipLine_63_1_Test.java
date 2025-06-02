package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class ReaderBasedJsonParser__skipLine_63_1_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    private StringReader reader;

    @BeforeEach
    void setUp() {
        ioContext = new IOContext(null, null, null, null, null, false);
        // Updated constructor call
        symbols = CharsToNameCanonicalizer.createRoot();
        reader = new StringReader("Line 1\nLine 2\nLine 3");
        parser = new ReaderBasedJsonParser(ioContext, 0, reader, null, symbols);
    }

    @Test
    void testSkipLine_NewLine() throws Exception {
        // Set up the input buffer to simulate the state before calling _skipLine
        setInputBuffer(new char[] { 'L', 'i', 'n', 'e', ' ', '1', '\n', 'L', 'i', 'n', 'e', ' ', '2' });
        // Invoke the private method using reflection
        invokePrivateMethod("_skipLine");
        // Verify that the current input row has incremented and the pointer has moved past the line
        assertEquals(1, getCurrInputRow());
        // should point to the start of "Line 2"
        assertEquals(6, getInputPtr());
    }

    @Test
    void testSkipLine_CarriageReturn() throws Exception {
        // Set up the input buffer to simulate a CR
        setInputBuffer(new char[] { 'L', 'i', 'n', 'e', ' ', '1', '\r', 'L', 'i', 'n', 'e', ' ', '2' });
        // Invoke the private method using reflection
        invokePrivateMethod("_skipLine");
        // Verify that the current input row has incremented and the pointer has moved to the next line
        assertEquals(1, getCurrInputRow());
        // should point to the start of "Line 2"
        assertEquals(6, getInputPtr());
    }

    @Test
    void testSkipLine_Tab() throws Exception {
        // Set up the input buffer to simulate a tab character
        setInputBuffer(new char[] { 'L', 'i', 'n', 'e', ' ', '1', '\t', 'L', 'i', 'n', 'e', ' ', '2' });
        // Expect an exception to be thrown for invalid space
        Exception exception = assertThrows(IOException.class, () -> {
            invokePrivateMethod("_skipLine");
        });
        String expectedMessage = "Invalid space character";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = ReaderBasedJsonParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(parser);
    }

    private void setInputBuffer(char[] buffer) throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputBuffer");
        field.setAccessible(true);
        field.set(parser, buffer);
        field = ReaderBasedJsonParser.class.getDeclaredField("_inputPtr");
        field.setAccessible(true);
        field.setInt(parser, 0);
        field = ReaderBasedJsonParser.class.getDeclaredField("_inputEnd");
        field.setAccessible(true);
        field.setInt(parser, buffer.length);
    }

    private int getCurrInputRow() throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_currInputRow");
        field.setAccessible(true);
        return field.getInt(parser);
    }

    private int getInputPtr() throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputPtr");
        field.setAccessible(true);
        return field.getInt(parser);
    }
}
