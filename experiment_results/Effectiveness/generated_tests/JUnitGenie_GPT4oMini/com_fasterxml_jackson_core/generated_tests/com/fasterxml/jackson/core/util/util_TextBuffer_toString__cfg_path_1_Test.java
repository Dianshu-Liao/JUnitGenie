package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_TextBuffer_toString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToString_ExceptionHandling() {
        // Create an instance of TextBuffer with a BufferRecycler
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);

        // Set the _resultString field to null to trigger the exception
        try {
            // Use reflection to set the private field _resultString to null
            java.lang.reflect.Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
            resultStringField.setAccessible(true);
            resultStringField.set(textBuffer, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Call the toString method and verify the output
        String result = textBuffer.toString();
        assertEquals("TextBuffer: Exception when reading contents", result);
    }

}