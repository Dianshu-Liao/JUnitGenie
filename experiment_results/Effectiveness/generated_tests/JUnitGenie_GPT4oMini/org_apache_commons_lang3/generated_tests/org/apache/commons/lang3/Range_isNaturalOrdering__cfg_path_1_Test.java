package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.util.Comparator;

public class Range_isNaturalOrdering__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNaturalOrdering() {
        // Create an instance of Range with a comparator that is not ComparableComparator.INSTANCE
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        
        Range<Integer> range = new Range<>(1, 10, customComparator);
        
        // Call the focal method and assert the expected outcome
        boolean result = range.isNaturalOrdering();
        assertFalse(result);
    }


}