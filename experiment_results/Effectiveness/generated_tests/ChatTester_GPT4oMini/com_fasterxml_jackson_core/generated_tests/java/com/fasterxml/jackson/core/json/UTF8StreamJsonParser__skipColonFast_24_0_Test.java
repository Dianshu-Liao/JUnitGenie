// Test method
package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__skipColonFast_24_0_Test {

    private UTF8StreamJsonParser parser;

    @Mock
    private IOContext ioContext;

    @Mock
    private ObjectCodec objectCodec;

    @Mock
    private ByteQuadsCanonicalizer byteQuadsCanonicalizer;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Example input buffer
        inputBuffer = new byte[] { ':', ' ', 'a', 'b', 'c', ' ', '\n', '}' };
        parser = new UTF8StreamJsonParser(ioContext, 0, mock(InputStream.class), objectCodec, byteQuadsCanonicalizer, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    public void testSkipColonFast_ColonWithoutSpaces() throws Exception {
        int result = invokeSkipColonFast(0);
        assertEquals('a', result);
    }

    @Test
    public void testSkipColonFast_ColonWithLeadingSpace() throws Exception {
        int result = invokeSkipColonFast(1);
        assertEquals('a', result);
    }

    @Test
    public void testSkipColonFast_ColonWithTrailingSpace() throws Exception {
        int result = invokeSkipColonFast(2);
        assertEquals('a', result);
    }

    @Test
    public void testSkipColonFast_ColonWithLeadingAndTrailingSpace() throws Exception {
        int result = invokeSkipColonFast(3);
        assertEquals('a', result);
    }

    @Test
    public void testSkipColonFast_ColonWithSpecialChars() throws Exception {
        // Special character after colon
        inputBuffer = new byte[] { ':', ' ', '#', ' ', 'a' };
        parser = new UTF8StreamJsonParser(ioContext, 0, mock(InputStream.class), objectCodec, byteQuadsCanonicalizer, inputBuffer, 0, inputBuffer.length, true);
        int result = invokeSkipColonFast(0);
        assertEquals('a', result);
    }

    @Test
    public void testSkipColonFast_NoColon() throws Exception {
        // No colon present
        inputBuffer = new byte[] { 'a', ' ', 'b' };
        parser = new UTF8StreamJsonParser(ioContext, 0, mock(InputStream.class), objectCodec, byteQuadsCanonicalizer, inputBuffer, 0, inputBuffer.length, true);
        int result = invokeSkipColonFast(0);
        // Should return space as no colon was found
        assertEquals(' ', result);
    }

    private int invokeSkipColonFast(int ptr) throws Exception {
        // Fixed line: changed 'var' to 'java.lang.reflect.Method'
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
        method.setAccessible(true);
        return (int) method.invoke(parser, ptr);
    }
}
