package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class MergedStream_reset_7_0_Test {

    private IOContext mockContext;

    private InputStream mockInputStream;

    private byte[] buffer;

    private MergedStream mergedStream;

    @BeforeEach
    public void setUp() {
        mockContext = mock(IOContext.class);
        mockInputStream = mock(InputStream.class);
        buffer = new byte[10];
        mergedStream = new MergedStream(mockContext, mockInputStream, buffer, 0, buffer.length);
    }

    @Test
    public void testResetWithNullBuffer() throws Exception {
        // Accessing the private field _b using reflection
        java.lang.reflect.Field bField = MergedStream.class.getDeclaredField("_b");
        bField.setAccessible(true);
        // Set _b to null
        bField.set(mergedStream, null);
        // Act
        mergedStream.reset();
        // Assert
        verify(mockInputStream).reset();
    }

    @Test
    public void testResetWithNonNullBuffer() throws Exception {
        // Accessing the private field _b using reflection
        java.lang.reflect.Field bField = MergedStream.class.getDeclaredField("_b");
        bField.setAccessible(true);
        // Set _b to a non-null value
        bField.set(mergedStream, new byte[10]);
        // Act
        mergedStream.reset();
        // Assert
        verify(mockInputStream, never()).reset();
    }
}
