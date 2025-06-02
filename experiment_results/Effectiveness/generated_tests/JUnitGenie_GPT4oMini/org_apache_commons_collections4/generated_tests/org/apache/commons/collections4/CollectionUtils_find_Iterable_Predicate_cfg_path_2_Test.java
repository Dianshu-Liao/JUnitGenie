package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.*;

public class CollectionUtils_find_Iterable_Predicate_cfg_path_2_Test {

    private static class TestPredicate implements Predicate<String> {
        @Override
        public boolean evaluate(String input) {
            return input != null && input.contains("test");
        }

        @Override
        public boolean test(String input) {
            return evaluate(input);
        }
    }

    @Test(timeout = 4000)
    public void testFindWithValidPredicate() {
        Iterable<String> collection = java.util.Arrays.asList("test1", "sample", "test2");
        Predicate<String> predicate = new TestPredicate();
        
        // Call the focal method
        String result = CollectionUtils.find(collection, predicate);
        
        assertNotNull(result);
        assertEquals("test1", result);
    }

    @Test(timeout = 4000)
    public void testFindWithNullPredicate() {
        Iterable<String> collection = java.util.Arrays.asList("test1", "sample", "test2");
        Predicate<String> predicate = null;

        // Call the focal method
        String result = CollectionUtils.find(collection, predicate);
        
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testFindWithEmptyCollection() {
        Iterable<String> collection = java.util.Collections.emptyList();
        Predicate<String> predicate = new TestPredicate();
        
        // Call the focal method
        String result = CollectionUtils.find(collection, predicate);

        assertNull(result);
    }


}