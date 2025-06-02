package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class comparators_ComparatorChain_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
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
        ComparatorChain<Object> chain1 = new ComparatorChain<>();
        ComparatorChain<Object> chain2 = new ComparatorChain<>();
        assertTrue(chain1.equals(chain2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentOrderingBits() {
        ComparatorChain<Object> chain1 = new ComparatorChain<>();
        ComparatorChain<Object> chain2 = new ComparatorChain<>();
        // Assuming orderingBits is a field that can be set, you would set them differently here
        // chain1.setOrderingBits(someValue1);
        // chain2.setOrderingBits(someValue2);
        // assertFalse(chain1.equals(chain2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentComparatorChains() {
        ComparatorChain<Object> chain1 = new ComparatorChain<>();
        ComparatorChain<Object> chain2 = new ComparatorChain<>();
        // Assuming comparatorChain is a field that can be set, you would set them differently here
        // chain1.setComparatorChain(someComparator1);
        // chain2.setComparatorChain(someComparator2);
        // assertFalse(chain1.equals(chain2));
    }

}