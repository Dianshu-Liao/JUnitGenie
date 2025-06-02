package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import com.fasterxml.jackson.core.util.BufferRecycler;

public class util_TextBuffer_contentsAsDecimal_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContentsAsDecimal_WithValidString() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        // Using reflection to set the private variable _resultString
        setPrivateField(textBuffer, "_resultString", "123.45");
        boolean useFastParser = true;

        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(useFastParser);

        // Assert
        assertEquals(new BigDecimal("123.45"), result);
    }

    private void setPrivateField(TextBuffer textBuffer, String fieldName, String value) {
        try {
            java.lang.reflect.Field field = TextBuffer.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(textBuffer, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}