package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class CollectionUtils_collate_Iterable_Iterable_Comparator_boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCollateWithDuplicates() {
        // Prepare test data
        List<Integer> iterableA = Arrays.asList(1, 2, 3, 4);
        List<Integer> iterableB = Arrays.asList(3, 4, 5, 6);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
            List<Integer> expected = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6);
            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCollateWithoutDuplicates() {
        // Prepare test data
        List<Integer> iterableA = Arrays.asList(1, 2, 3, 4);
        List<Integer> iterableB = Arrays.asList(3, 4, 5, 6);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = false;

        try {
            List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
            List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableA() {
        List<Integer> iterableB = Arrays.asList(3, 4, 5, 6);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(null, iterableB, comparator, includeDuplicates);
        } catch (NullPointerException e) {
            assertEquals("iterableA", e.getMessage());
            throw e; // Re-throw to satisfy @Test(expected)
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableB() {
        List<Integer> iterableA = Arrays.asList(1, 2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(iterableA, null, comparator, includeDuplicates);
        } catch (NullPointerException e) {
            assertEquals("iterableB", e.getMessage());
            throw e; // Re-throw to satisfy @Test(expected)
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullComparator() {
        List<Integer> iterableA = Arrays.asList(1, 2, 3, 4);
        List<Integer> iterableB = Arrays.asList(3, 4, 5, 6);
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(iterableA, iterableB, null, includeDuplicates);
        } catch (NullPointerException e) {
            assertEquals("comparator", e.getMessage());
            throw e; // Re-throw to satisfy @Test(expected)
        }
    }

}