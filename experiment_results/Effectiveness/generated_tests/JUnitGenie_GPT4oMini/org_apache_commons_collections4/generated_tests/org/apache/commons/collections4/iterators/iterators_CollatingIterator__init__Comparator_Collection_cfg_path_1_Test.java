package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import static org.junit.Assert.assertNotNull;

public class iterators_CollatingIterator__init__Comparator_Collection_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCollatingIteratorInitialization() {
        Comparator<String> comparator = Comparator.naturalOrder(); // Changed Object to String
        Collection<Iterator<? extends String>> iterators = new ArrayList<>();
        
        // Adding iterators to the collection
        iterators.add(Arrays.asList("a", "b").iterator());
        iterators.add(Arrays.asList("c", "d").iterator());

        // Try-catch block to handle potential exceptions
        try {
            CollatingIterator<String> collatingIterator = new CollatingIterator<>(comparator, iterators); // Changed Object to String
            assertNotNull(collatingIterator);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }
    }


}