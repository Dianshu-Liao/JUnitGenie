package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class set_CompositeSet_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNonEmptySet() {
        // Arrange
        Set<Object> set = new HashSet<>();
        set.add(new Object()); // Adding an element to ensure the set is non-empty
        CompositeSet<Object> compositeSet = new CompositeSet<>(set);

        // Act
        int hashCode = compositeSet.hashCode();

        // Assert
        // Since we have added an element, the hashCode should not be zero
        assertNotEquals(0, hashCode);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullElement() {
        // Arrange
        Set<Object> set = new HashSet<>();
        set.add(null); // Adding a null element
        CompositeSet<Object> compositeSet = new CompositeSet<>(set);

        // Act
        int hashCode = compositeSet.hashCode();

        // Assert
        // The hashCode should be zero since the only element is null
        assertEquals(0, hashCode);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithMultipleElements() {
        // Arrange
        Set<Object> set = new HashSet<>();
        set.add(new Object());
        set.add(new Object());
        CompositeSet<Object> compositeSet = new CompositeSet<>(set);

        // Act
        int hashCode = compositeSet.hashCode();

        // Assert
        // The hashCode should not be zero and should be consistent for the same elements
        assertNotEquals(0, hashCode);
    }


}