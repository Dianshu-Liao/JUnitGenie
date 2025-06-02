package org.apache.commons.collections4.iterators;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.TruePredicate;

class FilterIterator_setNextObject_7_4_Test {

    private FilterIterator<Integer> filterIterator;

    @BeforeEach
    void setUp() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        // Predicate to filter integers greater than 2
        filterIterator = new FilterIterator<>(iterator, x -> x > 2);
    }

    @Test
    void testSetNextObjectFound() throws Exception {
        Method method = FilterIterator.class.getDeclaredMethod("setNextObject");
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(filterIterator);
        assertTrue(result);
        Field nextObjectField = FilterIterator.class.getDeclaredField("nextObject");
        nextObjectField.setAccessible(true);
        assertEquals(3, nextObjectField.get(filterIterator));
        Field nextObjectSetField = FilterIterator.class.getDeclaredField("nextObjectSet");
        nextObjectSetField.setAccessible(true);
        assertTrue((Boolean) nextObjectSetField.get(filterIterator));
    }

    @Test
    void testSetNextObjectNotFound() throws Exception {
        List<Integer> list = Arrays.asList(1, 2);
        Iterator<Integer> iterator = list.iterator();
        // Update iterator to a new one with no valid elements
        filterIterator.setIterator(iterator);
        Method method = FilterIterator.class.getDeclaredMethod("setNextObject");
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(filterIterator);
        assertFalse(result);
        Field nextObjectField = FilterIterator.class.getDeclaredField("nextObject");
        nextObjectField.setAccessible(true);
        assertNull(nextObjectField.get(filterIterator));
        Field nextObjectSetField = FilterIterator.class.getDeclaredField("nextObjectSet");
        nextObjectSetField.setAccessible(true);
        assertFalse((Boolean) nextObjectSetField.get(filterIterator));
    }

    @Test
    void testSetNextObjectMultipleValid() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        // Resetting iterator to original
        filterIterator.setIterator(iterator);
        Method method = FilterIterator.class.getDeclaredMethod("setNextObject");
        method.setAccessible(true);
        boolean result1 = (Boolean) method.invoke(filterIterator);
        Field nextObjectField = FilterIterator.class.getDeclaredField("nextObject");
        nextObjectField.setAccessible(true);
        assertTrue(result1);
        assertEquals(3, nextObjectField.get(filterIterator));
        Field nextObjectSetField = FilterIterator.class.getDeclaredField("nextObjectSet");
        nextObjectSetField.setAccessible(true);
        assertTrue((Boolean) nextObjectSetField.get(filterIterator));
        // Call again to find next valid object
        boolean result2 = (Boolean) method.invoke(filterIterator);
        assertTrue(result2);
        // Now should find 4
        assertEquals(4, nextObjectField.get(filterIterator));
        assertTrue((Boolean) nextObjectSetField.get(filterIterator));
    }

    @Test
    void testSetNextObjectWithEmptyIterator() throws Exception {
        // Empty list
        List<Integer> list = Arrays.asList();
        Iterator<Integer> iterator = list.iterator();
        filterIterator.setIterator(iterator);
        Method method = FilterIterator.class.getDeclaredMethod("setNextObject");
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(filterIterator);
        assertFalse(result);
        Field nextObjectField = FilterIterator.class.getDeclaredField("nextObject");
        nextObjectField.setAccessible(true);
        assertNull(nextObjectField.get(filterIterator));
        Field nextObjectSetField = FilterIterator.class.getDeclaredField("nextObjectSet");
        nextObjectSetField.setAccessible(true);
        assertFalse((Boolean) nextObjectSetField.get(filterIterator));
    }
}
