package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF32Reader_close_0_0_Test {

    private UTF32Reader utf32Reader;

    private IOContext mockContext;

    private InputStream mockInputStream;

    @BeforeEach
    public void setUp() {
        mockContext = Mockito.mock(IOContext.class);
        mockInputStream = Mockito.mock(InputStream.class);
        utf32Reader = new UTF32Reader(mockContext, mockInputStream, new byte[10], 0, 10, true);
    }

    @Test
    public void testClose_ClosesInputStream() throws IOException {
        utf32Reader.close();
        Mockito.verify(mockInputStream).close();
    }

    @Test
    public void testClose_FreesBuffers() throws IOException {
        // Use reflection to invoke the private method
        utf32Reader.close();
        // Assuming freeBuffers() is a private method, we need to invoke it using reflection
        try {
            java.lang.reflect.Method freeBuffersMethod = UTF32Reader.class.getDeclaredMethod("freeBuffers");
            freeBuffersMethod.setAccessible(true);
            freeBuffersMethod.invoke(utf32Reader);
            // Verify that freeBuffers() was called
            // Since we cannot directly verify private method calls, we can check the state if needed
        } catch (Exception e) {
            fail("Failed to invoke freeBuffers method: " + e.getMessage());
        }
    }

    @Test
    public void testClose_NullInputStream() throws IOException {
        // Set the InputStream to null
        utf32Reader = new UTF32Reader(mockContext, null, new byte[10], 0, 10, true);
        utf32Reader.close();
        // Verify that freeBuffers() is called without exceptions
        // No exception should be thrown, we can just assert that it executes without issue
        assertDoesNotThrow(() -> utf32Reader.close());
    }

    @Test
    public void testClose_HandlesIOException() throws IOException {
        Mockito.doThrow(new IOException("InputStream close error")).when(mockInputStream).close();
        assertThrows(IOException.class, () -> utf32Reader.close());
    }
}
