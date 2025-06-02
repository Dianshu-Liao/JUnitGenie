package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import static org.junit.Assert.assertEquals;

public class iterators_ListIteratorWrapper_previousIndex__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPreviousIndexWithListIterator() {
        List<String> list = Arrays.asList("A", "B", "C");
        ListIterator<String> listIterator = list.listIterator(1); // Start at index 1 (pointing to "B")
        ListIteratorWrapper<String> wrapper = new ListIteratorWrapper<>(listIterator);
        
        // Call the focal method
        int index = wrapper.previousIndex();
        
        // Verify the result
        assertEquals(0, index); // The previous index of "B" should be 0
    }

    @Test(timeout = 4000)
    public void testPreviousIndexWithoutListIterator() {
        Iterator<String> iterator = Arrays.asList("A", "B", "C").iterator();
        ListIteratorWrapper<String> wrapper = new ListIteratorWrapper<>(iterator);
        
        // Call the focal method
        int index = wrapper.previousIndex();
        
        // Verify the result
        assertEquals(-1, index); // Since the iterator is not a ListIterator, it should return currentIndex - 1, which is -1
    }

}