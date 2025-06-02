package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class util_ClassUtil_closeOnFailAndThrowAsIOE_JsonGenerator_Closeable_Exception_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOE() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new IOException("Initial failure");

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assertTrue(e.getCause() instanceof IOException);
            assertEquals("Initial failure", e.getCause().getMessage());
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOEWithCloseableException() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new IOException("Initial failure");

        doThrow(new IOException("Closeable failure")).when(mockCloseable).close();

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assertTrue(e.getCause() instanceof IOException);
            assertEquals("Initial failure", e.getCause().getMessage());
            assertEquals("Closeable failure", e.getSuppressed()[0].getMessage());
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOEWithGeneratorException() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new IOException("Initial failure");

        doThrow(new IOException("Generator failure")).when(mockGenerator).close();

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assertTrue(e.getCause() instanceof IOException);
            assertEquals("Initial failure", e.getCause().getMessage());
            assertEquals("Generator failure", e.getSuppressed()[0].getMessage());
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

}