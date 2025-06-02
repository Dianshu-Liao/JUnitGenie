package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class util_TextBuffer_contentsAsString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContentsAsString() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor that takes BufferRecycler

        // Set up the private fields using reflection
        try {
            java.lang.reflect.Field inputLenField = TextBuffer.class.getDeclaredField("_inputLen");
            inputLenField.setAccessible(true);
            inputLenField.setInt(textBuffer, 5); // Set _inputLen to 5 to match the length of the inputBuffer

            java.lang.reflect.Field inputBufferField = TextBuffer.class.getDeclaredField("_inputBuffer");
            inputBufferField.setAccessible(true);
            inputBufferField.set(textBuffer, new char[] {'H', 'e', 'l', 'l', 'o'}); // Set _inputBuffer

            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.setInt(textBuffer, 0); // Set _inputStart to 0

            // Act
            String result = textBuffer.contentsAsString(); // This line may throw IOException

            // Assert
            assertEquals("Hello", result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Exception occurred while setting up the test: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred while calling contentsAsString: " + e.getMessage());
        }
    }

}