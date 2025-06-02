package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertTrue;

public class iterators_LoopingIterator_hasNext__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenCollectionIsNotEmpty() {
        // Arrange
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        LoopingIterator iterator = new LoopingIterator(collection);

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testHasNextWhenCollectionIsEmpty() {
        // Arrange
        Collection<Integer> collection = new ArrayList<>();
        LoopingIterator iterator = new LoopingIterator(collection);

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertTrue(!result);
    }

}