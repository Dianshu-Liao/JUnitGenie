package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_selectRejected_Iterable_Predicate_cfg_path_3_Test {

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
    public void testSelectRejectedWithEmptyCollection() {
        Iterable<Object> inputCollection = new ArrayList<>();
        Predicate<Object> predicate = new TestPredicate();
        
        Collection<Object> result = CollectionUtils.selectRejected(inputCollection, predicate);
        
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithNullInputCollection() {
        Iterable<Object> inputCollection = null;
        Predicate<Object> predicate = new TestPredicate();
        
        Collection<Object> result = CollectionUtils.selectRejected(inputCollection, predicate);
        
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithNonEmptyCollection() {
        List<Object> inputCollection = new ArrayList<>();
        inputCollection.add(null);
        inputCollection.add("Test");
        Predicate<Object> predicate = new TestPredicate();
        
        Collection<Object> result = CollectionUtils.selectRejected(inputCollection, predicate);
        
        assertEquals(1, result.size());
        assertEquals(null, result.iterator().next());
    }

}