package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_findName_50_0_Test {

    @Mock
    private ByteQuadsCanonicalizer mockCanonicalizer;

    private UTF8StreamJsonParser parser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        IOContext context = mock(IOContext.class);
        parser = new UTF8StreamJsonParser(context, 0, new ByteArrayInputStream(new byte[0]), null, mockCanonicalizer, new byte[0], 0, 0, false);
    }

    @Test
    public void testFindName_existingName() throws JsonParseException, StreamConstraintsException {
        // example quad
        int q1 = 123456;
        when(mockCanonicalizer.findName(q1)).thenReturn("existingName");
        // lastQuadBytes = 0
        String result = invokeFindName(q1, 0);
        assertEquals("existingName", result);
        verify(mockCanonicalizer).findName(q1);
    }

    @Test
    public void testFindName_newName() throws JsonParseException, StreamConstraintsException {
        // example quad
        int q1 = 123456;
        when(mockCanonicalizer.findName(q1)).thenReturn(null);
        when(mockCanonicalizer.addName(any(), anyInt(), anyInt())).thenReturn("newName");
        // lastQuadBytes = 0
        String result = invokeFindName(q1, 0);
        assertEquals("newName", result);
        verify(mockCanonicalizer).findName(q1);
        verify(mockCanonicalizer).addName(any(), anyInt(), anyInt());
    }

    @Test
    public void testFindName_withLastQuadBytes() throws JsonParseException, StreamConstraintsException {
        // example quad
        int q1 = 123456;
        // example last quad bytes
        int lastQuadBytes = 2;
        when(mockCanonicalizer.findName(q1)).thenReturn(null);
        when(mockCanonicalizer.addName(any(), anyInt(), eq(lastQuadBytes))).thenReturn("newNameWithLastQuadBytes");
        String result = invokeFindName(q1, lastQuadBytes);
        assertEquals("newNameWithLastQuadBytes", result);
        verify(mockCanonicalizer).findName(q1);
        verify(mockCanonicalizer).addName(any(), anyInt(), eq(lastQuadBytes));
    }

    private String invokeFindName(int q1, int lastQuadBytes) {
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("findName", int.class, int.class);
            method.setAccessible(true);
            return (String) method.invoke(parser, q1, lastQuadBytes);
        } catch (Exception e) {
            fail("Reflection invocation failed: " + e.getMessage());
            return null;
        }
    }
}
