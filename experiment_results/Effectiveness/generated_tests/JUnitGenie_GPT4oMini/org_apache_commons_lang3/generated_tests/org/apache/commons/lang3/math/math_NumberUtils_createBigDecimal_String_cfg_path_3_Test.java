package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.math.BigDecimal;

public class math_NumberUtils_createBigDecimal_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCreateBigDecimalWithNull() {
        try {
            BigDecimal result = NumberUtils.createBigDecimal(null);
            assertNull(result);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}