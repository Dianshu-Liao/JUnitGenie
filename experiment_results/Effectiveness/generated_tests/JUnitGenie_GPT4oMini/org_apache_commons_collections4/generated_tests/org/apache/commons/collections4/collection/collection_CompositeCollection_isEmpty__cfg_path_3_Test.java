package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class collection_CompositeCollection_isEmpty__cfg_path_3_Test {


    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyCollections() {
        // Arrange
        List<Collection<String>> collections = new ArrayList<>();
        Collection<String> emptyCollection1 = new ArrayList<>();
        Collection<String> emptyCollection2 = new ArrayList<>();
        collections.add(emptyCollection1);
        collections.add(emptyCollection2);
        
        // Correcting the type of CompositeCollection to accept a Collection of Collections
        CompositeCollection<Collection<String>> compositeCollection = new CompositeCollection<>(collections);

        // Act
        boolean result = compositeCollection.isEmpty();

        // Assert
        assertTrue(result);
    }


}
