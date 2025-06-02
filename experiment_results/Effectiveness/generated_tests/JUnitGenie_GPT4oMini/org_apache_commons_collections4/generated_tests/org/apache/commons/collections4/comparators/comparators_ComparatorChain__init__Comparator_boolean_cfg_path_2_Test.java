package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import java.util.BitSet;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;

public class comparators_ComparatorChain__init__Comparator_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testComparatorChainInitialization() {
        // Arrange
        Comparator<String> comparator = Comparator.naturalOrder();
        boolean reverse = false;

        // Act
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(comparator, reverse);

        // Assert
        assertNotNull(comparatorChain);
        // Additional assertions can be added here to verify the internal state if needed
    }

    @Test(timeout = 4000)
    public void testComparatorChainInitializationWithReverse() {
        // Arrange
        Comparator<String> comparator = Comparator.naturalOrder();
        boolean reverse = true;

        // Act
        ComparatorChain<String> comparatorChain = new ComparatorChain<>(comparator, reverse);

        // Assert
        assertNotNull(comparatorChain);
        // Additional assertions can be added here to verify the internal state if needed
    }

}