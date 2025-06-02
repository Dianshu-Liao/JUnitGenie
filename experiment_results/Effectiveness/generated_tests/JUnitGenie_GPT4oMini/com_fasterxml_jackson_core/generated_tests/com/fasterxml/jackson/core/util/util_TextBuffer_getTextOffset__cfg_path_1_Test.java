package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_getTextOffset__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetTextOffset_NonNegativeInputStart() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        
        // Accessing the private field _inputStart using reflection
        try {
            java.lang.reflect.Field field = TextBuffer.class.getDeclaredField("_inputStart");
            field.setAccessible(true);
            field.setInt(textBuffer, 5); // Set _inputStart to a non-negative value

            // Act
            int result = textBuffer.getTextOffset();

            // Assert
            assertEquals(5, result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetTextOffset_NegativeInputStart() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        
        // Accessing the private field _inputStart using reflection
        try {
            java.lang.reflect.Field field = TextBuffer.class.getDeclaredField("_inputStart");
            field.setAccessible(true);
            field.setInt(textBuffer, -1); // Set _inputStart to a negative value

            // Act
            int result = textBuffer.getTextOffset();

            // Assert
            assertEquals(0, result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}