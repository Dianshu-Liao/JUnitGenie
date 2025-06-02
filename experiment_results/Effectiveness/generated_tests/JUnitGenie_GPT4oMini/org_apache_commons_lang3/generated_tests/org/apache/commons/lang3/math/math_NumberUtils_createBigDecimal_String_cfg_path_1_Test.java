package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertNull;

public class math_NumberUtils_createBigDecimal_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateBigDecimalWithBlankString() {
        try {
            BigDecimal result = NumberUtils.createBigDecimal("   "); // whitespace string
        } catch (NumberFormatException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testCreateBigDecimalWithNull() {
        BigDecimal result = NumberUtils.createBigDecimal(null);
        assertNull(result); // Expecting null for null input
    }

}