package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_select_Iterable_Predicate_cfg_path_2_Test {

    private static class TestPredicate implements Predicate<Object> {
        @Override
        public boolean evaluate(Object object) {
            return object != null; // Example condition: filter out nulls
        }

        @Override
        public boolean test(Object object) {
            return evaluate(object);
        }
    }

    @Test(timeout = 4000)
    public void testSelectWithNonEmptyCollection() {
        List<Object> inputCollection = new ArrayList<>();
        inputCollection.add("test");
        inputCollection.add(null);
        inputCollection.add(123);

        Predicate<Object> predicate = new TestPredicate();
        Collection<Object> result = CollectionUtils.select(inputCollection, predicate);

        // Expecting only the non-null elements
        Collection<Object> expected = new ArrayList<>();
        expected.add("test");
        expected.add(123);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSelectWithEmptyCollection() {
        List<Object> inputCollection = new ArrayList<>();

        Predicate<Object> predicate = new TestPredicate();
        Collection<Object> result = CollectionUtils.select(inputCollection, predicate);

        // Expecting an empty collection
        assertEquals(new ArrayList<>(), result);
    }

    @Test(timeout = 4000)
    public void testSelectWithNullInputCollection() {
        Predicate<Object> predicate = new TestPredicate();
        Collection<Object> result = CollectionUtils.select(null, predicate);

        // Expecting an empty collection
        assertEquals(new ArrayList<>(), result);
    }

}