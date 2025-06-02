package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

public class set_ListOrderedSet_retainAll_Collection_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRetainAll() {
        // Arrange
        ListOrderedSet<String> listOrderedSet = new ListOrderedSet<>();
        listOrderedSet.addAll(Arrays.asList("A", "B", "C"));
        Collection<String> collectionToRetain = Arrays.asList("B", "C");

        // Act
        boolean result = listOrderedSet.retainAll(collectionToRetain);

        // Assert
        assertTrue(result);
        assertTrue(listOrderedSet.contains("B"));
        assertTrue(listOrderedSet.contains("C"));
        assertFalse(listOrderedSet.contains("A"));
    }

    @Test(timeout = 4000)
    public void testRetainAllWhenEmpty() {
        // Arrange
        ListOrderedSet<String> listOrderedSet = new ListOrderedSet<>();
        Collection<String> collectionToRetain = Arrays.asList("B", "C");

        // Act
        boolean result = listOrderedSet.retainAll(collectionToRetain);

        // Assert
        assertFalse(result);
        assertTrue(listOrderedSet.isEmpty());
    }

    @Test(timeout = 4000)
    public void testRetainAllWithNoCommonElements() {
        // Arrange
        ListOrderedSet<String> listOrderedSet = new ListOrderedSet<>();
        listOrderedSet.addAll(Arrays.asList("A", "B", "C"));
        Collection<String> collectionToRetain = Arrays.asList("D", "E");

        // Act
        boolean result = listOrderedSet.retainAll(collectionToRetain);

        // Assert
        assertFalse(result);
        assertEquals(3, listOrderedSet.size());
    }

}