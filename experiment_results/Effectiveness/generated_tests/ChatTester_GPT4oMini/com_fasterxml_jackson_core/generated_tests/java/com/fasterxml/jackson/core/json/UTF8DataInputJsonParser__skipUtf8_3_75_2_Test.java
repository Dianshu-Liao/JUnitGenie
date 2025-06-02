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

public class UTF8DataInputJsonParser__skipUtf8_3_75_2_Test {

    private UTF8DataInputJsonParser parser;

    private DataInput mockDataInput;

    @BeforeEach
    public void setUp() {
        mockDataInput = mock(DataInput.class);
        IOContext ctxt = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        ByteQuadsCanonicalizer symbols = mock(ByteQuadsCanonicalizer.class);
        parser = new UTF8DataInputJsonParser(ctxt, 0, mockDataInput, codec, symbols, 0);
    }

    @Test
    public void testSkipUtf8_3_ValidBytes() throws Exception {
        // Arrange
        // Valid UTF-8 continuation bytes
        when(mockDataInput.readUnsignedByte()).thenReturn(0xC0, 0x80);
        // Act
        invokePrivateMethod("_skipUtf8_3");
        // Assert
        // No exception should be thrown
    }

    @Test
    public void testSkipUtf8_3_InvalidFirstByte() throws Exception {
        // Arrange
        // Invalid first byte
        when(mockDataInput.readUnsignedByte()).thenReturn(0xC1, 0x80);
        // Act & Assert
        assertThrows(IOException.class, () -> invokePrivateMethod("_skipUtf8_3"));
    }

    @Test
    public void testSkipUtf8_3_InvalidSecondByte() throws Exception {
        // Arrange
        // Invalid second byte
        when(mockDataInput.readUnsignedByte()).thenReturn(0xC0, 0x90);
        // Act & Assert
        assertThrows(IOException.class, () -> invokePrivateMethod("_skipUtf8_3"));
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        // Fixed line: Changed 'var' to 'Method' for type declaration
        java.lang.reflect.Method method = UTF8DataInputJsonParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(parser);
    }
}
