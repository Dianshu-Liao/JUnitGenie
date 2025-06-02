package org.apache.commons.collections4;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertNotNull;

public class IteratorUtils_collatedIterator_Comparator_Iterator_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCollatedIteratorWithNaturalComparator() {
        // Arrange
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4, 6).iterator();
        Iterator<Integer>[] iterators = new Iterator[] { iterator1, iterator2 };
        
        // Act
        Iterator<Integer> result = null;
        try {
            result = IteratorUtils.collatedIterator(null, iterators);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
        
        // Assert
        assertNotNull(result);
        // Additional assertions can be performed to test the expected behavior of the resulting iterator
    }
    
    @Test(timeout = 4000)
    public void testCollatedIteratorWithCustomComparator() {
        // Arrange
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4, 6).iterator();
        Iterator<Integer>[] iterators = new Iterator[] { iterator1, iterator2 };
        Comparator<Integer> customComparator = Comparator.reverseOrder();

        // Act
        Iterator<Integer> result = null;
        try {
            result = IteratorUtils.collatedIterator(customComparator, iterators);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
        
        // Assert
        assertNotNull(result);
        // Additional assertions can be performed to check the correctness of the iteration
    }

}