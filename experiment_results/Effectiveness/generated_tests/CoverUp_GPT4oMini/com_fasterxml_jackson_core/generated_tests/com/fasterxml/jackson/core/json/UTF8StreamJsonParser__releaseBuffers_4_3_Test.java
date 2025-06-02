package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class UTF8StreamJsonParser__releaseBuffers_4_3_Test {

    private UTF8StreamJsonParser parser;

    private IOContext ioContext;

    private ByteQuadsCanonicalizer symbols;

    @BeforeEach
    void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(bufferRecycler, null, true);
        symbols = ByteQuadsCanonicalizer.createRoot();
        byte[] inputBuffer = new byte[16];
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    void testReleaseBuffers() throws Exception {
        // Set up the parser state
        parser._inputBuffer = new byte[] { 1, 2, 3 };
        parser._bufferRecyclable = true;
        // Invoke the private method _releaseBuffers using reflection
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_releaseBuffers");
        method.setAccessible(true);
        // Call the method
        method.invoke(parser);
        // Verify that the inputBuffer is set to NO_BYTES
        assertArrayEquals(new byte[] {}, parser._inputBuffer);
        // Verify that the IOContext's read buffer has been released
        assertNull(getField(ioContext, "_readIOBuffer"));
    }

    @Test
    void testReleaseBuffersWithoutRecyclable() throws Exception {
        // Set up the parser state
        parser._inputBuffer = new byte[] { 1, 2, 3 };
        parser._bufferRecyclable = false;
        // Invoke the private method _releaseBuffers using reflection
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_releaseBuffers");
        method.setAccessible(true);
        // Call the method
        method.invoke(parser);
        // Verify that the inputBuffer is still not set to NO_BYTES
        assertNotEquals(UTF8StreamJsonParser.class.getDeclaredField("NO_BYTES").get(null), parser._inputBuffer);
        // Verify that the IOContext's read buffer has not been released
        assertNotNull(getField(ioContext, "_readIOBuffer"));
    }

    @Test
    void testReleaseBuffersWithNullInputBuffer() throws Exception {
        // Set up the parser state
        parser._inputBuffer = null;
        parser._bufferRecyclable = true;
        // Invoke the private method _releaseBuffers using reflection
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_releaseBuffers");
        method.setAccessible(true);
        // Call the method
        method.invoke(parser);
        // Verify that the inputBuffer is still null
        assertNull(parser._inputBuffer);
        // Verify that the IOContext's read buffer has been released
        assertNull(getField(ioContext, "_readIOBuffer"));
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
