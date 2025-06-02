package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.io.IOException;

public class util_TextBuffer_getTextBuffer__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetTextBuffer_InputStartNegative() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler

        // Using reflection to set the private field _inputStart
        java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
        inputStartField.setAccessible(true);
        inputStartField.setInt(textBuffer, -1);

        // Using reflection to set the private field _inputBuffer
        java.lang.reflect.Field inputBufferField = TextBuffer.class.getDeclaredField("_inputBuffer");
        inputBufferField.setAccessible(true);
        char[] expectedBuffer = {'a', 'b', 'c'};
        inputBufferField.set(textBuffer, expectedBuffer);

        // Act
        char[] result = textBuffer.getTextBuffer();

        // Assert
        assertArrayEquals(expectedBuffer, result);
    }

}