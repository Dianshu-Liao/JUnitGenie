package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class set_CompositeSet_remove_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElementExists() {
        // Arrange
        Set<Object> set1 = new HashSet<>();
        set1.add("testElement");
        CompositeSet<Object> compositeSet = new CompositeSet<>(set1);

        // Act
        boolean result = compositeSet.remove("testElement");

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementDoesNotExist() {
        // Arrange
        Set<Object> set1 = new HashSet<>();
        set1.add("testElement");
        CompositeSet<Object> compositeSet = new CompositeSet<>(set1);

        // Act
        boolean result = compositeSet.remove("nonExistentElement");

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveFromEmptyCompositeSet() {
        // Arrange
        CompositeSet<Object> compositeSet = new CompositeSet<>(new HashSet<>());

        // Act
        boolean result = compositeSet.remove("testElement");

        // Assert
        assertFalse(result);
    }

}