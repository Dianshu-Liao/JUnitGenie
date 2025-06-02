package com.fasterxml.jackson.core.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

public class UTF8StreamJsonParser__skipUtf8_4_89_4_Test {

    private UTF8StreamJsonParser parser;

    private InputStream mockInputStream;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() throws Exception {
        mockInputStream = mock(InputStream.class);
        inputBuffer = new byte[16];
        // Correctly instantiate ByteQuadsCanonicalizer with required parameters
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot();
        parser = new UTF8StreamJsonParser(new IOContext(new BufferRecycler(), mockInputStream, false), 0, mockInputStream, null, byteQuadsCanonicalizer, inputBuffer, 0, inputBuffer.length, true);
        // Fixed Buggy Line: Handle exceptions correctly
        setField(parser, "_inputBuffer", inputBuffer);
        setField(parser, "_inputPtr", 0);
        setField(parser, "_inputEnd", inputBuffer.length);
    }

    @Test
    public void testSkipUtf8_4_ValidInput() throws Exception {
        // Arrange
        setField(parser, "_inputBuffer", new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 });
        setField(parser, "_inputPtr", 0);
        setField(parser, "_inputEnd", ((byte[]) getField(parser, "_inputBuffer")).length);
        // Act
        invokePrivateMethod("_skipUtf8_4", 0);
        // Assert
        assertEquals(4, getField(parser, "_inputPtr"));
    }

    @Test
    public void testSkipUtf8_4_InvalidInput() throws Exception {
        // Arrange
        setField(parser, "_inputBuffer", new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 });
        setField(parser, "_inputPtr", 0);
        setField(parser, "_inputEnd", ((byte[]) getField(parser, "_inputBuffer")).length);
        // Act & Assert
        assertThrows(IOException.class, () -> invokePrivateMethod("_skipUtf8_4", 0));
    }

    @Test
    public void testSkipUtf8_4_InputEndReached() throws Exception {
        // Arrange
        setField(parser, "_inputBuffer", new byte[] { (byte) 0xF0, (byte) 0x9F });
        setField(parser, "_inputPtr", 0);
        setField(parser, "_inputEnd", ((byte[]) getField(parser, "_inputBuffer")).length);
        // Act & Assert
        assertThrows(IOException.class, () -> invokePrivateMethod("_skipUtf8_4", 0));
    }

    private void invokePrivateMethod(String methodName, int c) throws Exception {
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(parser, c);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
