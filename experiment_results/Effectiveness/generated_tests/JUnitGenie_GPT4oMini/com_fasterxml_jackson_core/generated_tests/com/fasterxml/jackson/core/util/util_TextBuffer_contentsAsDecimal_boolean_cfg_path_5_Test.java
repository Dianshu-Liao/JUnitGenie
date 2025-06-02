package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.io.NumberInput;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class util_TextBuffer_contentsAsDecimal_boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testContentsAsDecimal_withValidResultArray() {
        // Arrange
        char[] resultArray = {'1', '2', '3', '.', '4', '5'};
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler());
        // Using reflection to set private fields
        setPrivateField(textBuffer, "_resultArray", resultArray);
        setPrivateField(textBuffer, "_hasSegments", true);
        setPrivateField(textBuffer, "_resultString", null);
        setPrivateField(textBuffer, "_inputStart", -1);

        // Act
        BigDecimal result = null;
        try {
            result = textBuffer.contentsAsDecimal(true);
        } catch (NumberFormatException e) {
            // Handle exception if thrown
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testContentsAsDecimal_throwsNumberFormatException() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler());
        // Using reflection to set private fields
        setPrivateField(textBuffer, "_resultArray", null); // This will cause the exception
        setPrivateField(textBuffer, "_hasSegments", true);
        setPrivateField(textBuffer, "_resultString", null);
        setPrivateField(textBuffer, "_inputStart", -1);

        // Act
        try {
            textBuffer.contentsAsDecimal(true);
        } catch (NumberFormatException e) {
            // Assert
            assertNotNull(e.getMessage());
            return; // Test passes if exception is thrown
        }
        // If we reach here, the test failed
        fail("Expected NumberFormatException was not thrown.");
    }

    private void setPrivateField(TextBuffer textBuffer, String fieldName, Object value) {
        try {
            Field field = TextBuffer.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(textBuffer, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}