package com.fasterxml.jackson.core.util;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;

public class util_TextBuffer_contentsAsDecimal_boolean_cfg_path_2_Test {

    private TextBuffer textBuffer;

    @Before
    public void setUp() {
        // Initialize the TextBuffer with a BufferRecycler
        textBuffer = new TextBuffer(new BufferRecycler());
        // Set up the private fields for testing
        // Using reflection to access private fields
        try {
            java.lang.reflect.Field inputBufferField = TextBuffer.class.getDeclaredField("_inputBuffer");
            inputBufferField.setAccessible(true);
            inputBufferField.set(textBuffer, new char[] {'1', '2', '3'}); // Example input

            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.set(textBuffer, 0); // Example start index

            java.lang.reflect.Field inputLenField = TextBuffer.class.getDeclaredField("_inputLen");
            inputLenField.setAccessible(true);
            inputLenField.set(textBuffer, 3); // Example length

            java.lang.reflect.Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
            resultStringField.setAccessible(true);
            resultStringField.set(textBuffer, null); // Set to null to follow the CFG path

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContentsAsDecimalWithFastParser() {
        try {
            BigDecimal result = textBuffer.contentsAsDecimal(true);
            assertNotNull(result);
            assertEquals(new BigDecimal("123"), result);
        } catch (NumberFormatException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContentsAsDecimalWithSlowParser() {
        // Set _resultString to null and _inputStart to a negative value to follow the CFG path
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.set(textBuffer, -1); // Set to negative to follow the CFG path

            BigDecimal result = textBuffer.contentsAsDecimal(false);
            assertNotNull(result);
            assertEquals(new BigDecimal("123"), result);
        } catch (NumberFormatException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}