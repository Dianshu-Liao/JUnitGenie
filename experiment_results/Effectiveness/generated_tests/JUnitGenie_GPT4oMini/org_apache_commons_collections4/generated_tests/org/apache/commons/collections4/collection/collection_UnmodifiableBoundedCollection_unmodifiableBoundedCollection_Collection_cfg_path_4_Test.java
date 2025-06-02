package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.BoundedCollection;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static org.junit.Assert.*;

public class collection_UnmodifiableBoundedCollection_unmodifiableBoundedCollection_Collection_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithAbstractCollectionDecorator() {
        Collection<String> collection = new AbstractCollectionDecorator<String>(new ArrayList<>()) {
            @Override
            public int size() {
                return 0; // Size is 0 for the test
            }

            @Override
            public java.util.Iterator<String> iterator() {
                return Collections.emptyIterator(); // Empty iterator for the test
            }
        };

        try {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection);
            fail("Expected IllegalArgumentException for non-bounded collection");
        } catch (IllegalArgumentException e) {
            assertEquals("Collection is not a bounded collection.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithSynchronizedCollection() {
        Collection<String> collection = new SynchronizedCollection<>(new ArrayList<>());

        try {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection);
            fail("Expected IllegalArgumentException for non-bounded collection");
        } catch (IllegalArgumentException e) {
            assertEquals("Collection is not a bounded collection.", e.getMessage());
        }
    }



}
