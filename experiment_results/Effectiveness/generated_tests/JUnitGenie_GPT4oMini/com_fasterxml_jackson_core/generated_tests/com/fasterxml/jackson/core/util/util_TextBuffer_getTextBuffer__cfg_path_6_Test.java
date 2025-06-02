package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Field;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_getTextBuffer__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetTextBufferWhenInputStartIsNegative() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(null);
        Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
        inputStartField.setAccessible(true);
        inputStartField.setInt(textBuffer, -1); // Set _inputStart to -1

        // Act
        char[] result = textBuffer.getTextBuffer();

        // Assert
        assertArrayEquals(new char[0], result); // Expecting an empty array since _resultArray is null
    }

    @Test(timeout = 4000)
    public void testGetTextBufferWhenResultArrayIsNull() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(null);
        Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
        inputStartField.setAccessible(true);
        inputStartField.setInt(textBuffer, 0); // Set _inputStart to 0

        Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
        resultArrayField.setAccessible(true);
        resultArrayField.set(textBuffer, null); // Set _resultArray to null

        Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
        resultStringField.setAccessible(true);
        resultStringField.set(textBuffer, "test"); // Set _resultString to "test" (String instead of char array)

        // Act
        char[] result = textBuffer.getTextBuffer();

        // Assert
        assertArrayEquals("test".toCharArray(), result); // Expecting the char array of "test"
    }

    @Test(timeout = 4000)
    public void testGetTextBufferWhenResultStringIsNull() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(null);
        Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
        inputStartField.setAccessible(true);
        inputStartField.setInt(textBuffer, 0); // Set _inputStart to 0

        Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
        resultArrayField.setAccessible(true);
        resultArrayField.set(textBuffer, null); // Set _resultArray to null

        Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
        resultStringField.setAccessible(true);
        resultStringField.set(textBuffer, null); // Set _resultString to null

        // Act
        char[] result = textBuffer.getTextBuffer();

        // Assert
        assertArrayEquals(new char[0], result); // Expecting an empty array since both _resultArray and _resultString are null
    }


}