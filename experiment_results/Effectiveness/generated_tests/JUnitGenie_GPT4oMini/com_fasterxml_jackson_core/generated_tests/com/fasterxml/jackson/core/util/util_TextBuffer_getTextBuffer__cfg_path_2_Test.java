package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.io.IOException;

public class util_TextBuffer_getTextBuffer__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetTextBufferWhenInputStartIsNegative() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler

        // Set _inputStart to a negative value using reflection
        java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
        inputStartField.setAccessible(true);
        inputStartField.setInt(textBuffer, -1);

        // Act
        char[] result = textBuffer.getTextBuffer();

        // Assert
        // Since _resultArray is null, we expect the method to return null
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetTextBufferWhenResultArrayIsNotNull() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler

        // Set _resultArray to a non-null value using reflection
        java.lang.reflect.Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
        resultArrayField.setAccessible(true);
        char[] expectedArray = {'a', 'b', 'c'};
        resultArrayField.set(textBuffer, expectedArray);

        // Act
        char[] result = textBuffer.getTextBuffer();

        // Assert
        assertArrayEquals(expectedArray, result);
    }


}