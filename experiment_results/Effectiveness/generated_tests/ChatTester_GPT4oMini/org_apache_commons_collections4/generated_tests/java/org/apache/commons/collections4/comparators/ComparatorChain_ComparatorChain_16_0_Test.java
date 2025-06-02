package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

class ComparatorChain_ComparatorChain_16_0_Test {

    private List<Comparator<String>> comparatorList;

    private ComparatorChain comparatorChain;

    @BeforeEach
    void setUp() {
        comparatorList = new ArrayList<>();
        comparatorList.add(Comparator.naturalOrder());
        comparatorList.add(Comparator.reverseOrder());
    }

    @Test
    void testComparatorChainWithList() {
        comparatorChain = new ComparatorChain(comparatorList);
        // Verify that the comparatorChain is not null
        assertNotNull(comparatorChain);
        // Use reflection to access private fields
        try {
            Field comparatorChainField = ComparatorChain.class.getDeclaredField("comparatorList");
            comparatorChainField.setAccessible(true);
            List<Comparator<String>> internalComparatorChain = (List<Comparator<String>>) comparatorChainField.get(comparatorChain);
            assertEquals(comparatorList.size(), internalComparatorChain.size(), "The size of the internal comparator chain should match the input list size.");
            Field orderingBitsField = ComparatorChain.class.getDeclaredField("orderingBits");
            orderingBitsField.setAccessible(true);
            BitSet orderingBits = (BitSet) orderingBitsField.get(comparatorChain);
            assertEquals(comparatorList.size(), orderingBits.size(), "The size of the ordering bits should match the input list size.");
            assertTrue(orderingBits.isEmpty(), "Ordering bits should be empty initially.");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }
}
