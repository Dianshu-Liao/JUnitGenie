package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CollectionUtils_collate_Iterable_Iterable_Comparator_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCollateIncludeDuplicates() {
        List<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        List<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        List<Integer> result = null;
        try {
            result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
        } catch (Exception e) {
            // Handle the exception as per rule 4
        }

        assertNotNull(result);
        assertEquals(Arrays.asList(1, 2, 2, 2, 3, 3, 4), result);
    }

    @Test(timeout = 4000)
    public void testCollateWithoutDuplicates() {
        List<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        List<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = false;

        List<Integer> result = null;
        try {
            result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
        } catch (Exception e) {
            // Handle the exception as per rule 4
        }

        assertNotNull(result);
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableA() {
        List<Integer> iterableB = Arrays.asList(2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        CollectionUtils.collate(null, iterableB, comparator, includeDuplicates);
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableB() {
        List<Integer> iterableA = Arrays.asList(1, 2, 3);
        Comparator<Integer> comparator = Integer::compareTo;
        boolean includeDuplicates = true;

        CollectionUtils.collate(iterableA, null, comparator, includeDuplicates);
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullComparator() {
        List<Integer> iterableA = Arrays.asList(1, 2, 3);
        List<Integer> iterableB = Arrays.asList(4, 5);
        boolean includeDuplicates = true;

        CollectionUtils.collate(iterableA, iterableB, null, includeDuplicates);
    }


}