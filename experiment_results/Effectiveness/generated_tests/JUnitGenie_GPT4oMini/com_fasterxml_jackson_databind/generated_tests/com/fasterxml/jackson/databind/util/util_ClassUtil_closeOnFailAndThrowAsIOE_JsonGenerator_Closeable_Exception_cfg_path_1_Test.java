package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.fail;

public class util_ClassUtil_closeOnFailAndThrowAsIOE_JsonGenerator_Closeable_Exception_cfg_path_1_Test {

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
            assert e.getCause() instanceof IOException;
            assert e.getCause().getSuppressed().length == 0; // No suppressed exceptions
        } catch (IOException e) {
            // This catch block is necessary to handle the IOException thrown by ClassUtil.closeOnFailAndThrowAsIOE
            fail("IOException should not occur.");
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOEWithGeneratorCloseException() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new IOException("Initial failure");

        // Simulate exception when closing the generator
        try {
            doThrow(new IOException("Generator close failure")).when(mockGenerator).close();
        } catch (IOException e) {
            // Handle the exception properly
            fail("Unexpected IOException");
        }

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assert e.getCause() instanceof IOException;
            assert e.getCause().getSuppressed().length == 1; // One suppressed exception
            assert e.getCause().getSuppressed()[0].getMessage().equals("Generator close failure");
        } catch (IOException e) {
            // This catch block is necessary to handle the IOException thrown by ClassUtil.closeOnFailAndThrowAsIOE
            fail("IOException should not occur.");
        }
    }

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOEWithCloseableCloseException() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new IOException("Initial failure");

        // Simulate exception when closing the closeable
        try {
            doThrow(new IOException("Closeable close failure")).when(mockCloseable).close();
        } catch (IOException e) {
            // Handle the exception properly
            fail("Unexpected IOException");
        }

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (RuntimeException e) {
            // Assert
            assert e.getCause() instanceof IOException;
            assert e.getCause().getSuppressed().length == 1; // One suppressed exception
            assert e.getCause().getSuppressed()[0].getMessage().equals("Closeable close failure");
        } catch (IOException e) {
            // This catch block is necessary to handle the IOException thrown by ClassUtil.closeOnFailAndThrowAsIOE
            fail("IOException should not occur.");
        }
    }

}