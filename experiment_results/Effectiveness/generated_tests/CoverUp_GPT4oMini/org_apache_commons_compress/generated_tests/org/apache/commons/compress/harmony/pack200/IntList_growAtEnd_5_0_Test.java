package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IntList_growAtEnd_5_0_Test {

    private IntList intList;

    @BeforeEach
    public void setUp() {
        // Initialize with a capacity of 10
        intList = new IntList(10);
    }

    @Test
    public void testGrowAtEndWhenArrayIsEmpty() throws Exception {
        invokeGrowAtEnd(5);
        assertArrayEquals(new int[12], getArray());
    }

    @Test
    public void testGrowAtEndWhenArrayHasElements() throws Exception {
        // This will not grow yet
        invokeGrowAtEnd(5);
        assertArrayEquals(new int[10], getArray());
        // Simulate adding elements to the list
        intList = new IntList(10);
        // This should trigger the grow
        invokeGrowAtEnd(15);
        assertTrue(getArray().length >= 15);
    }

    @Test
    public void testGrowAtEndWithExactCapacity() throws Exception {
        intList = new IntList(10);
        // Should grow
        invokeGrowAtEnd(10);
        assertTrue(getArray().length >= 12);
    }

    @Test
    public void testGrowAtEndWithLessThanHalfCapacity() throws Exception {
        intList = new IntList(10);
        // Should grow
        invokeGrowAtEnd(3);
        assertTrue(getArray().length >= 12);
    }

    @Test
    public void testGrowAtEndWithMoreThanHalfCapacity() throws Exception {
        intList = new IntList(10);
        // Should grow
        invokeGrowAtEnd(8);
        assertTrue(getArray().length >= 12);
    }

    private void invokeGrowAtEnd(int required) throws Exception {
        Method method = IntList.class.getDeclaredMethod("growAtEnd", int.class);
        method.setAccessible(true);
        method.invoke(intList, required);
    }

    private int[] getArray() throws Exception {
        Field field = IntList.class.getDeclaredField("array");
        field.setAccessible(true);
        return (int[]) field.get(intList);
    }
}
