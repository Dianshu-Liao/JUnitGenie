package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import java.math.BigDecimal;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_TextBuffer_contentsAsDecimal_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testContentsAsDecimal_withValidInput() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        try {
            textBuffer.append("123.45".toCharArray(), 0, 6); // Using append method to set up the content
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
        boolean useFastParser = true;

        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(useFastParser);

        // Assert
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test(timeout = 4000)
    public void testContentsAsDecimal_withInputStart() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        try {
            textBuffer.append("678.90".toCharArray(), 0, 6); // Using append method to set the input
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
        boolean useFastParser = true;

        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(useFastParser);

        // Assert
        assertEquals(new BigDecimal("678.90"), result);
    }

    @Test(timeout = 4000)
    public void testContentsAsDecimal_withNoSegments() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        try {
            textBuffer.append("456.78".toCharArray(), 0, 6); // Using append method to set the current segment
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
        boolean useFastParser = true;

        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(useFastParser);

        // Assert
        assertEquals(new BigDecimal("456.78"), result);
    }

    @Test(timeout = 4000)
    public void testContentsAsDecimal_withIOException() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        boolean useFastParser = true;

        // Act
        try {
            textBuffer.contentsAsDecimal(useFastParser);
            fail("Expected NumberFormatException to be thrown");
        } catch (NumberFormatException e) {
            // Assert
            assertNotNull(e.getMessage());
        }
    }


}