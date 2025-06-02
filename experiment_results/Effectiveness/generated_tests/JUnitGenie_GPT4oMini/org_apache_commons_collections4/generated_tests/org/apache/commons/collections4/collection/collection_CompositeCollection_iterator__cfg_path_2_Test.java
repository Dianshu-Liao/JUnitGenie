package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;

public class collection_CompositeCollection_iterator__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIteratorWhenAllIsEmpty() {
        CompositeCollection<String> collection = new CompositeCollection<>();
        // The 'all' list is empty by default, so we expect the iterator to return an EmptyIterator.
        try {
            Iterator<String> iterator = collection.iterator();
            assertNotNull("Iterator should not be null", iterator);
            // Verify that the iterator is indeed an instance of EmptyIterator
            assertTrue("Iterator should be an instance of EmptyIterator", iterator instanceof EmptyIterator);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}