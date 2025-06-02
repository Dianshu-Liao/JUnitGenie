package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class comparators_ComparatorChain_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameReference() {
        ComparatorChain<String> chain = new ComparatorChain<>();
        assertTrue(chain.equals(chain));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        ComparatorChain<String> chain = new ComparatorChain<>();
        assertFalse(chain.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        ComparatorChain<String> chain = new ComparatorChain<>();
        String differentClassObject = "Not a ComparatorChain";
        assertFalse(chain.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualChains() {
        ComparatorChain<String> chain1 = new ComparatorChain<>();
        ComparatorChain<String> chain2 = new ComparatorChain<>();
        // Assuming orderingBits and comparatorChain are initialized the same for a meaningful comparison
        assertTrue(chain1.equals(chain2));
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualChains() {
        ComparatorChain<String> chain1 = new ComparatorChain<>();
        ComparatorChain<String> chain2 = new ComparatorChain<>(String::compareTo);
        assertFalse(chain1.equals(chain2));
    }

}