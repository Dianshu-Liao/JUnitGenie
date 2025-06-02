package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_TextBuffer_emptyAndGetCurrentSegment__cfg_path_3_Test {


    private void setPrivateField(TextBuffer textBuffer, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = TextBuffer.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(textBuffer, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }

}
