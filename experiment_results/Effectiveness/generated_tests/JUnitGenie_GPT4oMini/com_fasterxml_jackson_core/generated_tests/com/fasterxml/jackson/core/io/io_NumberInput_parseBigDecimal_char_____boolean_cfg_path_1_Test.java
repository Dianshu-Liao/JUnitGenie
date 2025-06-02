package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import org.junit.Test;
import com.fasterxml.jackson.core.io.NumberInput;

public class io_NumberInput_parseBigDecimal_char_____boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testParseBigDecimalWithFastParser() {
        char[] inputChars = {'1', '2', '3'};
        boolean useFastParser = true;

        try {
            BigDecimal result = NumberInput.parseBigDecimal(inputChars, useFastParser);
            assertNotNull(result);
            assertTrue(result.compareTo(new BigDecimal("123")) == 0);
        } catch (NumberFormatException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParseBigDecimalWithoutFastParser() {
        char[] inputChars = {'4', '5', '6'};
        boolean useFastParser = false;

        try {
            BigDecimal result = NumberInput.parseBigDecimal(inputChars, useFastParser);
            assertNotNull(result);
            assertTrue(result.compareTo(new BigDecimal("456")) == 0);
        } catch (NumberFormatException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testParseBigDecimalWithEmptyArray() {
        char[] inputChars = {};
        boolean useFastParser = true;

        try {
            NumberInput.parseBigDecimal(inputChars, useFastParser);
        } catch (NumberFormatException e) {
            // Handle the exception if thrown
            e.printStackTrace();
            throw e; // Rethrow to satisfy the expected exception
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testParseBigDecimalWithNullArray() {
        char[] inputChars = null;
        boolean useFastParser = true;

        try {
            NumberInput.parseBigDecimal(inputChars, useFastParser);
        } catch (NumberFormatException e) {
            // Handle the exception if thrown
            e.printStackTrace();
            throw e; // Rethrow to satisfy the expected exception
        }
    }

}