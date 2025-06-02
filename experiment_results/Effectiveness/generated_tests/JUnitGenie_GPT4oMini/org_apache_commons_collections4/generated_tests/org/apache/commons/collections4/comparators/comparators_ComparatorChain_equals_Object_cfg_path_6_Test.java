package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class comparators_ComparatorChain_equals_Object_cfg_path_6_Test {

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
    public void testEquals_DifferentChains() {
        ComparatorChain<Object> chain1 = new ComparatorChain<>();
        ComparatorChain<Object> chain2 = new ComparatorChain<>(new java.util.Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        assertFalse(chain1.equals(chain2));
    }

}