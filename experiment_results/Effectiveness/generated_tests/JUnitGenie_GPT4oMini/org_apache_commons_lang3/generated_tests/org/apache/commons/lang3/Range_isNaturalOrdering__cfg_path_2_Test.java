package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.util.Comparator;

public class Range_isNaturalOrdering__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNaturalOrdering() {
        // Create a Range instance with a comparator that is not ComparableComparator.INSTANCE
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Range<Integer> range = new Range<>(1, 10, customComparator);
        
        // Test the isNaturalOrdering method
        try {
            boolean result = range.isNaturalOrdering();
            assertFalse("Expected isNaturalOrdering to return false", result);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}