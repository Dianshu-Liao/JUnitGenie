package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class set_CompositeSet_remove_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveElementExists() {
        // Arrange
        Set<Object> set1 = new HashSet<>();
        set1.add("testObject");
        CompositeSet<Object> compositeSet = new CompositeSet<>(set1);

        // Act
        boolean result = compositeSet.remove("testObject");

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementDoesNotExist() {
        // Arrange
        Set<Object> set1 = new HashSet<>();
        set1.add("testObject");
        CompositeSet<Object> compositeSet = new CompositeSet<>(set1);

        // Act
        boolean result = compositeSet.remove("nonExistentObject");

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveFromEmptyCompositeSet() {
        // Arrange
        CompositeSet<Object> compositeSet = new CompositeSet<>(new HashSet<>());

        // Act
        boolean result = compositeSet.remove("testObject");

        // Assert
        assertFalse(result);
    }

}