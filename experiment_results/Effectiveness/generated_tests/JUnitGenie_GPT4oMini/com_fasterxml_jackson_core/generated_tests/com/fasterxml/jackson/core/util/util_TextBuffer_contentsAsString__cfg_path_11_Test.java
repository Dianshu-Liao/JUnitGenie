package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class util_TextBuffer_contentsAsString__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testContentsAsStringWithResultArray() throws IOException {
        // Arrange
        char[] resultArray = {'H', 'e', 'l', 'l', 'o'};
        TextBuffer textBuffer = new TextBuffer(null, resultArray);
        
        // Act
        String result = textBuffer.contentsAsString();
        
        // Assert
        assertEquals("Hello", result);
    }

    @Test(timeout = 4000)
    public void testContentsAsStringWithNullResultArray() throws IOException {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(null);
        
        // Act
        String result = textBuffer.contentsAsString();
        
        // Assert
        assertEquals("", result);
    }


}