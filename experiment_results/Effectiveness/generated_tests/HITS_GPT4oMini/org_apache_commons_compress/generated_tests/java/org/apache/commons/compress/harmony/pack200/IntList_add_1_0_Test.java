package org.apache.commons.compress.harmony.pack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class IntList_add_1_0_Test {

    private IntList intList;

    @BeforeEach
    public void setUp() {
        intList = new IntList();
    }

    @Test
    public void testAddAtBeginning() {
        intList.add(0, 10);
        assertArrayEquals(new int[] { 10 }, intList.toArray());
    }

    @Test
    public void testAddAtEnd() {
        intList.add(0, 10);
        intList.add(1, 20);
        assertArrayEquals(new int[] { 10, 20 }, intList.toArray());
    }

    @Test
    public void testAddAtMiddle() {
        intList.add(0, 10);
        intList.add(1, 30);
        intList.add(1, 20);
        assertArrayEquals(new int[] { 10, 20, 30 }, intList.toArray());
    }

    @Test
    public void testAddAtZeroLocationWhenEmpty() {
        intList.add(0, 10);
        assertArrayEquals(new int[] { 10 }, intList.toArray());
    }

    @Test
    public void testAddAtZeroLocationWhenNotEmpty() {
        intList.add(0, 20);
        intList.add(0, 10);
        assertArrayEquals(new int[] { 10, 20 }, intList.toArray());
    }

    @Test
    public void testAddOutOfBoundsNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(-1, 10));
    }

    @Test
    public void testAddOutOfBoundsGreaterThanSize() {
        intList.add(0, 10);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(2, 20));
    }

    @Test
    public void testAddAtSizeLocation() {
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(2, 30);
        assertArrayEquals(new int[] { 10, 20, 30 }, intList.toArray());
    }

    @Test
    public void testAddAtSizeLocationWhenGrowing() {
        for (int i = 0; i < 10; i++) {
            intList.add(i, i + 1);
        }
        intList.add(10, 11);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }, intList.toArray());
    }

    @Test
    public void testAddAtMiddleWithGrowth() {
        for (int i = 0; i < 10; i++) {
            intList.add(i, i + 1);
        }
        intList.add(5, 99);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 99, 5, 6, 7, 8, 9, 10 }, intList.toArray());
    }
}
