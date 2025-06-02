package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__skipColonFast_24_1_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        symbols = mock(ByteQuadsCanonicalizer.class);
        ioContext = mock(IOContext.class);
        inputBuffer = new byte[10];
        parser = new UTF8StreamJsonParser(ioContext, 0, null, null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    private int invokeSkipColonFast(int ptr) throws Exception {
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
        // Make the private method accessible
        method.setAccessible(true);
        return (int) method.invoke(parser, ptr);
    }

    @Test
    public void testSkipColonFast_WithValidColon_NoLeadingSpace() throws Exception {
        inputBuffer[0] = (byte) ':';
        inputBuffer[1] = (byte) 'a';
        int result = invokeSkipColonFast(0);
        assertEquals('a', result);
    }

    @Test
    public void testSkipColonFast_WithLeadingSpace() throws Exception {
        inputBuffer[0] = (byte) ' ';
        inputBuffer[1] = (byte) ':';
        inputBuffer[2] = (byte) 'b';
        int result = invokeSkipColonFast(0);
        assertEquals('b', result);
    }

    @Test
    public void testSkipColonFast_WithTabsAndSpaces() throws Exception {
        inputBuffer[0] = (byte) '\t';
        inputBuffer[1] = (byte) ':';
        inputBuffer[2] = (byte) 'c';
        int result = invokeSkipColonFast(0);
        assertEquals('c', result);
    }

    @Test
    public void testSkipColonFast_WithTrailingSpace() throws Exception {
        inputBuffer[0] = (byte) ':';
        inputBuffer[1] = (byte) ' ';
        inputBuffer[2] = (byte) 'd';
        int result = invokeSkipColonFast(0);
        assertEquals('d', result);
    }

    @Test
    public void testSkipColonFast_WithCommentAfterColon() throws Exception {
        inputBuffer[0] = (byte) ':';
        inputBuffer[1] = (byte) '/';
        inputBuffer[2] = (byte) 'c';
        int result = invokeSkipColonFast(0);
        assertEquals('c', result);
    }
}
