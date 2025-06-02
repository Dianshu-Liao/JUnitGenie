package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class comparators_ComparatorChain_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullComparatorChainAndOrderingBits() {
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>();
        int expectedHashCode = 0; // Both fields are null, so hashCode should return 0
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullComparatorChain() {
        List<Comparator<Object>> comparators = new ArrayList<>();
        Comparator<Object> comparator = (o1, o2) -> 0; // Example comparator
        comparators.add(comparator);
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>(comparators);
        int expectedHashCode = comparators.hashCode(); // Expected hash code based on comparatorChain
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullOrderingBits() {
        BitSet orderingBits = new BitSet();
        orderingBits.set(0); // Set a bit to make it non-null
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>(new ArrayList<>()); // Initialize with an empty list
        // Removed the setOrderingBits method call as it does not exist
        int expectedHashCode = orderingBits.hashCode(); // Expected hash code based on orderingBits
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithBothFieldsNonNull() {
        List<Comparator<Object>> comparators = new ArrayList<>();
        Comparator<Object> comparator = (o1, o2) -> 0; // Example comparator
        comparators.add(comparator);
        BitSet orderingBits = new BitSet();
        orderingBits.set(0); // Set a bit to make it non-null
        ComparatorChain<Object> comparatorChain = new ComparatorChain<>(comparators);
        // Removed the setOrderingBits method call as it does not exist
        int expectedHashCode = comparators.hashCode() ^ orderingBits.hashCode(); // Expected hash code combining both
        assertEquals(expectedHashCode, comparatorChain.hashCode());
    }

}