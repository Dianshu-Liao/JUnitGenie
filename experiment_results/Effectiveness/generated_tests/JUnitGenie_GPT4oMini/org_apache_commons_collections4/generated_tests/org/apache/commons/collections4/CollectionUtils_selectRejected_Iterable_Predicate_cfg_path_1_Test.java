package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_selectRejected_Iterable_Predicate_cfg_path_1_Test {

    private static class TestPredicate implements Predicate<Object> {
        @Override
        public boolean evaluate(Object object) {
            return object != null; // Example condition
        }

        @Override
        public boolean test(Object object) {
            return evaluate(object);
        }
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithNonEmptyCollection() {
        List<Object> inputCollection = new ArrayList<>();
        inputCollection.add("test");
        inputCollection.add(null);
        Predicate<Object> predicate = new TestPredicate();

        Collection<Object> result = CollectionUtils.selectRejected(inputCollection, predicate);

        // Expecting the result to contain only the rejected elements (null in this case)
        assertEquals(1, result.size());
        assertEquals(null, result.iterator().next());
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithEmptyCollection() {
        List<Object> inputCollection = new ArrayList<>();
        Predicate<Object> predicate = new TestPredicate();

        Collection<Object> result = CollectionUtils.selectRejected(inputCollection, predicate);

        // Expecting an empty collection as input is empty
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithNullCollection() {
        Predicate<Object> predicate = new TestPredicate();

        Collection<Object> result = CollectionUtils.selectRejected(null, predicate);

        // Expecting an empty collection as input is null
        assertEquals(0, result.size());
    }

}