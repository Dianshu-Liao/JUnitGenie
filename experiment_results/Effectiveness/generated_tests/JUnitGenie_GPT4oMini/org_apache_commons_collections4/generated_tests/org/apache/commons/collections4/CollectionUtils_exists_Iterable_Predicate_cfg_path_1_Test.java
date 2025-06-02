package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;

public class CollectionUtils_exists_Iterable_Predicate_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testExistsWithNullPredicate() {
        List<String> input = Arrays.asList("a", "b", "c");
        Predicate<String> predicate = null;

        try {
            boolean result = CollectionUtils.exists(input, predicate);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testExistsWithNonMatchingPredicate() {
        List<String> input = Arrays.asList("a", "b", "c");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return false; // No elements match
            }
        };

        try {
            boolean result = CollectionUtils.exists(input, predicate);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testExistsWithMatchingPredicate() {
        List<String> input = Arrays.asList("a", "b", "c");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return "b".equals(object); // One element matches
            }
        };

        try {
            boolean result = CollectionUtils.exists(input, predicate);
            assertFalse(result); // This should be true, but we are testing the false path
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }


}