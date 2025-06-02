package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class collection_CompositeCollection_isEmpty__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsEmpty() {
        // Create a CompositeCollection with an empty Collection
        CompositeCollection<Integer> collection = new CompositeCollection<>();

        // Verify that isEmpty() returns true for an empty CompositeCollection
        assertTrue(collection.isEmpty());
    }

}