package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.BoundedCollection;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;

public class collection_UnmodifiableBoundedCollection_unmodifiableBoundedCollection_Collection_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithSynchronizedCollection() {
        // Create a SynchronizedCollection
        Collection<String> synchronizedCollection = new SynchronizedCollection<>(new ArrayList<>());
        synchronizedCollection.add("element1");
        synchronizedCollection.add("element2");

        try {
            // Call the focal method
            BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(synchronizedCollection);
            assertNotNull(result);
            assertTrue(result instanceof UnmodifiableBoundedCollection);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithNonBoundedCollection() {
        Collection<String> nonBoundedCollection = new ArrayList<>();
        nonBoundedCollection.add("element1");

        try {
            // Call the focal method expecting an IllegalArgumentException
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(nonBoundedCollection);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Collection is not a bounded collection.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e.getClass().getName());
        }
    }


}