package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class comparators_ComparatorChain_hashCode__cfg_path_3_Test {


    @Test(timeout = 4000)
    public void testHashCodeWithComparatorChainNull() {
        // Arrange
        BitSet bitSet = new BitSet();
        bitSet.set(0);

        ComparatorChain<Object> comparatorChain = new ComparatorChain<>(null, bitSet); // Specify type parameter

        // Act
        int result = comparatorChain.hashCode();

        // Assert
        assertEquals(bitSet.hashCode(), result);
    }


    @Test(timeout = 4000)
    public void testHashCodeWithBothFieldsNull() {
        // Arrange
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>(null, null); // Specify type parameter

        // Act
        int result = comparatorChain.hashCode();

        // Assert
        assertEquals(0, result);
    }


}
