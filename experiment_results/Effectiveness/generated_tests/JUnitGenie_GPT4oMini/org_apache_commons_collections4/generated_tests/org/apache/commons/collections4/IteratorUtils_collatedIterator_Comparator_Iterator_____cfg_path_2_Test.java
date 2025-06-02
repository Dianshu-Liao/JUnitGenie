package org.apache.commons.collections4;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class IteratorUtils_collatedIterator_Comparator_Iterator_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCollatedIteratorWithNonNullComparator() {
        Comparator<Integer> comparator = Integer::compareTo;
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4, 6).iterator();
        Iterator<Integer> result = IteratorUtils.collatedIterator(comparator, iterator1, iterator2);

        assertTrue(result.hasNext());
        assertEquals(Integer.valueOf(1), result.next());
        assertEquals(Integer.valueOf(2), result.next());
        assertEquals(Integer.valueOf(3), result.next());
        assertEquals(Integer.valueOf(4), result.next());
        assertEquals(Integer.valueOf(5), result.next());
        assertEquals(Integer.valueOf(6), result.next());
        assertFalse(result.hasNext());
    }

    @Test(timeout = 4000)
    public void testCollatedIteratorWithNullComparator() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4, 6).iterator();
        Iterator<Integer> result = IteratorUtils.collatedIterator(null, iterator1, iterator2);

        assertTrue(result.hasNext());
        assertEquals(Integer.valueOf(1), result.next());
        assertEquals(Integer.valueOf(2), result.next());
        assertEquals(Integer.valueOf(3), result.next());
        assertEquals(Integer.valueOf(4), result.next());
        assertEquals(Integer.valueOf(5), result.next());
        assertEquals(Integer.valueOf(6), result.next());
        assertFalse(result.hasNext());
    }

    @Test(timeout = 4000)
    public void testCollatedIteratorWithEmptyIterators() {
        Iterator<Integer> iterator1 = Arrays.<Integer>asList().iterator();
        Iterator<Integer> iterator2 = Arrays.<Integer>asList().iterator();
        Iterator<Integer> result = IteratorUtils.collatedIterator(Comparator.naturalOrder(), iterator1, iterator2);

        assertFalse(result.hasNext());
    }

    @Test(timeout = 4000)
    public void testCollatedIteratorWithSingleIterator() {
        Comparator<Integer> comparator = Integer::compareTo;
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> result = IteratorUtils.collatedIterator(comparator, iterator1);

        assertTrue(result.hasNext());
        assertEquals(Integer.valueOf(1), result.next());
        assertEquals(Integer.valueOf(3), result.next());
        assertEquals(Integer.valueOf(5), result.next());
        assertFalse(result.hasNext());
    }


}