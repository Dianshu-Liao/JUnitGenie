package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_removeRange_Collection_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveRange_ValidRange() {
        Collection<Integer> input = new ArrayList<>();
        Collections.addAll(input, 1, 2, 3, 4, 5);
        Collection<Integer> result = CollectionUtils.removeRange(input, 1, 4);
        assertEquals(2, result.size());
        assertEquals(Collections.singletonList(1), result);
    }

    @Test(timeout = 4000)
    public void testRemoveRange_EmptyCollection() {
        Collection<Integer> input = new ArrayList<>();
        Collection<Integer> result = CollectionUtils.removeRange(input, 0, 1);
        assertEquals(0, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRange_EndIndexLessThanStartIndex() {
        Collection<Integer> input = new ArrayList<>();
        CollectionUtils.removeRange(input, 2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveRange_EndIndexGreaterThanSize() {
        Collection<Integer> input = new ArrayList<>();
        Collections.addAll(input, 1, 2);
        CollectionUtils.removeRange(input, 0, 3);
    }

    @Test(timeout = 4000)
    public void testRemoveRange_ExactlyFits() {
        Collection<Integer> input = new ArrayList<>();
        Collections.addAll(input, 1, 2, 3);
        Collection<Integer> result = CollectionUtils.removeRange(input, 0, 3);
        assertEquals(0, result.size());
    }

}