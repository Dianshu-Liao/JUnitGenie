package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.*;

public class collection_UnmodifiableBoundedCollection_unmodifiableBoundedCollection_Collection_cfg_path_7_Test {


    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionThrowsException() {
        try {
            // Create a non-bounded collection
            Collection<String> nonBoundedCollection = new ArrayList<>();
            nonBoundedCollection.add("item1");

            // Call the focal method, expecting an IllegalArgumentException
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(nonBoundedCollection);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }


}
