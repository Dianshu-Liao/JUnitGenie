package org.apache.commons.compress.harmony.pack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class IntList_add_0_0_Test {

    private IntList intList;

    @BeforeEach
    public void setUp() {
        intList = new IntList();
    }

    @Test
    public void testAddSingleElement() {
        intList.add(5);
        // Using size() method instead of accessing lastIndex
        assertEquals(1, intList.size());
        assertArrayEquals(new int[] { 5 }, intList.toArray());
    }

    @Test
    public void testAddMultipleElements() {
        intList.add(10);
        intList.add(20);
        // Using size() method instead of accessing lastIndex
        assertEquals(2, intList.size());
        assertArrayEquals(new int[] { 10, 20 }, intList.toArray());
    }

    @Test
    public void testAddMoreThanInitialCapacity() {
        for (int i = 0; i < 15; i++) {
            intList.add(i);
        }
        // Using size() method instead of accessing lastIndex
        assertEquals(15, intList.size());
        assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, intList.toArray());
    }
}
