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

public class ComparatorChain_ComparatorChain_17_1_Test {

    private ComparatorChain<String> comparatorChain;

    @BeforeEach
    public void setUp() {
        // No setup required for this test
    }

    @Test
    public void testComparatorChainConstructorWithValidInputs() {
        // Arrange
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        comparators.add(Comparator.reverseOrder());
        BitSet bits = new BitSet();
        // Set the second comparator to reverse order
        bits.set(1);
        // Act
        comparatorChain = new ComparatorChain<>(comparators, bits);
        // Assert
        assertNotNull(comparatorChain);
        assertEquals(2, comparatorChain.size());
        assertEquals(comparators, getPrivateField(comparatorChain, "comparatorChain"));
        assertEquals(bits, getPrivateField(comparatorChain, "orderingBits"));
    }

    @Test
    public void testComparatorChainConstructorWithEmptyList() {
        // Arrange
        List<Comparator<String>> comparators = new ArrayList<>();
        BitSet bits = new BitSet();
        // Act
        comparatorChain = new ComparatorChain<>(comparators, bits);
        // Assert
        assertNotNull(comparatorChain);
        assertEquals(0, comparatorChain.size());
        assertEquals(comparators, getPrivateField(comparatorChain, "comparatorChain"));
        assertEquals(bits, getPrivateField(comparatorChain, "orderingBits"));
    }

    @Test
    public void testComparatorChainConstructorWithNullList() {
        // Arrange
        BitSet bits = new BitSet();
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            comparatorChain = new ComparatorChain<>(null, bits);
        });
        assertEquals("list cannot be null", exception.getMessage());
    }

    @Test
    public void testComparatorChainConstructorWithNullBitSet() {
        // Arrange
        List<Comparator<String>> comparators = new ArrayList<>();
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            comparatorChain = new ComparatorChain<>(comparators, null);
        });
        assertEquals("bits cannot be null", exception.getMessage());
    }

    // Reflection method to access private fields
    @SuppressWarnings("unchecked")
    private <T> T getPrivateField(Object obj, String fieldName) {
        try {
            // Fixed line: changed 'var' to 'java.lang.reflect.Field'
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
