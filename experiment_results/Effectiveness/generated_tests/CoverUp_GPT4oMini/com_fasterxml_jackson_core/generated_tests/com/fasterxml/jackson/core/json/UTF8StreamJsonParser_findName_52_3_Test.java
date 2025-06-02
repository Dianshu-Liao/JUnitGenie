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

@ExtendWith(MockitoExtension.class)
public class UTF8StreamJsonParser_findName_52_3_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer mockSymbols;

    @BeforeEach
    public void setUp() {
        IOContext ioContext = mock(IOContext.class);
        mockSymbols = mock(ByteQuadsCanonicalizer.class);
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(new byte[0]), null, mockSymbols, new byte[0], 0, 0, true);
    }

    @Test
    public void testFindNameWithExistingName() throws JsonParseException, StreamConstraintsException {
        // Given
        int q1 = 1, q2 = 2, q3 = 3, lastQuadBytes = 4;
        when(mockSymbols.findName(q1, q2, q3)).thenReturn("name");
        // When
        String result = invokeFindName(q1, q2, q3, lastQuadBytes);
        // Then
        assertEquals("name", result);
        verify(mockSymbols).findName(q1, q2, q3);
    }

    @Test
    public void testFindNameWithNewName() throws JsonParseException, StreamConstraintsException {
        // Given
        int q1 = 1, q2 = 2, q3 = 3, lastQuadBytes = 4;
        when(mockSymbols.findName(q1, q2, q3)).thenReturn(null);
        when(mockSymbols.addName(any(), anyInt(), anyInt())).thenReturn("newName");
        // When
        String result = invokeFindName(q1, q2, q3, lastQuadBytes);
        // Then
        assertEquals("newName", result);
        verify(mockSymbols).findName(q1, q2, q3);
        verify(mockSymbols).addName(any(), anyInt(), anyInt());
    }

    @Test
    public void testFindNameWithInvalidInput() {
        // Given
        int q1 = 0, q2 = 0, q3 = 0, lastQuadBytes = 0;
        // When & Then
        assertThrows(JsonParseException.class, () -> invokeFindName(q1, q2, q3, lastQuadBytes));
    }

    private String invokeFindName(int q1, int q2, int q3, int lastQuadBytes) {
        try {
            // Using reflection to access the private method
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("findName", int.class, int.class, int.class, int.class);
            method.setAccessible(true);
            return (String) method.invoke(parser, q1, q2, q3, lastQuadBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
