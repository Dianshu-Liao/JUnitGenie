package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_size__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSizeWhenInputStartIsNegative() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler()); // Use BufferRecycler
        // Setting _inputStart to -1 to test this condition
        setPrivateField(textBuffer, "_inputStart", -1);
        
        // Act
        int size = textBuffer.size();
        
        // Assert
        assertEquals(0, size); // Expecting _segmentSize + _currentSize which are default initialized to 0
    }

    @Test(timeout = 4000)
    public void testSizeWhenResultArrayIsNull() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler()); // Use BufferRecycler
        // Setting _inputStart to 0 to test the first condition
        setPrivateField(textBuffer, "_inputStart", 0);
        setPrivateField(textBuffer, "_resultArray", null);
        
        // Act
        int size = textBuffer.size();
        
        // Assert
        assertEquals(0, size); // Expecting _segmentSize + _currentSize which are default initialized to 0
    }

    @Test(timeout = 4000)
    public void testSizeWhenResultArrayIsNotNull() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler()); // Use BufferRecycler
        // Setting _inputStart to 0 to test the first condition
        setPrivateField(textBuffer, "_inputStart", 0);
        char[] resultArray = new char[5]; // Let's assume we have a char array of length 5
        setPrivateField(textBuffer, "_resultArray", resultArray);
        
        // Act
        int size = textBuffer.size();
        
        // Assert
        assertEquals(5, size); // Expecting the length of resultArray
    }

    @Test(timeout = 4000)
    public void testSizeWhenResultStringIsNotNull() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler()); // Use BufferRecycler
        // Setting _inputStart to 0 to test the first condition
        setPrivateField(textBuffer, "_inputStart", 0);
        // Setting a result string
        setPrivateField(textBuffer, "_resultString", "testString");
        
        // Act
        int size = textBuffer.size();
        
        // Assert
        assertEquals(10, size); // Expecting the length of resultString
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace(); // Handle or throw it according to your needs
        }
    }


}