package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_size__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSizeWhenInputStartIsNonNegative() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler

        // Using reflection to set private fields
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.setInt(textBuffer, 0); // Set _inputStart to 0

            java.lang.reflect.Field inputLenField = TextBuffer.class.getDeclaredField("_inputLen");
            inputLenField.setAccessible(true);
            inputLenField.setInt(textBuffer, 10); // Set _inputLen to 10

            // Act
            int size = textBuffer.size();

            // Assert
            assertEquals(10, size);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}