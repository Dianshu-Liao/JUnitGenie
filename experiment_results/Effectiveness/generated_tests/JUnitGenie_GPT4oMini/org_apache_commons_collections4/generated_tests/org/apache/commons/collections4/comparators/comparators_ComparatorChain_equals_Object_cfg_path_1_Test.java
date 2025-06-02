package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class comparators_ComparatorChain_equals_Object_cfg_path_1_Test {

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
        String differentClassObject = "Not a ComparatorChain";
        assertFalse(chain.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualChains() {
        BitSet orderingBits = new BitSet();
        orderingBits.set(0);
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
        ArrayList<Comparator<Object>> comparatorList = new ArrayList<>();
        ComparatorChain<Object> chain1 = new ComparatorChain<>(comparatorList, orderingBits1);
        ComparatorChain<Object> chain2 = new ComparatorChain<>(comparatorList, orderingBits2);
        assertFalse(chain1.equals(chain2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentComparatorChains() {
        BitSet orderingBits = new BitSet();
        orderingBits.set(0);
        ArrayList<Comparator<Object>> comparatorList1 = new ArrayList<>();
        ArrayList<Comparator<Object>> comparatorList2 = new ArrayList<>();
        ComparatorChain<Object> chain1 = new ComparatorChain<>(comparatorList1, orderingBits);
        ComparatorChain<Object> chain2 = new ComparatorChain<>(comparatorList2, orderingBits);
        assertFalse(chain1.equals(chain2));
    }

}