package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class comparators_ComparatorChain_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        ComparatorChain<Object> chain = new ComparatorChain<>();
        assertTrue(chain.equals(chain));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        ComparatorChain<Object> chain = new ComparatorChain<>();
        assertFalse(chain.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        ComparatorChain<Object> chain = new ComparatorChain<>();
        String differentObject = "Not a ComparatorChain";
        assertFalse(chain.equals(differentObject));
    }



    // Assuming a comparator for BitSet is defined
    private static class BitSetComparator implements java.util.Comparator<BitSet> {
        @Override
        public int compare(BitSet o1, BitSet o2) {
            return o1.equals(o2) ? 0 : -1; // Simple equality check
        }
    }


}
