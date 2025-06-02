package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_contentsAsString__cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testContentsAsString() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler

        // Using reflection to set private fields
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.setInt(textBuffer, 0); // Set _inputStart to 0

            java.lang.reflect.Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
            resultArrayField.setAccessible(true);
            resultArrayField.set(textBuffer, null); // Set _resultArray to null

            java.lang.reflect.Field segmentSizeField = TextBuffer.class.getDeclaredField("_segmentSize");
            segmentSizeField.setAccessible(true);
            segmentSizeField.setInt(textBuffer, 0); // Set _segmentSize to 0

            java.lang.reflect.Field currentSizeField = TextBuffer.class.getDeclaredField("_currentSize");
            currentSizeField.setAccessible(true);
            currentSizeField.setInt(textBuffer, 0); // Set _currentSize to 0

            // Act
            String result = textBuffer.contentsAsString();

            // Assert
            assertEquals("", result); // Expecting an empty string as a result
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }


}