package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_select_Iterable_Predicate_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSelectWithEmptyIterable() {
        Iterable<String> inputCollection = new ArrayList<>();
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return false; // always returns false for empty collection
            }

            @Override
            public boolean test(String object) {
                return false;
            }
        };

        Collection<String> result = CollectionUtils.select(inputCollection, predicate);
        assertEquals("Expected an empty collection", 0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectWithNonEmptyIterable() {
        List<String> inputCollection = new ArrayList<>();
        inputCollection.add("apple");
        inputCollection.add("banana");
        inputCollection.add("cherry");

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.startsWith("b"); // only select items starting with 'b'
            }

            @Override
            public boolean test(String object) {
                return object.startsWith("b");
            }
        };

        Collection<String> result = CollectionUtils.select(inputCollection, predicate);
        assertEquals("Expected one item in the collection", 1, result.size());
    }

}