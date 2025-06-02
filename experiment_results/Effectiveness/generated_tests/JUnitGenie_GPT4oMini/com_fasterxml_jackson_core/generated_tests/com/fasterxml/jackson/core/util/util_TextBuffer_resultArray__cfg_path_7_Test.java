package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import java.lang.reflect.Method;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_resultArray__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testResultArray() {
        // Setup
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        
        // Set private fields using reflection
        try {
            // Set _inputStart to a valid value
            setPrivateField(textBuffer, "_inputStart", 0);
            // Set _currentSegment to a valid char array
            setPrivateField(textBuffer, "_currentSegment", new char[]{'a', 'b', 'c'});
            // Set _currentSize to the length of _currentSegment
            setPrivateField(textBuffer, "_currentSize", 3);
            // Set _segments to a valid ArrayList containing char arrays
            ArrayList<char[]> segments = new ArrayList<>();
            segments.add(new char[]{'d', 'e'});
            setPrivateField(textBuffer, "_segments", segments);
            // Set _resultString to null to follow the CFG path
            setPrivateField(textBuffer, "_resultString", null);

            // Execute the focal method using reflection
            Method resultArrayMethod = TextBuffer.class.getDeclaredMethod("resultArray");
            resultArrayMethod.setAccessible(true);
            char[] result = (char[]) resultArrayMethod.invoke(textBuffer);

            // Expected result
            char[] expected = new char[]{'d', 'e', 'a', 'b', 'c'};
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}