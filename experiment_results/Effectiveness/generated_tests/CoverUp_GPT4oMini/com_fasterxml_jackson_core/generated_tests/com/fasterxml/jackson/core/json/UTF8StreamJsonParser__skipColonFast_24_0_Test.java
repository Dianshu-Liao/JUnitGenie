package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
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

public class UTF8StreamJsonParser__skipColonFast_24_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext context;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        symbols = Mockito.mock(ByteQuadsCanonicalizer.class);
        context = new IOContext(new BufferRecycler(), null, true);
        inputBuffer = new byte[] { ':', ' ', '1', '\n', ':', '2', '\t', ':', '3' };
        parser = new UTF8StreamJsonParser(context, 0, new ByteArrayInputStream(inputBuffer), Mockito.mock(ObjectCodec.class), symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    public void testSkipColonFast_NoLeadingSpace() throws IOException {
        // Test for the case where there is no leading space
        int result = invokeSkipColonFast(0);
        assertEquals('1', result);
    }

    @Test
    public void testSkipColonFast_WithLeadingSpace() throws IOException {
        // Test for the case where there is a leading space
        int result = invokeSkipColonFast(1);
        assertEquals('2', result);
    }

    @Test
    public void testSkipColonFast_WithTrailingSpace() throws IOException {
        // Test for the case where there is a trailing space
        int result = invokeSkipColonFast(3);
        assertEquals('3', result);
    }

    @Test
    public void testSkipColonFast_WithComment() throws IOException {
        // Mock input to simulate a comment
        // Change to comment character
        inputBuffer[1] = '/';
        int result = invokeSkipColonFast(0);
        // Expect to skip the comment and get '2'
        assertEquals('2', result);
    }

    private int invokeSkipColonFast(int ptr) throws IOException {
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
            method.setAccessible(true);
            return (int) method.invoke(parser, ptr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
