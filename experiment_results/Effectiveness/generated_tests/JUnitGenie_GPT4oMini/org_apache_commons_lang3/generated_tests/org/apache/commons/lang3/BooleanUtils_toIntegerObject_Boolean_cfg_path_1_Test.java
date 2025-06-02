package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BooleanUtils_toIntegerObject_Boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToIntegerObjectTrue() {
        Boolean input = Boolean.TRUE;
        Integer expected = NumberUtils.INTEGER_ONE;
        Integer actual = BooleanUtils.toIntegerObject(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToIntegerObjectFalse() {
        Boolean input = Boolean.FALSE;
        Integer expected = NumberUtils.INTEGER_ZERO;
        Integer actual = BooleanUtils.toIntegerObject(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToIntegerObjectNull() {
        Boolean input = null;
        Integer expected = null;
        Integer actual = BooleanUtils.toIntegerObject(input);
        assertEquals(expected, actual);
    }

}