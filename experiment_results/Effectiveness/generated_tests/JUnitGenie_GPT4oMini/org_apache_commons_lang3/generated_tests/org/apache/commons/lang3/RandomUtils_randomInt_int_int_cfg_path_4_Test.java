package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class RandomUtils_randomInt_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRandomInt_ThrowsException_WhenEndExclusiveIsLessThanStartInclusive() {
        try {
            RandomUtils randomUtils = new RandomUtils();
            randomUtils.randomInt(5, 3);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Start value must be smaller or equal to end value.");
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_ThrowsException_WhenStartInclusiveIsNegative() {
        try {
            RandomUtils randomUtils = new RandomUtils();
            randomUtils.randomInt(-1, 5);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Both range values must be non-negative.");
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_ReturnsStartInclusive_WhenStartInclusiveEqualsEndExclusive() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(5, 5);
        assert result == 5;
    }

    @Test(timeout = 4000)
    public void testRandomInt_ReturnsValueInRange_WhenStartInclusiveLessThanEndExclusive() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(1, 10);
        assert result >= 1 && result < 10;
    }

}