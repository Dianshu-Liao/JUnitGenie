package org.apache.commons.lang3;
import org.apache.commons.lang3.CachedRandomBits;
import org.junit.Test;

public class CachedRandomBits_nextBits_int_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testNextBits_ThrowsIllegalArgumentException_WhenBitsGreaterThan32() {
        CachedRandomBits cachedRandomBits = new CachedRandomBits(10, new java.util.Random());
        cachedRandomBits.nextBits(33);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextBits_ThrowsIllegalArgumentException_WhenBitsLessThanOrEqualToZero() {
        CachedRandomBits cachedRandomBits = new CachedRandomBits(10, new java.util.Random());
        cachedRandomBits.nextBits(0);
    }

}