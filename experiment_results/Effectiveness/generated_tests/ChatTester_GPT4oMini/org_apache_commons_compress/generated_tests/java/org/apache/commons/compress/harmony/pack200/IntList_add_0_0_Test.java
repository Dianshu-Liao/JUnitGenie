package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
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
        // Initialize with a small capacity for testing
        intList = new IntList(2);
    }

    @Test
    public void testAddElementSuccessfully() {
        // Test adding an element
        assertTrue(intList.add(5));
        // Test adding another element
        assertTrue(intList.add(10));
    }

    @Test
    public void testAddElementWhenArrayIsFull() throws Exception {
        intList.add(1);
        intList.add(2);
        // Use reflection to access the private method growAtEnd
        Method growAtEndMethod = IntList.class.getDeclaredMethod("growAtEnd", int.class);
        growAtEndMethod.setAccessible(true);
        // Assuming the growAtEnd method works correctly, we will just add an element
        // Test adding an element after growing the array
        assertTrue(intList.add(3));
    }

    @Test
    public void testAddMultipleElements() {
        for (int i = 0; i < 10; i++) {
            // Test adding multiple elements
            assertTrue(intList.add(i));
        }
    }

    @Test
    public void testAddNegativeElement() {
        // Test adding a negative element
        assertTrue(intList.add(-1));
        // Test adding another negative element
        assertTrue(intList.add(-10));
    }

    @Test
    public void testAddZero() {
        // Test adding zero
        assertTrue(intList.add(0));
    }
}
