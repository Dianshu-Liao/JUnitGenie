package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_collate_Iterable_Iterable_Comparator_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCollateWithDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        List<Integer> result = null;
        try {
            result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 3, 3, 4);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCollateWithoutDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = false;

        List<Integer> result = null;
        try {
            result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCollateWithNulls() {
        Iterable<Integer> iterableA = null;
        Iterable<Integer> iterableB = Arrays.asList(2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        try {
            CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}