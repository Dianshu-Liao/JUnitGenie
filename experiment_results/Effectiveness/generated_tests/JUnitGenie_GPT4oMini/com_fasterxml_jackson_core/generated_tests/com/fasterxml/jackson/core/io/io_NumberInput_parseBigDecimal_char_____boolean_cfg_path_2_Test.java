package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import org.junit.Test;
import com.fasterxml.jackson.core.io.NumberInput;

public class io_NumberInput_parseBigDecimal_char_____boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testParseBigDecimalWithFastParser() {
        char[] input = "123.45".toCharArray();
        boolean useFastParser = true;

        try {
            BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
            assertNotNull(result);
            assertEquals(new BigDecimal("123.45"), result);
        } catch (NumberFormatException e) {
            fail("NumberFormatException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testParseBigDecimalWithoutFastParser() {
        char[] input = "678.90".toCharArray();
        boolean useFastParser = false;

        try {
            BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
            assertNotNull(result);
            assertEquals(new BigDecimal("678.90"), result);
        } catch (NumberFormatException e) {
            fail("NumberFormatException should not have been thrown");
        }
    }

}