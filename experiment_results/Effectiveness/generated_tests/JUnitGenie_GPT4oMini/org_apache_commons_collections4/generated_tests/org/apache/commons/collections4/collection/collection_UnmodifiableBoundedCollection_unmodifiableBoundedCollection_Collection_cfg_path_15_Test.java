package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import static org.junit.Assert.*;

public class collection_UnmodifiableBoundedCollection_unmodifiableBoundedCollection_Collection_cfg_path_15_Test {


    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithInvalidCollection() {
        try {
            // Create a regular collection that is not a BoundedCollection
            Collection<String> regularCollection = new ArrayList<>();
            regularCollection.add("test");

            // Call the focal method, expecting an IllegalArgumentException
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(regularCollection);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}
