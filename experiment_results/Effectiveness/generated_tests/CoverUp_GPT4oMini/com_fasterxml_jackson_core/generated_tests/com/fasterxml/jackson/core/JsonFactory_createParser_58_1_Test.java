package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.StreamReadConstraints;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

@ExtendWith(MockitoExtension.class)
class JsonFactory_createParser_58_1_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testCreateParser_ValidInput() throws Exception {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        int len = data.length;
        JsonParser parser = invokeCreateParser(data, offset, len);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    void testCreateParser_WithInputDecorator() throws Exception {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        int len = data.length;
        InputDecorator mockDecorator = mock(InputDecorator.class);
        InputStream mockStream = mock(InputStream.class);
        when(mockDecorator.decorate(any(), any(byte[].class), anyInt(), anyInt())).thenReturn(mockStream);
        jsonFactory.setInputDecorator(mockDecorator);
        JsonParser parser = invokeCreateParser(data, offset, len);
        assertNotNull(parser);
        verify(mockDecorator).decorate(any(), eq(data), eq(offset), eq(len));
        parser.close();
    }

    @Test
    void testCreateParser_InvalidRange() {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = -1;
        int len = data.length;
        assertThrows(IndexOutOfBoundsException.class, () -> invokeCreateParser(data, offset, len));
    }

    @Test
    void testCreateParser_ZeroLength() throws Exception {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        int len = 0;
        JsonParser parser = invokeCreateParser(data, offset, len);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    void testCreateParser_NullInput() {
        assertThrows(NullPointerException.class, () -> invokeCreateParser(null, 0, 0));
    }

    @Test
    void testCreateParser_OffsetOutOfBounds() {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = data.length + 1;
        int len = 1;
        assertThrows(IndexOutOfBoundsException.class, () -> invokeCreateParser(data, offset, len));
    }

    @Test
    void testCreateParser_LengthOutOfBounds() {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        int len = data.length + 1;
        assertThrows(IndexOutOfBoundsException.class, () -> invokeCreateParser(data, offset, len));
    }

    private JsonParser invokeCreateParser(byte[] data, int offset, int len) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("createParser", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (JsonParser) method.invoke(jsonFactory, data, offset, len);
    }
}
