package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_collate_Iterable_Iterable_Comparator_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCollateWithDuplicates() {
        List<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        List<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
            List<Integer> expected = Arrays.asList(1, 2, 2, 2, 3, 3, 4);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testCollateWithoutDuplicates() {
        List<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        List<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = false;

        try {
            List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
            List<Integer> expected = Arrays.asList(1, 2, 3, 4);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableA() {
        List<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(null, iterableB, comparator, includeDuplicates);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableB() {
        List<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(iterableA, null, comparator, includeDuplicates);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullComparator() {
        List<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        List<Integer> iterableB = Arrays.asList(2, 3, 4);
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(iterableA, iterableB, null, includeDuplicates);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}