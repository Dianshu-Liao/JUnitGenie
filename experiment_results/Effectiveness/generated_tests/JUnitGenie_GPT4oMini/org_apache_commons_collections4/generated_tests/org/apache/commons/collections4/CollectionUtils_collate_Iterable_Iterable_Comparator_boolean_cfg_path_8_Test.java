package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class CollectionUtils_collate_Iterable_Iterable_Comparator_boolean_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testCollateWithDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compare;
        boolean includeDuplicates = true;

        List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);

        List<Integer> expected = Arrays.asList(1, 2, 2, 2, 3, 3, 4);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCollateWithoutDuplicates() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(2, 3, 4);
        Comparator<Integer> comparator = Integer::compare;
        boolean includeDuplicates = false;

        List<Integer> result = CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableA() {
        Iterable<Integer> iterableA = null;
        Iterable<Integer> iterableB = Arrays.asList(1, 2, 3);
        Comparator<Integer> comparator = Integer::compare;
        boolean includeDuplicates = true;

        CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullIterableB() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 3);
        Iterable<Integer> iterableB = null;
        Comparator<Integer> comparator = Integer::compare;
        boolean includeDuplicates = false;

        CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
    }

    @Test(expected = NullPointerException.class)
    public void testCollateWithNullComparator() {
        Iterable<Integer> iterableA = Arrays.asList(1, 2, 3);
        Iterable<Integer> iterableB = Arrays.asList(4, 5, 6);
        Comparator<Integer> comparator = null;
        boolean includeDuplicates = false;

        CollectionUtils.collate(iterableA, iterableB, comparator, includeDuplicates);
    }

}