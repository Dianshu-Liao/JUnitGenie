package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
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
        intList = new IntList();
    }

    @Test
    void testAddAtBeginning() {
        intList.add(0, 1);
        assertEquals(1, intList.get(0));
    }

    @Test
    void testAddAtEnd() {
        intList.add(0, 1);
        intList.add(1, 2);
        assertEquals(2, intList.get(1));
    }

    @Test
    void testAddAtMiddle() {
        intList.add(0, 1);
        intList.add(1, 3);
        intList.add(1, 2);
        assertEquals(2, intList.get(1));
        assertEquals(3, intList.get(2));
    }

    @Test
    void testAddToEmptyList() {
        intList.add(0, 1);
        assertEquals(1, intList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(2, 2));
    }

    @Test
    void testAddOutOfBounds() {
        intList.add(0, 1);
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(2, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> intList.add(-1, 2));
    }

    @Test
    void testAddAtFrontWhenFull() {
        for (int i = 0; i < 10; i++) {
            intList.add(i, i + 1);
        }
        // This should trigger growAtFront
        intList.add(0, 0);
        assertEquals(0, intList.get(0));
    }

    @Test
    void testAddAtEndWhenFull() {
        for (int i = 0; i < 10; i++) {
            intList.add(i, i + 1);
        }
        // This should trigger growAtEnd
        intList.add(10, 11);
        assertEquals(11, intList.get(10));
    }

    @Test
    void testAddAtMiddleWhenGrowRequired() {
        for (int i = 0; i < 10; i++) {
            intList.add(i, i + 1);
        }
        // This should trigger growForInsert
        intList.add(5, 99);
        assertEquals(99, intList.get(5));
    }

    private int get(IntList list, int index) {
        try {
            Method method = IntList.class.getDeclaredMethod("get", int.class);
            method.setAccessible(true);
            return (int) method.invoke(list, index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
