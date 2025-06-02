package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.fail;

public class collection_UnmodifiableBoundedCollection_unmodifiableBoundedCollection_Collection_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionThrowsException() {
        Collection<Object> collection = new ArrayList<>(); // Not a BoundedCollection
        try {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("Collection is not a bounded collection.");
        }
    }

}