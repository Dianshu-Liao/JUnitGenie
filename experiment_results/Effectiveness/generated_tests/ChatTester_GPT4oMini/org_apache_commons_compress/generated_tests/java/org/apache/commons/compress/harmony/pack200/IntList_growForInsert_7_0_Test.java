package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class IntList_growForInsert_7_0_Test {

    private IntList intList;

    @BeforeEach
    void setUp() {
        // Initialize with a capacity
        intList = new IntList(10);
    }

    @Test
    void testGrowForInsert() throws Exception {
        // Using reflection to access the private method
        Method growForInsertMethod = IntList.class.getDeclaredMethod("growForInsert", int.class, int.class);
        growForInsertMethod.setAccessible(true);
        // Attempt to grow for an insert at location 0 with a requirement of 5
        growForInsertMethod.invoke(intList, 0, 5);
        Field arrayField = IntList.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        int[] array = (int[]) arrayField.get(intList);
        Field firstIndexField = IntList.class.getDeclaredField("firstIndex");
        firstIndexField.setAccessible(true);
        int firstIndex = (int) firstIndexField.get(intList);
        Field lastIndexField = IntList.class.getDeclaredField("lastIndex");
        lastIndexField.setAccessible(true);
        int lastIndex = (int) lastIndexField.get(intList);
        // Assertions to verify the state
        assertNotNull(array);
        // Check if lastIndex is updated correctly
        assertEquals(12, lastIndex);
        // Check if firstIndex is updated correctly
        assertEquals(2, firstIndex);
        // Check if the new array length is as expected
        assertEquals(12, array.length);
    }

    @Test
    void testGrowForInsertWithLargerRequirement() throws Exception {
        Method growForInsertMethod = IntList.class.getDeclaredMethod("growForInsert", int.class, int.class);
        growForInsertMethod.setAccessible(true);
        growForInsertMethod.invoke(intList, 0, 20);
        Field arrayField = IntList.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        int[] array = (int[]) arrayField.get(intList);
        Field firstIndexField = IntList.class.getDeclaredField("firstIndex");
        firstIndexField.setAccessible(true);
        int firstIndex = (int) firstIndexField.get(intList);
        Field lastIndexField = IntList.class.getDeclaredField("lastIndex");
        lastIndexField.setAccessible(true);
        int lastIndex = (int) lastIndexField.get(intList);
        assertNotNull(array);
        // Check if lastIndex is updated correctly
        assertEquals(20, lastIndex);
        // Check if firstIndex is unchanged
        assertEquals(0, firstIndex);
        // Check if the new array length is as expected
        assertEquals(20, array.length);
    }

    @Test
    void testGrowForInsertWithMinimumIncrement() throws Exception {
        Method growForInsertMethod = IntList.class.getDeclaredMethod("growForInsert", int.class, int.class);
        growForInsertMethod.setAccessible(true);
        growForInsertMethod.invoke(intList, 0, 1);
        Field arrayField = IntList.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        int[] array = (int[]) arrayField.get(intList);
        Field firstIndexField = IntList.class.getDeclaredField("firstIndex");
        firstIndexField.setAccessible(true);
        int firstIndex = (int) firstIndexField.get(intList);
        Field lastIndexField = IntList.class.getDeclaredField("lastIndex");
        lastIndexField.setAccessible(true);
        int lastIndex = (int) lastIndexField.get(intList);
        assertNotNull(array);
        // Check if lastIndex is updated correctly
        assertEquals(12, lastIndex);
        // Check if firstIndex is updated correctly
        assertEquals(2, firstIndex);
        // Check if the new array length is as expected
        assertEquals(12, array.length);
    }
}
