package org.apache.commons.collections4.collection;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class collection_UnmodifiableBoundedCollection_unmodifiableBoundedCollection_Collection_cfg_path_13_Test {


    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithAbstractCollectionDecorator() {
        try {
            Collection<Integer> collection = new AbstractCollectionDecorator<Integer>(new ArrayList<>()) {
                @Override
                public int size() {
                    return super.size();
                }

                @Override
                public void clear() { // Implement clear method
                    super.clear();
                }

                @Override
                public Iterator<Integer> iterator() { // Implement iterator method
                    return super.iterator();
                }

                @Override
                public boolean retainAll(Collection<?> c) { // Implement retainAll method
                    return super.retainAll(c);
                }

                @Override
                public boolean removeAll(Collection<?> c) { // Implement removeAll method
                    return super.removeAll(c);
                }
            };

            BoundedCollection<Integer> unmodifiableCollection = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection);
            fail("Expected IllegalArgumentException, but no exception thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testUnmodifiableBoundedCollectionWithSynchronizedCollection() {
        try {
            Collection<Integer> collection = new SynchronizedCollection<>(new ArrayList<>());

            BoundedCollection<Integer> unmodifiableCollection = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(collection);
            fail("Expected IllegalArgumentException, but no exception thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }


}
