package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.Test;
import java.lang.reflect.Method;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class util_TextBuffer_resultArray__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testResultArrayWhenResultStringIsNotNull() throws Exception {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        // Using reflection to set the private field _resultString
        Method setResultStringMethod = TextBuffer.class.getDeclaredMethod("setResult", String.class);
        setResultStringMethod.setAccessible(true);
        setResultStringMethod.invoke(textBuffer, "test");

        // Act
        char[] result = invokeResultArray(textBuffer);

        // Assert
        assertArrayEquals(new char[] {'t', 'e', 's', 't'}, result);
    }

    private char[] invokeResultArray(TextBuffer textBuffer) throws Exception {
        Method resultArrayMethod = TextBuffer.class.getDeclaredMethod("resultArray");
        resultArrayMethod.setAccessible(true);
        return (char[]) resultArrayMethod.invoke(textBuffer);
    }


}