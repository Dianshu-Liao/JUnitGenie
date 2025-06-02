package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CollectionUtils_collate_Iterable_Iterable_Comparator_boolean_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testCollate_withCollections_andIncludeDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
            assertNotNull(result);
            assertEquals(Arrays.asList(1, 2, 2, 2, 3, 3, 3, 4), result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle any potential exception
        }
    }

    @Test(timeout = 4000)
    public void testCollate_withCollections_andExcludeDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = false;

        try {
            List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
            assertNotNull(result);
            assertEquals(Arrays.asList(1, 2, 3, 4), result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle any potential exception
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollate_withNullIterableA() {
        Iterable<Integer> iterableB = Arrays.asList(2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(null, iterableB, comparator, includeDuplicates);
        } catch (NullPointerException e) {
            // Expected exception
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollate_withNullIterableB() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(iterableA, null, comparator, includeDuplicates);
        } catch (NullPointerException e) {
            // Expected exception
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollate_withNullComparator() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2);
        Iterable<Integer> iterableB = Arrays.asList(3, 4);
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(iterableA, iterableB, null, includeDuplicates);
        } catch (NullPointerException e) {
            // Expected exception
            throw e;
        }
    }

}