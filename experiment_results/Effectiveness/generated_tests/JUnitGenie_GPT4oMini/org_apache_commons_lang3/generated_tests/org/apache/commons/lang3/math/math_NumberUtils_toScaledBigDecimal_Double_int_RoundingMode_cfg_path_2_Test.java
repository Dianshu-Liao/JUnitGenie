package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_toScaledBigDecimal_Double_int_RoundingMode_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToScaledBigDecimal_NullValue() {
        // Arrange
        Double value = null;
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_UP;

        // Act
        BigDecimal result = NumberUtils.toScaledBigDecimal(value, scale, roundingMode);

        // Assert
        assertEquals(BigDecimal.ZERO, result);
    }

}