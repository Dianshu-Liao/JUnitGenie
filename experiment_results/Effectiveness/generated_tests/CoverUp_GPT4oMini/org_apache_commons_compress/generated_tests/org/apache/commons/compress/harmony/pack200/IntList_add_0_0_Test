package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class IntList_add_0_0_Test {

    private IntList intList;

    @BeforeEach
    void setUp() {
        intList = new IntList();
    }

    @Test
    void testAddElementWithInitialCapacity() {
        assertTrue(intList.add(5));
        assertTrue(intList.add(10));
        assertTrue(intList.add(15));
        // Validate the internal state
        assertEquals(3, getLastIndex(intList));
        assertEquals(5, getElementAt(intList, 0));
        assertEquals(10, getElementAt(intList, 1));
        assertEquals(15, getElementAt(intList, 2));
    }

    @Test
    void testAddElementAndGrowArray() {
        // Fill the array to trigger growth
        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }
        // Now add more elements to ensure it grows
        assertTrue(intList.add(10));
        assertTrue(intList.add(11));
        // Validate the internal state
        assertEquals(12, getLastIndex(intList));
        assertEquals(10, getElementAt(intList, 10));
        assertEquals(11, getElementAt(intList, 11));
    }

    // Reflection method to access private fields
    private int getLastIndex(IntList list) {
        try {
            Field field = IntList.class.getDeclaredField("lastIndex");
            field.setAccessible(true);
            return (int) field.get(list);
        } catch (Exception e) {
            fail("Failed to access lastIndex field");
            // unreachable
            return -1;
        }
    }

    // Reflection method to access elements in the internal array
    private int getElementAt(IntList list, int index) {
        try {
            Field field = IntList.class.getDeclaredField("array");
            field.setAccessible(true);
            int[] array = (int[]) field.get(list);
            return array[index];
        } catch (Exception e) {
            fail("Failed to access array field");
            // unreachable
            return -1;
        }
    }
}
