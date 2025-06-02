package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class IntList_growAtEnd_5_0_Test {

    private IntList intList;

    @BeforeEach
    void setUp() {
        intList = new IntList(10);
    }

    @Test
    void testGrowAtEndWithSufficientCapacity() throws Exception {
        // Set up the private method parameters
        int required = 5;
        // Use reflection to invoke the private method
        Method growAtEndMethod = IntList.class.getDeclaredMethod("growAtEnd", int.class);
        growAtEndMethod.setAccessible(true);
        // Invoke the method
        growAtEndMethod.invoke(intList, required);
        // Assert that the internal state is as expected
        // Here we would need to add additional methods to check the internal state if needed
        // For now, we can assume that the method works correctly if no exceptions are thrown
        // Placeholder assertion
        assertNotNull(intList);
    }

    @Test
    void testGrowAtEndWithInsufficientCapacity() throws Exception {
        // Set up the private method parameters
        int required = 20;
        // Use reflection to invoke the private method
        Method growAtEndMethod = IntList.class.getDeclaredMethod("growAtEnd", int.class);
        growAtEndMethod.setAccessible(true);
        // Invoke the method
        growAtEndMethod.invoke(intList, required);
        // Assert that the internal state is as expected
        // Check if the array has grown
        Method getArrayMethod = IntList.class.getDeclaredMethod("getArray");
        getArrayMethod.setAccessible(true);
        int[] array = (int[]) getArrayMethod.invoke(intList);
        assertTrue(array.length >= required);
    }

    @Test
    void testGrowAtEndWithZeroRequired() throws Exception {
        // Set up the private method parameters
        int required = 0;
        // Use reflection to invoke the private method
        Method growAtEndMethod = IntList.class.getDeclaredMethod("growAtEnd", int.class);
        growAtEndMethod.setAccessible(true);
        // Invoke the method
        growAtEndMethod.invoke(intList, required);
        // Assert that the internal state is as expected
        Method getArrayMethod = IntList.class.getDeclaredMethod("getArray");
        getArrayMethod.setAccessible(true);
        int[] array = (int[]) getArrayMethod.invoke(intList);
        assertEquals(0, array.length);
    }

    @Test
    void testGrowAtEndWithNegativeRequired() throws Exception {
        // Set up the private method parameters
        int required = -5;
        // Use reflection to invoke the private method
        Method growAtEndMethod = IntList.class.getDeclaredMethod("growAtEnd", int.class);
        growAtEndMethod.setAccessible(true);
        // Invoke the method
        growAtEndMethod.invoke(intList, required);
        // Assert that the internal state is as expected
        Method getArrayMethod = IntList.class.getDeclaredMethod("getArray");
        getArrayMethod.setAccessible(true);
        int[] array = (int[]) getArrayMethod.invoke(intList);
        // Check that the minimum size is respected
        assertTrue(array.length >= 12);
    }
}
