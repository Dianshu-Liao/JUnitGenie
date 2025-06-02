package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import java.lang.reflect.Method;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_resultArray__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testResultArrayWithNullResultString() throws Exception {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(null);
        setPrivateField(textBuffer, "_inputStart", 0);
        setPrivateField(textBuffer, "_inputLen", 5);
        setPrivateField(textBuffer, "_inputBuffer", new char[]{'a', 'b', 'c', 'd', 'e'});

        // Act
        char[] result = invokePrivateMethod(textBuffer, "resultArray");

        // Assert
        assertArrayEquals(TextBuffer.NO_CHARS, result);
    }

    private void setPrivateField(TextBuffer textBuffer, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = TextBuffer.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(textBuffer, value);
    }

    private char[] invokePrivateMethod(TextBuffer textBuffer, String methodName) throws Exception {
        Method method = TextBuffer.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (char[]) method.invoke(textBuffer);
    }

}