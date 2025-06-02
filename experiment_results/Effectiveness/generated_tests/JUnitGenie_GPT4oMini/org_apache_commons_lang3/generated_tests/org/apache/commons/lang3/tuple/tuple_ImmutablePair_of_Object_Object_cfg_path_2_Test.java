package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class tuple_ImmutablePair_of_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testOf_WithNullLeftAndNullRight() {
        // Test case where both left and right are null
        ImmutablePair<Object, Object> result = ImmutablePair.of(null, null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testOf_WithNonNullLeftAndNullRight() {
        // Test case where left is non-null and right is null
        ImmutablePair<Object, Object> result = ImmutablePair.of("left", null);
        assertNotNull(result);
        assertNotNull(result.getLeft());
        assertNull(result.getRight());
    }

    @Test(timeout = 4000)
    public void testOf_WithNullLeftAndNonNullRight() {
        // Test case where left is null and right is non-null
        ImmutablePair<Object, Object> result = ImmutablePair.of(null, "right");
        assertNotNull(result);
        assertNull(result.getLeft());
        assertNotNull(result.getRight());
    }

    @Test(timeout = 4000)
    public void testOf_WithNonNullLeftAndNonNullRight() {
        // Test case where both left and right are non-null
        ImmutablePair<Object, Object> result = ImmutablePair.of("left", "right");
        assertNotNull(result);
        assertNotNull(result.getLeft());
        assertNotNull(result.getRight());
    }

}