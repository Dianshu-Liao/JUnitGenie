package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class util_ClassUtil_closeOnFailAndThrowAsIOE_JsonGenerator_Closeable_Exception_cfg_path_2_Test {

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
            assert e.getCause() == fail; // Ensure the original exception is the cause
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOE_GeneratorCloseThrowsException() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        // Simulate JsonGenerator behavior
        try {
            doThrow(new IOException("Generator close failed")).when(mockGenerator).close();
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assert e.getCause() instanceof IOException; // Ensure IOException is caught
            assert e.getCause().getMessage().equals("Generator close failed");
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOE_CloseableCloseThrowsException() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        // Simulate JsonGenerator behavior
        try {
            doNothing().when(mockGenerator).close();
            doThrow(new IOException("Closeable close failed")).when(mockCloseable).close();
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assert e.getCause() instanceof IOException; // Ensure IOException is caught
            assert e.getCause().getMessage().equals("Closeable close failed");
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }


}