package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser__skipWS_60_1_Test {

    @Mock
    private DataInput inputData;

    @InjectMocks
    private UTF8DataInputJsonParser parser;

    private static final int INT_SPACE = 32;

    private static final int INT_SLASH = 47;

    private static final int INT_HASH = 35;

    private static final int INT_CR = 13;

    private static final int INT_LF = 10;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Initialize to simulate reading the next byte
        parser._nextByte = -1;
    }

    @Test
    public void testSkipWhitespaceWithSpace() throws IOException {
        // ASCII 'A'
        when(inputData.readUnsignedByte()).thenReturn(INT_SPACE, INT_SPACE, 65);
        int result = invokePrivateSkipWS();
        assertEquals(65, result);
    }

    @Test
    public void testSkipWhitespaceWithComment() throws IOException {
        // ASCII 'A'
        when(inputData.readUnsignedByte()).thenReturn(INT_SLASH, 65);
        int result = invokePrivateSkipWS();
        assertEquals(65, result);
    }

    @Test
    public void testSkipWhitespaceWithLineFeed() throws IOException {
        // ASCII 'A'
        when(inputData.readUnsignedByte()).thenReturn(INT_LF, 65);
        int result = invokePrivateSkipWS();
        assertEquals(65, result);
    }

    @Test
    public void testSkipWhitespaceWithCarriageReturn() throws IOException {
        // ASCII 'A'
        when(inputData.readUnsignedByte()).thenReturn(INT_CR, 65);
        int result = invokePrivateSkipWS();
        assertEquals(65, result);
    }

    @Test
    public void testSkipWhitespaceWithMultipleSpaces() throws IOException {
        // ASCII 'B'
        when(inputData.readUnsignedByte()).thenReturn(INT_SPACE, INT_SPACE, INT_SPACE, 66);
        int result = invokePrivateSkipWS();
        assertEquals(66, result);
    }

    @Test
    public void testSkipWhitespaceWithMultipleSpacesAndComment() throws IOException {
        // ASCII 'C'
        when(inputData.readUnsignedByte()).thenReturn(INT_SPACE, INT_SPACE, INT_SLASH, 67);
        int result = invokePrivateSkipWS();
        assertEquals(67, result);
    }

    // Reflection method to invoke the private _skipWS method
    private int invokePrivateSkipWS() {
        try {
            Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_skipWS");
            method.setAccessible(true);
            return (int) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
