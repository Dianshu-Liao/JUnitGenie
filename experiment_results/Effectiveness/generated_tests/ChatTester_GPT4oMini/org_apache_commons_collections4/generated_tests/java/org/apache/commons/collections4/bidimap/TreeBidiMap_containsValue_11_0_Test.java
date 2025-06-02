package org.apache.commons.collections4.bidimap;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.KEY;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.VALUE;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

public class TreeBidiMap_containsValue_11_0_Test {

    private TreeBidiMap<String, String> treeBidiMap;

    @BeforeEach
    public void setUp() {
        treeBidiMap = new TreeBidiMap<>(new HashMap<>());
    }

    @Test
    public void testContainsValue_WhenValueExists_ReturnsTrue() {
        // Arrange
        treeBidiMap.put("key1", "value1");
        // Act
        boolean result = treeBidiMap.containsValue("value1");
        // Assert
        assertTrue(result);
    }

    @Test
    public void testContainsValue_WhenValueDoesNotExist_ReturnsFalse() {
        // Arrange
        treeBidiMap.put("key1", "value1");
        // Act
        boolean result = treeBidiMap.containsValue("value2");
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsValue_WhenValueIsNull_ReturnsFalse() {
        // Arrange
        treeBidiMap.put("key1", "value1");
        // Act
        boolean result = treeBidiMap.containsValue(null);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsValue_WhenMapIsEmpty_ReturnsFalse() {
        // Act
        boolean result = treeBidiMap.containsValue("value1");
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsValue_WithNullValue_ThrowsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            treeBidiMap.containsValue(null);
        });
    }

    // Reflection test for private method checkValue
    @Test
    public void testCheckValue_WithNullValue_ThrowsException() throws Exception {
        // Arrange
        Method checkValueMethod = TreeBidiMap.class.getDeclaredMethod("checkValue", Object.class);
        checkValueMethod.setAccessible(true);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            checkValueMethod.invoke(treeBidiMap, null);
        });
    }

    // Reflection test for private method lookupValue
    @Test
    public void testLookupValue_WhenValueExists_ReturnsKey() throws Exception {
        // Arrange
        Method lookupValueMethod = TreeBidiMap.class.getDeclaredMethod("lookupValue", Object.class);
        lookupValueMethod.setAccessible(true);
        treeBidiMap.put("key1", "value1");
        // Act
        Object result = lookupValueMethod.invoke(treeBidiMap, "value1");
        // Assert
        assertNotNull(result);
        assertEquals("key1", result);
    }

    @Test
    public void testLookupValue_WhenValueDoesNotExist_ReturnsNull() throws Exception {
        // Arrange
        Method lookupValueMethod = TreeBidiMap.class.getDeclaredMethod("lookupValue", Object.class);
        lookupValueMethod.setAccessible(true);
        treeBidiMap.put("key1", "value1");
        // Act
        Object result = lookupValueMethod.invoke(treeBidiMap, "value2");
        // Assert
        assertNull(result);
    }
}
