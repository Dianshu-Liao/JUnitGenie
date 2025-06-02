package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_BooleanComparator_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCodeTrueFirst() {
        // Arrange
        BooleanComparator comparator = new BooleanComparator(true);
        
        // Act
        int hashCode = comparator.hashCode();
        
        // Assert
        final int expectedHash = -1 * "BooleanComparator".hashCode();
        assertEquals(expectedHash, hashCode);
    }

    @Test(timeout = 4000)
    public void testHashCodeFalseFirst() {
        // Arrange
        BooleanComparator comparator = new BooleanComparator(false);
        
        // Act
        int hashCode = comparator.hashCode();
        
        // Assert
        final int expectedHash = "BooleanComparator".hashCode();
        assertEquals(expectedHash, hashCode);
    }

}