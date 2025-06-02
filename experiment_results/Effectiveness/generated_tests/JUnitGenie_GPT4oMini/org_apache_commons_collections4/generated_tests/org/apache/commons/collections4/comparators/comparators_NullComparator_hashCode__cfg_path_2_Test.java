package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Comparator;

public class comparators_NullComparator_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullsAreHighTrue() {
        // Arrange
        NullComparator comparator = new NullComparator(Comparator.naturalOrder(), true);
        
        // Act
        int result = comparator.hashCode();
        
        // Assert
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullsAreHighFalse() {
        // Arrange
        NullComparator comparator = new NullComparator(Comparator.naturalOrder(), false);
        
        // Act
        int result = comparator.hashCode();
        
        // Assert
        assertEquals(1, result);
    }


}