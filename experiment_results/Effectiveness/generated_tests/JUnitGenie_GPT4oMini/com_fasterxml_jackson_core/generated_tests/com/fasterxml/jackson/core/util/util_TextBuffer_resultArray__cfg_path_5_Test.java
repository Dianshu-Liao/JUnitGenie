package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import java.lang.reflect.Method;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_resultArray__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testResultArrayWithValidInput() {
        try {
            // Arrange
            BufferRecycler bufferRecycler = new BufferRecycler();
            TextBuffer textBuffer = new TextBuffer(bufferRecycler);
            // Set the private fields using reflection
            setPrivateField(textBuffer, "_resultString", "test");
            setPrivateField(textBuffer, "_inputStart", 0);
            setPrivateField(textBuffer, "_inputLen", 4);
            setPrivateField(textBuffer, "_inputBuffer", "test".toCharArray());

            // Act
            Method method = TextBuffer.class.getDeclaredMethod("resultArray");
            method.setAccessible(true);
            char[] result = (char[]) method.invoke(textBuffer);

            // Assert
            assertArrayEquals("Expected result array does not match", "test".toCharArray(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPrivateField(TextBuffer textBuffer, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = TextBuffer.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(textBuffer, value);
    }

}