package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.BoundedCollection;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import static org.junit.Assert.*;

public class collection_UnmodifiableBoundedCollection_unmodifiableBoundedCollection_Collection_cfg_path_8_Test {


    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithInvalidCollection() {
        // Create a regular collection that is not a BoundedCollection
        Collection<String> invalidCollection = new ArrayList<>();
        invalidCollection.add("item1");

        // Test the focal method
        try {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(invalidCollection);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Collection is not a bounded collection.", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getClass().getSimpleName());
        }
    }


}
