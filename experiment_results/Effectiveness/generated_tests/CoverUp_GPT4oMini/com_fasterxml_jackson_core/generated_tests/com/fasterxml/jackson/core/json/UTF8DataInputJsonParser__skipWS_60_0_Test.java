package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser__skipWS_60_0_Test {

    @Mock
    private DataInput mockDataInput;

    private UTF8DataInputJsonParser parser;

    private IOContext ioContext;

    private ByteQuadsCanonicalizer symbols;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ioContext = new IOContext(null, null, null, null, null, false);
        symbols = ByteQuadsCanonicalizer.createRoot();
        parser = new UTF8DataInputJsonParser(ioContext, 0, mockDataInput, null, symbols, -1);
    }

    @Test
    public void testSkipWS_NextByteNegative_ReadsByte() throws Exception {
        // Arrange
        // TAB character
        when(mockDataInput.readUnsignedByte()).thenReturn(9);
        // Act
        int result = invokeSkipWS(parser);
        // Assert
        assertEquals(9, result);
        verify(mockDataInput, times(1)).readUnsignedByte();
    }

    @Test
    public void testSkipWS_NextBytePositive_ReturnsNextByte() throws Exception {
        // Arrange
        // Line Feed character
        parser._nextByte = 10;
        // Act
        int result = invokeSkipWS(parser);
        // Assert
        assertEquals(10, result);
        // nextByte should be reset
        assertEquals(-1, parser._nextByte);
    }

    @Test
    public void testSkipWS_Whitespace_ReadsNextByte() throws Exception {
        // Arrange
        // Space, Carriage Return, Tab, Slash
        // Space
        // Space
        // Carriage Return
        when(mockDataInput.readUnsignedByte()).// Carriage Return
        thenReturn(// Tab
        32).// Tab
        thenReturn(// Slash
        13).// Slash
        thenReturn(9).thenReturn(47);
        // Act
        int result = invokeSkipWS(parser);
        // Assert
        // Should return the slash
        assertEquals(47, result);
        // Row should increment on CR
        assertEquals(1, invokeGetCurrInputRow(parser));
    }

    @Test
    public void testSkipWS_SlashComment_ReadsUntilEndOfComment() throws Exception {
        // Arrange
        // Slash
        // Slash
        // New line to simulate end of comment
        when(mockDataInput.readUnsignedByte()).// New line to simulate end of comment
        thenReturn(47).thenReturn(10);
        // Act
        int result = invokeSkipWS(parser);
        // Assert
        // Should return the new line
        assertEquals(10, result);
        // Here we would need to verify if _skipWSComment is called correctly,
        // but since it's private we can't directly test it.
    }

    private int invokeSkipWS(UTF8DataInputJsonParser parser) throws Exception {
        java.lang.reflect.Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_skipWS");
        method.setAccessible(true);
        return (int) method.invoke(parser);
    }

    private int invokeGetCurrInputRow(UTF8DataInputJsonParser parser) throws Exception {
        java.lang.reflect.Field field = UTF8DataInputJsonParser.class.getDeclaredField("_currInputRow");
        field.setAccessible(true);
        return (int) field.get(parser);
    }
}
