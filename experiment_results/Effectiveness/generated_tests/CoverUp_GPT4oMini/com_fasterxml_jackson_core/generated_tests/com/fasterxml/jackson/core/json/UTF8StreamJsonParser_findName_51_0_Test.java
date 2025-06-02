package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser_findName_51_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer mockCanonicalizer;

    @BeforeEach
    void setUp() {
        IOContext context = new IOContext(null, null, null, null, null, true);
        mockCanonicalizer = mock(ByteQuadsCanonicalizer.class);
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        parser = new UTF8StreamJsonParser(context, 0, inputStream, null, mockCanonicalizer, new byte[0], 0, 0, false);
    }

    @Test
    void testFindName_CanonicalNameFound() throws JsonParseException, StreamConstraintsException {
        int q1 = 0x12345678;
        int q2 = 0x9ABCDEF0;
        int lastQuadBytes = 4;
        String expectedName = "testName";
        Mockito.when(mockCanonicalizer.findName(q1, q2)).thenReturn(expectedName);
        String result = invokeFindName(q1, q2, lastQuadBytes);
        assertEquals(expectedName, result);
    }

    @Test
    void testFindName_NameNotFound_AddsName() throws JsonParseException, StreamConstraintsException {
        int q1 = 0x12345678;
        int q2 = 0x9ABCDEF0;
        int lastQuadBytes = 4;
        Mockito.when(mockCanonicalizer.findName(q1, q2)).thenReturn(null);
        String expectedName = "addedName";
        Mockito.when(invokeAddName(q1, q2, lastQuadBytes)).thenReturn(expectedName);
        String result = invokeFindName(q1, q2, lastQuadBytes);
        assertEquals(expectedName, result);
    }

    @Test
    void testFindName_ThrowsException() {
        int q1 = 0x12345678;
        int q2 = 0x9ABCDEF0;
        int lastQuadBytes = 4;
        Mockito.when(mockCanonicalizer.findName(q1, q2)).thenThrow(new JsonParseException(null, "Error"));
        assertThrows(JsonParseException.class, () -> invokeFindName(q1, q2, lastQuadBytes));
    }

    private String invokeFindName(int q1, int q2, int lastQuadBytes) throws JsonParseException, StreamConstraintsException {
        try {
            Method method = UTF8StreamJsonParser.class.getDeclaredMethod("findName", int.class, int.class, int.class);
            method.setAccessible(true);
            return (String) method.invoke(parser, q1, q2, lastQuadBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String invokeAddName(int q1, int q2, int lastQuadBytes) {
        try {
            Method method = UTF8StreamJsonParser.class.getDeclaredMethod("addName", int[].class, int.class, int.class);
            method.setAccessible(true);
            return (String) method.invoke(parser, new int[] { q1, q2 }, 2, lastQuadBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
