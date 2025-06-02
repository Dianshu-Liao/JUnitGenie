package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class util_ClassUtil_closeOnFailAndThrowAsIOE_JsonGenerator_Closeable_Exception_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOE() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assertEquals("Initial failure", e.getCause().getMessage());
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOE_GeneratorCloseThrowsException() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        doThrow(new IOException("Generator close failed")).when(mockGenerator).close();

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assertTrue(e.getCause() instanceof Exception);
            assertEquals("Initial failure", e.getCause().getMessage());
            assertEquals("Generator close failed", e.getCause().getSuppressed()[0].getMessage());
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOE_CloseableCloseThrowsException() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        doThrow(new IOException("Closeable close failed")).when(mockCloseable).close();

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assertTrue(e.getCause() instanceof Exception);
            assertEquals("Initial failure", e.getCause().getMessage());
            assertEquals("Closeable close failed", e.getCause().getSuppressed()[0].getMessage());
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }


}