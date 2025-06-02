package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import static org.junit.Assert.assertEquals;

public class iterators_ListIteratorWrapper_nextIndex__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNextIndexWithListIterator() {
        // Create a list and a ListIterator
        List<String> list = Arrays.asList("a", "b", "c");
        ListIterator<String> listIterator = list.listIterator();

        // Create an instance of ListIteratorWrapper with the ListIterator
        ListIteratorWrapper<String> wrapper = new ListIteratorWrapper<>(listIterator);

        // Move the iterator to the next element
        listIterator.next(); // Move to "a"

        // Set the currentIndex to 1 (after "a")
        // Accessing the private field directly for testing purposes
        // This would typically be done via a setter or reflection in real tests
        // Assuming we have a way to set currentIndex, e.g., via a constructor or method
        // wrapper.setCurrentIndex(1); // Hypothetical method to set currentIndex

        // Call nextIndex() and assert the expected value
        int expectedIndex = 1; // Since we moved to "b"
        int actualIndex = wrapper.nextIndex();
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testNextIndexWithoutListIterator() {
        // Create an iterator that is not a ListIterator
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();

        // Create an instance of ListIteratorWrapper with the Iterator
        ListIteratorWrapper<String> wrapper = new ListIteratorWrapper<>(iterator);

        // Set the currentIndex to 2 (hypothetical)
        // wrapper.setCurrentIndex(2); // Hypothetical method to set currentIndex

        // Call nextIndex() and assert the expected value
        int expectedIndex = 2; // Since currentIndex is set to 2
        int actualIndex = wrapper.nextIndex();
        assertEquals(expectedIndex, actualIndex);
    }

}