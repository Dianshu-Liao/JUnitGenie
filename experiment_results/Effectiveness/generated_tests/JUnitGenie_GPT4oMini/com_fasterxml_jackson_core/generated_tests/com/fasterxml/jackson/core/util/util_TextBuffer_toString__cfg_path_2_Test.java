package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_toString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToString() {
        BufferRecycler bufferRecycler = new BufferRecycler(); // Creating a BufferRecycler instance
        TextBuffer textBuffer = new TextBuffer(bufferRecycler); // Using the constructor with BufferRecycler

        // Assuming contentsAsString() returns a specific string for this test
        // Since we cannot control the internal state of TextBuffer directly,
        // we will need to mock or set up the conditions that lead to a specific output.
        // Here we will just test the exception handling part.

        // Simulating the IOException scenario
        try {
            String result = textBuffer.toString();
            assertEquals("TextBuffer: Exception when reading contents", result);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}