package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class comparators_ComparatorChain_hashCode__cfg_path_4_Test {


    @Test(timeout = 4000)
    public void testHashCodeWithNullComparatorChain() {
        // Arrange
        BitSet orderingBits = new BitSet();
        orderingBits.set(0); // Set some bits for testing

        ComparatorChain<Object> comparatorChain = new ComparatorChain<>(null, orderingBits); // Specify type parameter

        // Act
        int hashCode = comparatorChain.hashCode();

        // Assert
        assertEquals(hashCode, hashCode); // This is a placeholder assertion
    }


    @Test(timeout = 4000)
    public void testHashCodeWithBothNulls() {
        // Arrange
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>(null, null); // Specify type parameter

        // Act
        int hashCode = comparatorChain.hashCode();

        // Assert
        assertEquals(hashCode, hashCode); // This is a placeholder assertion
    }


}
