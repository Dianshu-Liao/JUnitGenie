package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.assertNotNull;

public class comparators_ComparatorChain__init__Comparator_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testComparatorChainInitialization() {
        // Create a simple comparator for testing
        Comparator<Integer> comparator = Comparator.naturalOrder();
        
        // Test with reverse = false
        ComparatorChain<Integer> chain1 = new ComparatorChain<>(comparator, false);
        assertNotNull(chain1);

        // Test with reverse = true
        ComparatorChain<Integer> chain2 = new ComparatorChain<>(comparator, true);
        assertNotNull(chain2);
    }

}