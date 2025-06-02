package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CollectionUtils_exists_Iterable_Predicate_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testExistsWithNonNullPredicate() {
        Iterable<Integer> input = java.util.Arrays.asList(1, 2, 3, 4, 5);
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 3; // Predicate to check if the number is greater than 3
            }
        };

        boolean result = CollectionUtils.exists(input, predicate);
        assertTrue(result); // Expecting true since there are numbers greater than 3
    }

    @Test(timeout = 4000)
    public void testExistsWithNullPredicate() {
        Iterable<Integer> input = java.util.Arrays.asList(1, 2, 3, 4, 5);
        Predicate<Integer> predicate = null;

        boolean result = CollectionUtils.exists(input, predicate);
        assertFalse(result); // Expecting false since predicate is null
    }

    @Test(timeout = 4000)
    public void testExistsWithEmptyIterable() {
        Iterable<Integer> input = java.util.Collections.emptyList();
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 3; // Predicate to check if the number is greater than 3
            }
        };

        boolean result = CollectionUtils.exists(input, predicate);
        assertFalse(result); // Expecting false since the input is empty
    }


}