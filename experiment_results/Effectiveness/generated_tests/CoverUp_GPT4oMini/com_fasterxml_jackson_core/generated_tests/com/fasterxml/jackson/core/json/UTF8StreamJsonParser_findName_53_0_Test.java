package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_findName_53_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer mockSymbols;

    private IOContext mockIOContext;

    @BeforeEach
    public void setUp() {
        mockSymbols = mock(ByteQuadsCanonicalizer.class);
        mockIOContext = mock(IOContext.class);
        parser = new UTF8StreamJsonParser(mockIOContext, 0, new ByteArrayInputStream(new byte[0]), null, mockSymbols, new byte[0], 0, 0, true);
    }

    @Test
    public void testFindNameWhenNameExists() throws JsonParseException, StreamConstraintsException {
        // Represents "abc"
        int[] quads = { 0x61, 0x62, 0x63 };
        int qlen = 3;
        int lastQuad = 0;
        int lastQuadBytes = 0;
        when(mockSymbols.findName(quads, qlen)).thenReturn("abc");
        String result = invokeFindName(quads, qlen, lastQuad, lastQuadBytes);
        assertEquals("abc", result);
    }

    @Test
    public void testFindNameWhenNameDoesNotExist() throws JsonParseException, StreamConstraintsException {
        // Represents "abc"
        int[] quads = { 0x61, 0x62, 0x63 };
        int qlen = 3;
        int lastQuad = 0;
        int lastQuadBytes = 0;
        when(mockSymbols.findName(quads, qlen)).thenReturn(null);
        when(mockSymbols.addName("abc", quads, lastQuadBytes)).thenReturn("abc");
        String result = invokeFindName(quads, qlen, lastQuad, lastQuadBytes);
        assertEquals("abc", result);
    }

    @Test
    public void testFindNameWithGrowingBuffer() throws JsonParseException, StreamConstraintsException {
        // Initial buffer size is smaller than needed
        int[] quads = new int[2];
        int qlen = 2;
        int lastQuad = 0;
        int lastQuadBytes = 0;
        when(mockSymbols.findName(quads, qlen)).thenReturn(null);
        when(mockSymbols.addName("abc", quads, lastQuadBytes)).thenReturn("abc");
        String result = invokeFindName(quads, qlen, lastQuad, lastQuadBytes);
        assertEquals("abc", result);
    }

    private String invokeFindName(int[] quads, int qlen, int lastQuad, int lastQuadBytes) {
        try {
            return (String) UTF8StreamJsonParser.class.getDeclaredMethod("findName", int[].class, int.class, int.class, int.class).invoke(parser, (Object) quads, qlen, lastQuad, lastQuadBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
