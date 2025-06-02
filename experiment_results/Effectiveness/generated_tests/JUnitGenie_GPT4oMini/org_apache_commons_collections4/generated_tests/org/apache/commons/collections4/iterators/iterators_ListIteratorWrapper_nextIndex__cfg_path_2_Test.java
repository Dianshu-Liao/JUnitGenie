package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import static org.junit.Assert.assertEquals;

public class iterators_ListIteratorWrapper_nextIndex__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextIndexWithListIterator() {
        List<String> list = Arrays.asList("a", "b", "c");
        ListIterator<String> listIterator = list.listIterator();
        ListIteratorWrapper wrapper = new ListIteratorWrapper(listIterator);

        // Move to the next element
        listIterator.next();

        // Test the nextIndex method
        int expectedIndex = 1; // Since we have moved one step forward
        int actualIndex = wrapper.nextIndex();
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testNextIndexWithNonListIterator() {
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
        ListIteratorWrapper wrapper = new ListIteratorWrapper(iterator);

        // Test the nextIndex method
        int expectedIndex = 0; // Since we haven't moved in the iterator
        int actualIndex = wrapper.nextIndex();
        assertEquals(expectedIndex, actualIndex);
    }

}