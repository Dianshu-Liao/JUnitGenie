package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import java.lang.reflect.Method;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_resultArray__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testResultArray() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        
        // Set up the private fields using reflection
        try {
            // Set _inputLen to a value >= 1
            setPrivateField(textBuffer, "_inputLen", 5);
            // Set _inputStart to a valid value
            setPrivateField(textBuffer, "_inputStart", 0);
            // Set _inputBuffer to a valid char array
            setPrivateField(textBuffer, "_inputBuffer", new char[] {'a', 'b', 'c', 'd', 'e'});
            // Set _resultString to null to follow the CFG path
            setPrivateField(textBuffer, "_resultString", null);
            
            // Act
            Method resultArrayMethod = TextBuffer.class.getDeclaredMethod("resultArray");
            resultArrayMethod.setAccessible(true);
            char[] result = (char[]) resultArrayMethod.invoke(textBuffer);
            
            // Assert
            assertArrayEquals(new char[] {'a', 'b', 'c', 'd', 'e'}, result);
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