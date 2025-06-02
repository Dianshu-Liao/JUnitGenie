// Test method
package org.apache.commons.jxpath;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BasicNodeSet_add_0_0_Test {

    private BasicNodeSet basicNodeSet;

    @BeforeEach
    void setUp() {
        basicNodeSet = new BasicNodeSet();
    }

    @Test
    void testAddPointerNewPointer() throws Exception {
        Pointer pointer = mock(Pointer.class);
        invokeAdd(pointer);
        assertTrue(basicNodeSet.getPointers().contains(pointer));
    }

    @Test
    void testAddPointerExistingPointer() throws Exception {
        Pointer pointer = mock(Pointer.class);
        // Add the pointer first
        invokeAdd(pointer);
        // Try to add the same pointer again
        invokeAdd(pointer);
        assertEquals(1, basicNodeSet.getPointers().size());
    }

    @Test
    void testAddNullPointer() throws Exception {
        Pointer pointer = null;
        // Corrected line: The method does not return a boolean, so we just invoke it without capturing a boolean result
        invokeAdd(pointer);
        assertFalse(basicNodeSet.getPointers().contains(pointer));
        assertEquals(0, basicNodeSet.getPointers().size());
    }

    @Test
    void testAddMultiplePointers() throws Exception {
        Pointer pointer1 = mock(Pointer.class);
        Pointer pointer2 = mock(Pointer.class);
        invokeAdd(pointer1);
        invokeAdd(pointer2);
        assertTrue(basicNodeSet.getPointers().contains(pointer1));
        assertTrue(basicNodeSet.getPointers().contains(pointer2));
        assertEquals(2, basicNodeSet.getPointers().size());
    }

    private void invokeAdd(Pointer pointer) throws Exception {
        Method method = BasicNodeSet.class.getDeclaredMethod("add", Pointer.class);
        method.setAccessible(true);
        method.invoke(basicNodeSet, pointer);
    }
}
