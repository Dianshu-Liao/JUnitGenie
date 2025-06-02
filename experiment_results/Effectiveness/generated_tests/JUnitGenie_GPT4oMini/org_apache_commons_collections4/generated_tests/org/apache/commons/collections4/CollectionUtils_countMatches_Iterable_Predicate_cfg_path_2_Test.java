package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_countMatches_Iterable_Predicate_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCountMatchesWithNonNullPredicate() {
        Iterable<String> input = java.util.Arrays.asList("apple", "banana", "cherry");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.startsWith("a");
            }
        };

        try {
            int result = CollectionUtils.countMatches(input, predicate);
            assertEquals(1, result); // Only "apple" starts with "a"
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCountMatchesWithNullPredicate() {
        Iterable<String> input = java.util.Arrays.asList("apple", "banana", "cherry");
        Predicate<String> predicate = null;

        try {
            int result = CollectionUtils.countMatches(input, predicate);
            assertEquals(0, result); // Should return 0 when predicate is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}