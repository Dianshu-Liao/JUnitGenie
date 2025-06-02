package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_select_Iterable_Predicate_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSelectWithEmptyInputCollection() {
        Iterable<String> inputCollection = new ArrayList<>();
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return false; // No elements should be selected
            }
        };

        Collection<String> result = CollectionUtils.select(inputCollection, predicate);
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectWithNonEmptyInputCollection() {
        List<String> inputCollection = new ArrayList<>();
        inputCollection.add("apple");
        inputCollection.add("banana");
        inputCollection.add("cherry");

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.equals("banana"); // Only "banana" should be selected
            }
        };

        Collection<String> result = CollectionUtils.select(inputCollection, predicate);
        assertEquals(1, result.size());
        assertEquals(true, result.contains("banana"));
    }

}