package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class util_ClassUtil_closeOnFailAndThrowAsIOE_JsonGenerator_Closeable_Exception_cfg_path_7_Test {

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
            // Check that the exception was thrown as expected
            assert e.getCause() == fail;
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOEWithGeneratorCloseException() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        // Simulate JsonGenerator close throwing an exception
        try {
            doThrow(new IOException("Generator close failed")).when(mockGenerator).close();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assert e.getCause() instanceof Exception;
            assert e.getCause().getMessage().contains("Initial failure");
            assert e.getCause().getSuppressed()[0].getMessage().contains("Generator close failed");
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOEWithCloseableCloseException() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        // Simulate Closeable close throwing an exception
        try {
            doThrow(new IOException("Closeable close failed")).when(mockCloseable).close();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assert e.getCause() instanceof Exception;
            assert e.getCause().getMessage().contains("Initial failure");
            assert e.getCause().getSuppressed()[0].getMessage().contains("Closeable close failed");
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }


}