package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
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
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser__finishAndReturnString_58_4_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext context;

    @BeforeEach
    void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        context = new IOContext(bufferRecycler, null, true);
        symbols = ByteQuadsCanonicalizer.createRoot();
        byte[] inputBuffer = new byte[1024];
        parser = new UTF8StreamJsonParser(context, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, 0, true);
    }

    @Test
    void testFinishAndReturnString() throws Exception {
        String jsonString = "\"Hello, World!\"";
        byte[] inputData = jsonString.getBytes();
        setInputBuffer(inputData);
        parser._tokenIncomplete = true;
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_finishAndReturnString");
        method.setAccessible(true);
        String result = (String) method.invoke(parser);
        assertEquals("Hello, World!", result);
    }

    @Test
    void testFinishAndReturnStringWithEscapedCharacters() throws Exception {
        String jsonString = "\"Hello, \\\"World!\\\"\"";
        byte[] inputData = jsonString.getBytes();
        setInputBuffer(inputData);
        parser._tokenIncomplete = true;
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_finishAndReturnString");
        method.setAccessible(true);
        String result = (String) method.invoke(parser);
        assertEquals("Hello, \"World!\"", result);
    }

    @Test
    void testFinishAndReturnStringHandlesEmptyString() throws Exception {
        String jsonString = "\"\"";
        byte[] inputData = jsonString.getBytes();
        setInputBuffer(inputData);
        parser._tokenIncomplete = true;
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_finishAndReturnString");
        method.setAccessible(true);
        String result = (String) method.invoke(parser);
        assertEquals("", result);
    }

    @Test
    void testFinishAndReturnStringHandlesSpecialCharacters() throws Exception {
        String jsonString = "\"Hello, \uD83D\uDE03 World!\"";
        byte[] inputData = jsonString.getBytes();
        setInputBuffer(inputData);
        parser._tokenIncomplete = true;
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_finishAndReturnString");
        method.setAccessible(true);
        String result = (String) method.invoke(parser);
        assertEquals("Hello, 😃 World!", result);
    }

    private void setInputBuffer(byte[] inputData) {
        try {
            // Use reflection to access protected fields
            java.lang.reflect.Field inputPtrField = UTF8StreamJsonParser.class.getSuperclass().getDeclaredField("_inputPtr");
            java.lang.reflect.Field inputEndField = UTF8StreamJsonParser.class.getSuperclass().getDeclaredField("_inputEnd");
            java.lang.reflect.Field inputBufferField = UTF8StreamJsonParser.class.getDeclaredField("_inputBuffer");
            inputPtrField.setAccessible(true);
            inputEndField.setAccessible(true);
            inputBufferField.setAccessible(true);
            inputBufferField.set(parser, inputData);
            inputPtrField.setInt(parser, 0);
            inputEndField.setInt(parser, inputData.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
