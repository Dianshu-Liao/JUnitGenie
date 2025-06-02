package org.apache.commons.collections4;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class IterableUtils_get_Iterable_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetFromList() {
        List<String> list = Arrays.asList("a", "b", "c");
        int index = 1; // satisfies 0 <= index < list.size()

        String result = IterableUtils.get(list, index);
        assertEquals("b", result);
    }

    @Test(timeout = 4000)
    public void testGetFromNullIterable() {
        Iterable<String> iterable = null;
        int index = 0; // valid index for empty iterator

        // Check for null iterable before accessing
        String result = IterableUtils.get(iterable, index);
        assertNull(result); // Expecting null as the result since the iterator is empty
    }

    @Test(timeout = 4000)
    public void testGetFromEmptyIterable() {
        List<String> list = Arrays.asList();
        int index = 0; // out of bounds
        
        try {
            String result = IterableUtils.get(list, index);
            fail("Expected an exception to be thrown due to index out of bounds.");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetFromNonEmptyIterableWithValidIndex() {
        List<String> list = Arrays.asList("x", "y", "z");
        int index = 2; // satisfies 0 <= index < list.size()

        String result = IterableUtils.get(list, index);
        assertEquals("z", result);
    }

    @Test(timeout = 4000)
    public void testGetFromListWithInvalidIndex() {
        List<String> list = Arrays.asList("x", "y", "z");
        int index = 3; // out of bounds

        try {
            String result = IterableUtils.get(list, index);
            fail("Expected an exception to be thrown due to index out of bounds.");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }


}