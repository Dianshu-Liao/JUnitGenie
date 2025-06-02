package com.fasterxml.jackson.core.io;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class MergedStream_skip_8_1_Test {

    private IOContext mockContext;

    private InputStream mockInputStream;

    private byte[] buffer;

    private MergedStream mergedStream;

    @BeforeEach
    public void setUp() {
        mockContext = Mockito.mock(IOContext.class);
        mockInputStream = Mockito.mock(InputStream.class);
        buffer = new byte[10];
        mergedStream = new MergedStream(mockContext, mockInputStream, buffer, 0, buffer.length);
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        Field field = MergedStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(mergedStream, value);
    }

    @Test
    public void testSkipWithBufferedData() throws Exception {
        setPrivateField("_b", buffer);
        setPrivateField("_ptr", 0);
        setPrivateField("_end", buffer.length);
        long skipped = mergedStream.skip(5);
        assertEquals(5, skipped);
        assertEquals(5, getPrivateField("_ptr"));
    }

    @Test
    public void testSkipWithPartialBuffer() throws Exception {
        setPrivateField("_b", buffer);
        setPrivateField("_ptr", 0);
        setPrivateField("_end", buffer.length);
        long skipped = mergedStream.skip(15);
        assertEquals(10, skipped);
        assertEquals(10, getPrivateField("_ptr"));
    }

    @Test
    public void testSkipWithInputStream() throws Exception {
        setPrivateField("_b", null);
        setPrivateField("_ptr", 0);
        setPrivateField("_end", 0);
        Mockito.when(mockInputStream.skip(5)).thenReturn(5L);
        long skipped = mergedStream.skip(5);
        assertEquals(5, skipped);
    }

    @Test
    public void testSkipWithZero() throws Exception {
        setPrivateField("_b", null);
        setPrivateField("_ptr", 0);
        setPrivateField("_end", 0);
        long skipped = mergedStream.skip(0);
        assertEquals(0, skipped);
    }

    @Test
    public void testSkipWithNegative() throws Exception {
        setPrivateField("_b", null);
        setPrivateField("_ptr", 0);
        setPrivateField("_end", 0);
        long skipped = mergedStream.skip(-5);
        assertEquals(0, skipped);
    }

    @Test
    public void testSkipWithBufferedDataAndInputStream() throws Exception {
        setPrivateField("_b", buffer);
        setPrivateField("_ptr", 0);
        setPrivateField("_end", buffer.length);
        Mockito.when(mockInputStream.skip(5)).thenReturn(5L);
        long skipped = mergedStream.skip(15);
        assertEquals(10, skipped);
        assertEquals(10, getPrivateField("_ptr"));
        Mockito.verify(mockInputStream).skip(5);
    }

    private long getPrivateField(String fieldName) throws Exception {
        Field field = MergedStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getLong(mergedStream);
    }
}
