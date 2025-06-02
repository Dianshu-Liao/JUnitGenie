package org.apache.commons.collections4.comparators;

import java.util.BitSet;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class ComparatorChain_ComparatorChain_13_0_Test {

    private ComparatorChain comparatorChain;

    @BeforeEach
    public void setUp() {
        comparatorChain = new ComparatorChain();
    }

    @Test
    public void testComparatorChainInitialization() {
        // Verify that the comparatorChain is initialized with an empty list
        List<Comparator<?>> comparatorList = getPrivateField(comparatorChain, "comparatorChain");
        assertNotNull(comparatorList);
        assertTrue(comparatorList.isEmpty(), "Comparator list should be empty");
        // Verify that the orderingBits is initialized as an empty BitSet
        BitSet orderingBits = getPrivateField(comparatorChain, "orderingBits");
        assertNotNull(orderingBits);
        assertTrue(orderingBits.isEmpty(), "Ordering bits should be empty");
        // Verify that isLocked is initialized to false
        boolean isLocked = getPrivateField(comparatorChain, "isLocked");
        assertFalse(isLocked, "isLocked should be false");
    }

    @SuppressWarnings("unchecked")
    private <T> T getPrivateField(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to access private field: " + fieldName);
            return null;
        }
    }
}
