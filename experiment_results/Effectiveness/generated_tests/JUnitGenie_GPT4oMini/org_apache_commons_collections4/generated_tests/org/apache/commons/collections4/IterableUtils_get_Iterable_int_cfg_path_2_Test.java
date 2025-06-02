package org.apache.commons.collections4;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class IterableUtils_get_Iterable_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetFromList() {
        List<String> list = Arrays.asList("a", "b", "c");
        int index = 1; // Valid index
        CollectionUtils.checkIndexBounds(index); // Ensure index is valid
        String result = IterableUtils.get(list, index);
        assertEquals("b", result);
    }

    @Test(timeout = 4000)
    public void testGetFromEmptyList() {
        List<String> list = Arrays.asList();
        int index = 0; // Invalid index
        try {
            CollectionUtils.checkIndexBounds(index); // This should throw an exception
            IterableUtils.get(list, index); // This line should not be reached
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetFromListWithInvalidIndex() {
        List<String> list = Arrays.asList("a", "b", "c");
        int index = 3; // Invalid index
        try {
            CollectionUtils.checkIndexBounds(index); // This should throw an exception
            IterableUtils.get(list, index); // This line should not be reached
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}