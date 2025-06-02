package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertFalse;

public class iterators_LoopingIterator_hasNext__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenCollectionIsEmpty() {
        // Arrange
        Collection<Object> emptyCollection = new ArrayList<>();
        LoopingIterator iterator = new LoopingIterator(emptyCollection);

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertFalse(result);
    }

}