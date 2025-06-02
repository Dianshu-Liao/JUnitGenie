package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_selectRejected_Iterable_Predicate_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSelectRejectedWithEmptyInputCollection() {
        Iterable<String> inputCollection = new ArrayList<>();
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return false; // Always reject
            }
        };

        Collection<String> result = CollectionUtils.selectRejected(inputCollection, predicate);
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithNonEmptyInputCollection() {
        List<String> inputCollection = new ArrayList<>();
        inputCollection.add("apple");
        inputCollection.add("banana");
        inputCollection.add("cherry");

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.equals("banana"); // Reject "banana"
            }
        };

        Collection<String> result = CollectionUtils.selectRejected(inputCollection, predicate);
        assertEquals(2, result.size());
        assertEquals(true, result.contains("apple"));
        assertEquals(true, result.contains("cherry"));
    }


}