package org.apache.commons.collections4.multiset;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiSet.Entry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;

class AbstractMapMultiSet_toArray_16_0_Test extends AbstractMapMultiSet<String> {

    private Map<String, MutableInteger> mockMap;

    public AbstractMapMultiSet_toArray_16_0_Test() {
        super();
    }

    @BeforeEach
    void setUp() {
        mockMap = new HashMap<>();
        setMap(mockMap);
    }

    @Test
    void testToArray_EmptyMap() {
        // Arrange
        // No elements added, size will be 0
        // Act
        Object[] result = toArray();
        // Assert
        assertArrayEquals(new Object[0], result);
    }

    @Test
    void testToArray_SingleElement() {
        // Arrange
        MutableInteger count = new MutableInteger(1);
        mockMap.put("A", count);
        // Act
        Object[] result = toArray();
        // Assert
        assertArrayEquals(new Object[] { "A" }, result);
    }

    @Test
    void testToArray_MultipleElements() {
        // Arrange
        MutableInteger countA = new MutableInteger(2);
        MutableInteger countB = new MutableInteger(3);
        mockMap.put("A", countA);
        mockMap.put("B", countB);
        // Act
        Object[] result = toArray();
        // Assert
        assertArrayEquals(new Object[] { "A", "A", "B", "B", "B" }, result);
    }

    @Test
    void testToArray_ConcurrentModification() {
        // Arrange
        MutableInteger countA = new MutableInteger(2);
        mockMap.put("A", countA);
        // Simulate concurrent modification by adding another element
        mockMap.put("B", new MutableInteger(1));
        // Act
        Object[] result = toArray();
        // Assert
        assertArrayEquals(new Object[] { "A", "A" }, result);
    }

    @Test
    void testToArray_NegativeSize() {
        // Arrange
        // Simulate a negative size scenario by not adding any elements
        // Act
        Object[] result = toArray();
        // Assert
        assertArrayEquals(new Object[0], result);
    }
}
