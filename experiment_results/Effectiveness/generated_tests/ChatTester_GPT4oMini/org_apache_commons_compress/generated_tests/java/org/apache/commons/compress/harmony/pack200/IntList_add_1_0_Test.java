package org.apache.commons.compress.harmony.pack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class IntList_add_1_0_Test {

    private IntList intList;

    @BeforeEach
    void setUp() {
        intList = new IntList(5);
    }

    @Test
    void testAddAtBeginning() {
        intList.add(0, 10);
        assertEquals(10, intList.get(0));
    }

    @Test
    void testAddAtEnd() {
        intList.add(0, 10);
        intList.add(1, 20);
        assertEquals(20, intList.get(1));
    }

    @Test
    void testAddInMiddle() {
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(1, 15);
        assertEquals(15, intList.get(1));
        assertEquals(20, intList.get(2));
    }

    @Test
    void testAddToEmptyList() {
        IntList emptyList = new IntList(0);
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(1, 10));
        emptyList.add(0, 10);
        assertEquals(10, emptyList.get(0));
    }

    @Test
    void testAddOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(1, 10));
    }

    @Test
    void testAddBeyondCapacity() {
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(2, 30);
        intList.add(3, 40);
        intList.add(4, 50);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(5, 60));
    }

    // Reflection to test private methods if necessary
    // Example: testing growAtFront, growAtEnd, or growForInsert
    private void invokePrivateMethod(String methodName, Object... args) throws Exception {
        java.lang.reflect.Method method = IntList.class.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(intList, args);
    }
}
