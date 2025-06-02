package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class set_CompositeSet_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNonEmptySet() {
        // Arrange
        Set<Object> set = new HashSet<>();
        set.add(new Object()); // Adding a non-null object to ensure the iterator has elements
        CompositeSet compositeSet = new CompositeSet(set);

        // Act
        int result = compositeSet.hashCode();

        // Assert
        // Since we have one object, the hashCode should be equal to the hashCode of that object
        assertEquals(set.iterator().next().hashCode(), result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullElement() {
        // Arrange
        Set<Object> set = new HashSet<>();
        set.add(null); // Adding a null object to test the null handling
        CompositeSet compositeSet = new CompositeSet(set);

        // Act
        int result = compositeSet.hashCode();

        // Assert
        // The hashCode should be 0 since the only element is null
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithMultipleElements() {
        // Arrange
        Set<Object> set = new HashSet<>();
        Object obj1 = new Object();
        Object obj2 = new Object();
        set.add(obj1);
        set.add(obj2);
        CompositeSet compositeSet = new CompositeSet(set);

        // Act
        int result = compositeSet.hashCode();

        // Assert
        // The hashCode should be the sum of the hashCodes of obj1 and obj2
        assertEquals(obj1.hashCode() + obj2.hashCode(), result);
    }

}