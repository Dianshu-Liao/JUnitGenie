package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_emptyAndGetCurrentSegment__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEmptyAndGetCurrentSegment() {
        // Create an instance of TextBuffer
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler());

        // Call the method under test
        char[] result = textBuffer.emptyAndGetCurrentSegment();

        // Verify the result
        assertArrayEquals(new char[0], result);
    }

}