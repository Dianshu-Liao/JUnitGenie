package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(MockitoExtension.class)
class UTF8StreamJsonParser__skipColonFast_24_0_Test {

    private UTF8StreamJsonParser parser;

    private byte[] inputBuffer;

    @BeforeEach
    void setUp() {
        inputBuffer = new byte[] { // INT_COLON
        // INT_SPACE
        // '"' character
        // '#' for comment
        58, // Tab character
        32, // New line character
        34, // 'A'
        35, 9, 10, 65 };
        IOContext ctxt = new IOContext(null, null, null, null, null, false);
        ByteQuadsCanonicalizer symbols = ByteQuadsCanonicalizer.createRoot();
        parser = new UTF8StreamJsonParser(ctxt, 0, null, null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    private int skipColonFastWrapper(int ptr) throws Exception {
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
        method.setAccessible(true);
        return (int) method.invoke(parser, ptr);
    }

    @Test
    void testSkipColonFast_WhenColonIsFirstCharacter() throws Exception {
        int result = skipColonFastWrapper(0);
        assertEquals(32, result);
    }

    @Test
    void testSkipColonFast_WhenSpaceIsBeforeColon() throws Exception {
        int result = skipColonFastWrapper(1);
        assertEquals(34, result);
    }

    @Test
    void testSkipColonFast_WhenCommentFollowsColon() throws Exception {
        int result = skipColonFastWrapper(6);
        assertEquals(65, result);
    }

    @Test
    void testSkipColonFast_WhenTabBeforeColon() throws Exception {
        int result = skipColonFastWrapper(4);
        assertEquals(58, result);
    }
}
