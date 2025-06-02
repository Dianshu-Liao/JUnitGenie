package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BooleanUtils_toIntegerObject_Boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToIntegerObjectWithFalse() {
        Boolean input = Boolean.FALSE;
        try {
            Integer result = BooleanUtils.toIntegerObject(input);
            assertEquals(NumberUtils.INTEGER_ZERO, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testToIntegerObjectWithTrue() {
        Boolean input = Boolean.TRUE;
        try {
            Integer result = BooleanUtils.toIntegerObject(input);
            assertEquals(NumberUtils.INTEGER_ONE, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testToIntegerObjectWithNull() {
        Boolean input = null;
        try {
            Integer result = BooleanUtils.toIntegerObject(input);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}