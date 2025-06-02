package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComparatorChain_ComparatorChain_15_0_Test {

    private ComparatorChain comparatorChain;

    @BeforeEach
    public void setUp() {
        // Initialize the comparatorChain before each test
    }

    @Test
    public void testConstructorWithComparatorAndReverseFalse() {
        Comparator<String> comparator = Comparator.naturalOrder();
        comparatorChain = new ComparatorChain(comparator, false);
        // Verify that the comparatorChain is initialized correctly
        assertNotNull(comparatorChain);
        assertEquals(1, invokeGetComparatorChainSize(comparatorChain));
        assertFalse(invokeGetOrderingBits(comparatorChain).get(0));
    }

    @Test
    public void testConstructorWithComparatorAndReverseTrue() {
        Comparator<String> comparator = Comparator.naturalOrder();
        comparatorChain = new ComparatorChain(comparator, true);
        // Verify that the comparatorChain is initialized correctly
        assertNotNull(comparatorChain);
        assertEquals(1, invokeGetComparatorChainSize(comparatorChain));
        assertTrue(invokeGetOrderingBits(comparatorChain).get(0));
    }

    // Reflection methods to access private fields
    private int invokeGetComparatorChainSize(ComparatorChain chain) {
        try {
            // Replaced 'var' with 'java.lang.reflect.Field'
            java.lang.reflect.Field field = ComparatorChain.class.getDeclaredField("comparatorChain");
            field.setAccessible(true);
            List<?> list = (List<?>) field.get(chain);
            return list.size();
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
            // unreachable
            return -1;
        }
    }

    private BitSet invokeGetOrderingBits(ComparatorChain chain) {
        // Replaced 'var' with 'java.lang.reflect.Field'
        try {
            java.lang.reflect.Field field = ComparatorChain.class.getDeclaredField("orderingBits");
            field.setAccessible(true);
            return (BitSet) field.get(chain);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
            // unreachable
            return null;
        }
    }
}
