package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CollectionUtils_exists_Iterable_Predicate_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testExistsWithNullPredicate() {
        Iterable<String> input = java.util.Arrays.asList("a", "b", "c");
        Predicate<String> predicate = null;

        try {
            boolean result = CollectionUtils.exists(input, predicate);
            assertTrue(result == false); // Since predicate is null, it should return false
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExistsWithNonNullPredicate() {
        Iterable<String> input = java.util.Arrays.asList("a", "b", "c");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) { // Change Object to String
                return "b".equals(object);
            }
        };

        try {
            boolean result = CollectionUtils.exists(input, predicate);
            assertTrue(result); // Since "b" exists in the input, it should return true
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}