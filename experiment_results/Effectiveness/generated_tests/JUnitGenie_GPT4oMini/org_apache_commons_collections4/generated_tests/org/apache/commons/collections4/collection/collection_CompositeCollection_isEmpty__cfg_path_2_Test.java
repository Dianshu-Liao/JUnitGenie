package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;

public class collection_CompositeCollection_isEmpty__cfg_path_2_Test {



    @Test(timeout = 4000)
    public void testIsEmptyWithAllNonEmptyCollections() {
        // Arrange
        List<Collection<String>> collections = new ArrayList<>();
        collections.add(new ArrayList<>(Arrays.asList("item1"))); // Non-empty collection
        collections.add(new ArrayList<>(Arrays.asList("item2"))); // Another non-empty collection
        CompositeCollection<Collection<String>> compositeCollection = new CompositeCollection<>(collections);

        // Act
        boolean result = compositeCollection.isEmpty();

        // Assert
        assertFalse(result);
    }


}
