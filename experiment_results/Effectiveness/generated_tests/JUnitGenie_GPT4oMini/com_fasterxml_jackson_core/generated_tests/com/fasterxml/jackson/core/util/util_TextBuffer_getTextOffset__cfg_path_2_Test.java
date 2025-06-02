package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_getTextOffset__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetTextOffset_NegativeInputStart() {
        // Create an instance of TextBuffer with a BufferRecycler
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        
        // Use reflection to set the private field _inputStart to a negative value
        try {
            java.lang.reflect.Field field = TextBuffer.class.getDeclaredField("_inputStart");
            field.setAccessible(true);
            field.setInt(textBuffer, -1); // Set _inputStart to -1
            
            // Call the method under test
            int result = textBuffer.getTextOffset();
            
            // Assert the expected result
            assertEquals(0, result); // Since _inputStart is negative, the return value should be 0
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetTextOffset_ZeroInputStart() {
        // Create an instance of TextBuffer with a BufferRecycler
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        
        // Use reflection to set the private field _inputStart to 0
        try {
            java.lang.reflect.Field field = TextBuffer.class.getDeclaredField("_inputStart");
            field.setAccessible(true);
            field.setInt(textBuffer, 0); // Set _inputStart to 0
            
            // Call the method under test
            int result = textBuffer.getTextOffset();
            
            // Assert the expected result
            assertEquals(0, result); // Since _inputStart is 0, the return value should be 0
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetTextOffset_PositiveInputStart() {
        // Create an instance of TextBuffer with a BufferRecycler
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        
        // Use reflection to set the private field _inputStart to a positive value
        try {
            java.lang.reflect.Field field = TextBuffer.class.getDeclaredField("_inputStart");
            field.setAccessible(true);
            field.setInt(textBuffer, 5); // Set _inputStart to 5
            
            // Call the method under test
            int result = textBuffer.getTextOffset();
            
            // Assert the expected result
            assertEquals(5, result); // Since _inputStart is positive, the return value should be 5
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}