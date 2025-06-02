package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_size__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSizeWhenInputStartIsNegative() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler()); // Use BufferRecycler
        // Using reflection to set private fields
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.setInt(textBuffer, -1); // Set _inputStart to -1

            java.lang.reflect.Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
            resultArrayField.setAccessible(true);
            resultArrayField.set(textBuffer, null); // Set _resultArray to null

            java.lang.reflect.Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
            resultStringField.setAccessible(true);
            resultStringField.set(textBuffer, null); // Set _resultString to null

            java.lang.reflect.Field segmentSizeField = TextBuffer.class.getDeclaredField("_segmentSize");
            segmentSizeField.setAccessible(true);
            segmentSizeField.setInt(textBuffer, 5); // Set _segmentSize to 5

            java.lang.reflect.Field currentSizeField = TextBuffer.class.getDeclaredField("_currentSize");
            currentSizeField.setAccessible(true);
            currentSizeField.setInt(textBuffer, 10); // Set _currentSize to 10

            // Act
            int size = textBuffer.size();

            // Assert
            assertEquals(15, size); // _segmentSize + _currentSize = 5 + 10
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSizeWhenResultArrayIsNotNull() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler()); // Use BufferRecycler
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.setInt(textBuffer, -1); // Set _inputStart to -1

            java.lang.reflect.Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
            resultArrayField.setAccessible(true);
            resultArrayField.set(textBuffer, new char[10]); // Set _resultArray to a char array of length 10

            // Act
            int size = textBuffer.size();

            // Assert
            assertEquals(10, size); // Should return length of _resultArray
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSizeWhenResultStringIsNotNull() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler()); // Use BufferRecycler
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.setInt(textBuffer, -1); // Set _inputStart to -1

            java.lang.reflect.Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
            resultArrayField.setAccessible(true);
            resultArrayField.set(textBuffer, null); // Set _resultArray to null

            java.lang.reflect.Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
            resultStringField.setAccessible(true);
            resultStringField.set(textBuffer, "Hello"); // Set _resultString to "Hello"

            // Act
            int size = textBuffer.size();

            // Assert
            assertEquals(5, size); // Should return length of _resultString
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}