package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Comparator;

public class comparators_NullComparator_hashCode__cfg_path_1_Test {
    
    @Test(timeout = 4000)
    public void testHashCode_whenNullsAreHigh() {
        // Setup
        Comparator<Comparable> nonNullComparator = Comparator.naturalOrder();
        NullComparator<Comparable> nullComparator = new NullComparator<>(nonNullComparator, true);
        
        // Execute
        int result = nullComparator.hashCode();
        
        // Verify
        assertEquals(-1 * nonNullComparator.hashCode(), result);
    }

    @Test(timeout = 4000)
    public void testHashCode_whenNullsAreLow() {
        // Setup
        Comparator<Comparable> nonNullComparator = Comparator.naturalOrder();
        NullComparator<Comparable> nullComparator = new NullComparator<>(nonNullComparator, false);
        
        // Execute
        int result = nullComparator.hashCode();
        
        // Verify
        assertEquals(1 * nonNullComparator.hashCode(), result);
    }


}