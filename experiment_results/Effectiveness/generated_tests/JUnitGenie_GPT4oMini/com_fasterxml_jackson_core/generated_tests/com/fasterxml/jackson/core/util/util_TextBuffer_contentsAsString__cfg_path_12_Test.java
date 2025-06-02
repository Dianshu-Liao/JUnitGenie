package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class util_TextBuffer_contentsAsString__cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testContentsAsStringWhenResultStringIsNull() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler());
        
        // Act
        String result = null;
        try {
            result = textBuffer.contentsAsString();
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }

        // Assert
        assertNotNull(result);
        assertEquals("", result); // Assuming _resultString is initialized to an empty string
    }


}