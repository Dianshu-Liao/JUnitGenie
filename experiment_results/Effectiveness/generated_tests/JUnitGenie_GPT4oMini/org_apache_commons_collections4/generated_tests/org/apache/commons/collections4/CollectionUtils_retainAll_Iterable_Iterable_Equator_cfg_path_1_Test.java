package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_retainAll_Iterable_Iterable_Equator_cfg_path_1_Test {

    private static class TestEquator implements Equator<String> {
        @Override
        public boolean equate(String obj1, String obj2) {
            return obj1.equals(obj2);
        }

        @Override
        public int hash(String obj) {
            return obj.hashCode();
        }
    }

    @Test(timeout = 4000)
    public void testRetainAll() {
        List<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");

        List<String> retain = new ArrayList<>();
        retain.add("B");
        retain.add("D");

        Equator<String> equator = new TestEquator();

        try {
            Collection<String> result = CollectionUtils.retainAll(collection, retain, equator);
            List<String> expected = new ArrayList<>();
            expected.add("B");
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testRetainAllWithNullCollection() {
        List<String> retain = new ArrayList<>();
        retain.add("B");
        Equator<String> equator = new TestEquator();

        try {
            Collection<String> result = CollectionUtils.retainAll(null, retain, equator);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testRetainAllWithNullRetain() {
        List<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        Equator<String> equator = new TestEquator();

        try {
            Collection<String> result = CollectionUtils.retainAll(collection, null, equator);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testRetainAllWithNullEquator() {
        List<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        List<String> retain = new ArrayList<>();
        retain.add("B");

        try {
            Collection<String> result = CollectionUtils.retainAll(collection, retain, null);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}