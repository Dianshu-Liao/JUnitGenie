package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Equator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_retainAll_Iterable_Iterable_Equator_cfg_path_3_Test {

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
        Collection<String> collection = Arrays.asList("a", "b", "c", "d");
        Collection<String> retain = Arrays.asList("b", "c", "e");
        Equator<String> equator = new TestEquator();

        try {
            Collection<String> result = CollectionUtils.retainAll(collection, retain, equator);
            Set<String> expected = new HashSet<>(Arrays.asList("b", "c"));
            assertEquals(expected, new HashSet<>(result));
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}