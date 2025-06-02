package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.collection.CompositeCollection.CollectionMutator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Collection;

public class collection_CompositeCollection_remove_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveWithMutator() {
        // Arrange
        CompositeCollection<Object> collection = new CompositeCollection<>();
        CollectionMutator<Object> mutator = new CollectionMutator<Object>() {
            @Override
            public boolean remove(CompositeCollection<Object> compositeCollection, List<Collection<Object>> all, Object obj) {
                // Mock behavior for the mutator's remove method
                return true; // Simulate successful removal
            }

            @Override
            public boolean addAll(CompositeCollection<Object> compositeCollection, List<Collection<Object>> all, Collection<? extends Object> c) {
                // Implement the required method
                return true; // Simulate successful addition
            }

            @Override
            public boolean add(CompositeCollection<Object> compositeCollection, List<Collection<Object>> all, Object obj) {
                // Implement the required method
                return true; // Simulate successful addition
            }
        };
        
        // Set the mutator
        collection.setMutator(mutator); // Assuming a setter method exists

        Object objToRemove = new Object(); // Object to remove

        // Act
        boolean result = collection.remove(objToRemove);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testRemoveWithoutMutator() {
        // Arrange
        CompositeCollection<Object> collection = new CompositeCollection<>();

        Object objToRemove = new Object(); // Object to remove

        // Act & Assert
        try {
            collection.remove(objToRemove);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("remove() is not supported on CompositeCollection without a CollectionMutator strategy", e.getMessage());
        }
    }

}