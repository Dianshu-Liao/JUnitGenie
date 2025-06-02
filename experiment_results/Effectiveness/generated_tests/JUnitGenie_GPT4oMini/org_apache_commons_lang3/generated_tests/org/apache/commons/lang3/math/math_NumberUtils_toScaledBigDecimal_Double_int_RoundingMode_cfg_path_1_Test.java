package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_toScaledBigDecimal_Double_int_RoundingMode_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToScaledBigDecimal_ValidInput() {
        Double value = 123.456;
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_UP;

        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);
        BigDecimal expected = new BigDecimal("123.46");
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToScaledBigDecimal_NullValue() {
        Double value = null;
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_UP;

        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);
        BigDecimal expected = BigDecimal.ZERO;

        assertEquals(expected, result);
    }

}