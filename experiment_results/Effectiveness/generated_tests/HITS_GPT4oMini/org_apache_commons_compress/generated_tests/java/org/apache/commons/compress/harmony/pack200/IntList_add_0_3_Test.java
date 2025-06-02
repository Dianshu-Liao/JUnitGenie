package org.apache.commons.compress.harmony.pack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class IntList_add_0_3_Test {

    private IntList intList;

    @BeforeEach
    void setUp() {
        intList = new IntList();
    }

    @Test
    void testAddSingleElement() {
        assertTrue(intList.add(5));
        assertEquals(1, getLastIndex());
        assertArrayEquals(new int[] { 5 }, getArrayContents());
    }

    @Test
    void testAddMultipleElements() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        assertEquals(3, getLastIndex());
        assertArrayEquals(new int[] { 1, 2, 3 }, getArrayContents());
    }

    @Test
    void testAddElementsExceedingInitialCapacity() {
        for (int i = 0; i < 15; i++) {
            intList.add(i);
        }
        assertEquals(15, getLastIndex());
        assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, getArrayContents());
    }

    private int getLastIndex() {
        // Use reflection or a helper method to get the lastIndex value
        return (int) getFieldValue("lastIndex");
    }

    private int[] getArrayContents() {
        // Use reflection or a helper method to get the array contents
        return (int[]) getFieldValue("array");
    }

    private Object getFieldValue(String fieldName) {
        try {
            java.lang.reflect.Field field = IntList.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(intList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
