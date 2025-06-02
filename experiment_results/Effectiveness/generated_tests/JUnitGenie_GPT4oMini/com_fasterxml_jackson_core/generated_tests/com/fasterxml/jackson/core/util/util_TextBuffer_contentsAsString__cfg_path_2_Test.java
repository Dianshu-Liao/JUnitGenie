package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class util_TextBuffer_contentsAsString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContentsAsStringWithEmptyResultArray() throws IOException {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler
        textBuffer.resetWithEmpty(); // Reset the TextBuffer to an empty state

        // Act
        String result = textBuffer.contentsAsString();

        // Assert
        assertEquals("", result); // Expecting an empty string
    }

    @Test(timeout = 4000)
    public void testContentsAsStringWithValidInputLen() throws IOException {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler
        textBuffer.resetWithEmpty(); // Reset the TextBuffer to an empty state
        textBuffer.append("HelloWorld".toCharArray(), 0, 5); // Append valid input

        // Act
        String result = textBuffer.contentsAsString();

        // Assert
        assertEquals("Hello", result); // Expecting "Hello" as the result
    }

    @Test(timeout = 4000)
    public void testContentsAsStringWithNegativeInputStart() throws IOException {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler
        textBuffer.resetWithEmpty(); // Reset the TextBuffer to an empty state

        // Act
        String result = textBuffer.contentsAsString(); // Should handle negative input start gracefully

        // Assert
        assertEquals("", result); // Expecting an empty string
    }

    @Test(timeout = 4000)
    public void testContentsAsStringWithZeroInputLen() throws IOException {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Use the constructor with BufferRecycler
        textBuffer.resetWithEmpty(); // Reset the TextBuffer to an empty state

        // Act
        String result = textBuffer.contentsAsString(); // Should handle zero input length gracefully

        // Assert
        assertEquals("", result); // Expecting an empty string
    }


}