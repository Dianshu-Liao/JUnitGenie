package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertNotEquals;

public class set_CompositeSet_hashCode__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNonEmptySet() {
        // Arrange
        Set<Object> set = new HashSet<>();
        set.add(new Object()); // Adding an element to ensure the set is not empty
        CompositeSet compositeSet = new CompositeSet(set);

        // Act
        int hashCode = compositeSet.hashCode();

        // Assert
        assertNotEquals(0, hashCode); // The hashCode should not be zero for a non-empty set
    }

}