package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.junit.Test;
import java.nio.ByteBuffer;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.assertEquals;

public class io_SerializedString_putUnquotedUTF8_ByteBuffer_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8() throws UnsupportedEncodingException { // Declare the exception
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        ByteBuffer buffer = ByteBuffer.allocate(10); // Allocate a buffer with enough space

        // Act
        int result = serializedString.putUnquotedUTF8(buffer);

        // Assert
        assertEquals(testValue.getBytes("UTF-8").length, result);
    }

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8BufferTooSmall() throws UnsupportedEncodingException { // Declare the exception
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        ByteBuffer buffer = ByteBuffer.allocate(3); // Allocate a buffer that is too small

        // Act
        int result = serializedString.putUnquotedUTF8(buffer);

        // Assert
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8NullBuffer() {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        ByteBuffer buffer = null; // Simulate a null buffer

        try {
            // Act
            serializedString.putUnquotedUTF8(buffer);
        } catch (Exception e) {
            // Assert
            assertEquals("java.lang.NullPointerException", e.getClass().getName());
        }
    }


}