package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_getTextBuffer__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetTextBuffer() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(null);
        // Set the private fields using reflection
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.setInt(textBuffer, -1); // Set _inputStart to -1

            java.lang.reflect.Field hasSegmentsField = TextBuffer.class.getDeclaredField("_hasSegments");
            hasSegmentsField.setAccessible(true);
            hasSegmentsField.setBoolean(textBuffer, false); // Set _hasSegments to false

            java.lang.reflect.Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
            resultArrayField.setAccessible(true);
            resultArrayField.set(textBuffer, null); // Set _resultArray to null

            java.lang.reflect.Field currentSegmentField = TextBuffer.class.getDeclaredField("_currentSegment");
            currentSegmentField.setAccessible(true);
            currentSegmentField.set(textBuffer, null); // Set _currentSegment to null

            java.lang.reflect.Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
            resultStringField.setAccessible(true);
            resultStringField.set(textBuffer, null); // Set _resultString to null

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        char[] result = null;
        try {
            result = textBuffer.getTextBuffer();
        } catch (Exception e) { // Changed IOException to Exception to catch all exceptions
            e.printStackTrace();
        }

        // Assert
        assertArrayEquals(new char[0], result); // Expecting an empty char array since _currentSegment is null
    }


}