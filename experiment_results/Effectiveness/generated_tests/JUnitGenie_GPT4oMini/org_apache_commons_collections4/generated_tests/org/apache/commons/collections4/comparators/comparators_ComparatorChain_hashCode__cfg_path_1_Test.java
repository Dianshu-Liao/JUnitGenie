package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class comparators_ComparatorChain_hashCode__cfg_path_1_Test {


    @Test(timeout = 4000)
    public void testHashCodeWithComparatorChainNull() {
        // Arrange
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>((List<Comparator<Object>>) null);
        BitSet orderingBits = new BitSet();
        orderingBits.set(0); // Set some bits

        // Act
        int result = comparatorChain.hashCode();

        // Assert
        assertEquals(true, result != 0);
    }


    @Test(timeout = 4000)
    public void testHashCodeWithBothFieldsNull() {
        // Arrange
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>((List<Comparator<Object>>) null);

        // Act
        int result = comparatorChain.hashCode();

        // Assert
        assertEquals(0, result);
    }


}
