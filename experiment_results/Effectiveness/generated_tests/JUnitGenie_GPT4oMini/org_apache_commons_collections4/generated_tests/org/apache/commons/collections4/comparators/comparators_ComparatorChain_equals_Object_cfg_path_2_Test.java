package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class comparators_ComparatorChain_equals_Object_cfg_path_2_Test {

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

    @Test(timeout = 4000)
    public void testEquals_EqualChains() {
        BitSet orderingBits = new BitSet();
        ArrayList<Comparator<Object>> comparatorList = new ArrayList<>();
        ComparatorChain<Object> chain1 = new ComparatorChain<>(comparatorList, orderingBits);
        ComparatorChain<Object> chain2 = new ComparatorChain<>(comparatorList, orderingBits);
        assertTrue(chain1.equals(chain2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentOrderingBits() {
        BitSet orderingBits1 = new BitSet();
        orderingBits1.set(0);
        BitSet orderingBits2 = new BitSet();
        orderingBits2.set(1);
        ComparatorChain<Object> chain1 = new ComparatorChain<>(new ArrayList<>(), orderingBits1);
        ComparatorChain<Object> chain2 = new ComparatorChain<>(new ArrayList<>(), orderingBits2);
        assertFalse(chain1.equals(chain2));
    }



}
