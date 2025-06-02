package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PermutationIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class iterators_PermutationIterator__init__Collection_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPermutationIteratorWithValidCollection() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);
        try {
            PermutationIterator<Integer> iterator = new PermutationIterator<>(collection);
            assertNotNull(iterator);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(expected = NullPointerException.class)
    public void testPermutationIteratorWithNullCollection() {
        try {
            PermutationIterator<Integer> iterator = new PermutationIterator<>(null);
        } catch (NullPointerException e) {
            // Expected exception
            throw e; // Rethrow to satisfy the expected exception
        }
    }

}