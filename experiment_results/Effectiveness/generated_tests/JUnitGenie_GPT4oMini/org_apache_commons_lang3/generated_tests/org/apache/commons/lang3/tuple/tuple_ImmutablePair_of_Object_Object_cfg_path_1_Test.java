package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class tuple_ImmutablePair_of_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testOf_withNonNullLeftAndRight() {
        ImmutablePair<String, Integer> pair = ImmutablePair.of("left", 1);
        assertNotNull(pair);
    }

    @Test(timeout = 4000)
    public void testOf_withNullLeftAndNonNullRight() {
        ImmutablePair<String, Integer> pair = ImmutablePair.of(null, 1);
        assertNotNull(pair);
    }

    @Test(timeout = 4000)
    public void testOf_withNonNullLeftAndNullRight() {
        ImmutablePair<String, Integer> pair = ImmutablePair.of("left", null);
        assertNotNull(pair);
    }

    @Test(timeout = 4000)
    public void testOf_withBothNull() {
        ImmutablePair<String, Integer> pair = ImmutablePair.of(null, null);
        assertNull(pair);
    }

}