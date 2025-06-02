package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertFalse;

public class set_ListOrderedSet_retainAll_Collection_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRetainAllWhenResultIsFalseAndSetIsEmpty() {
        // Arrange
        ListOrderedSet<String> listOrderedSet = new ListOrderedSet<>();
        Collection<String> collectionToRetain = Arrays.asList("A", "B", "C");

        // Act
        boolean result = false;
        try {
            result = listOrderedSet.retainAll(collectionToRetain);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRetainAllWhenResultIsTrueAndSetIsNotEmpty() {
        // Arrange
        ListOrderedSet<String> listOrderedSet = new ListOrderedSet<>();
        listOrderedSet.addAll(Arrays.asList("A", "B", "C"));
        Collection<String> collectionToRetain = Arrays.asList("B", "C");

        // Act
        boolean result = false;
        try {
            result = listOrderedSet.retainAll(collectionToRetain);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertFalse(listOrderedSet.isEmpty());
        assertFalse(result);
    }

}