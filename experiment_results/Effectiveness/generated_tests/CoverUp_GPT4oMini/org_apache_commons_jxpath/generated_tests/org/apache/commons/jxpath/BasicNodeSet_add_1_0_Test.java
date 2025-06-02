package org.apache.commons.jxpath;

import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;

public class BasicNodeSet_add_1_0_Test {

    private BasicNodeSet basicNodeSet;

    private NodeSet mockNodeSet;

    @BeforeEach
    public void setUp() {
        basicNodeSet = new BasicNodeSet();
        mockNodeSet = Mockito.mock(NodeSet.class);
    }

    @Test
    public void testAddWithEmptyNodeSet() {
        when(mockNodeSet.getPointers()).thenReturn(new ArrayList<>());
        basicNodeSet.add(mockNodeSet);
        assertEquals(0, basicNodeSet.getPointers().size());
    }

    @Test
    public void testAddWithNonEmptyNodeSet() {
        Pointer mockPointer = Mockito.mock(Pointer.class);
        List<Pointer> pointers = new ArrayList<>();
        pointers.add(mockPointer);
        when(mockNodeSet.getPointers()).thenReturn(pointers);
        basicNodeSet.add(mockNodeSet);
        assertEquals(1, basicNodeSet.getPointers().size());
        assertTrue(basicNodeSet.getPointers().contains(mockPointer));
    }

    @Test
    public void testAddWithSamePointers() {
        Pointer mockPointer = Mockito.mock(Pointer.class);
        List<Pointer> pointers = new ArrayList<>();
        pointers.add(mockPointer);
        when(mockNodeSet.getPointers()).thenReturn(pointers);
        basicNodeSet.add(mockNodeSet);
        int sizeAfterFirstAdd = basicNodeSet.getPointers().size();
        // Add the same pointers again
        basicNodeSet.add(mockNodeSet);
        assertEquals(sizeAfterFirstAdd, basicNodeSet.getPointers().size());
    }

    @Test
    public void testAddWithDifferentPointers() {
        Pointer mockPointer1 = Mockito.mock(Pointer.class);
        Pointer mockPointer2 = Mockito.mock(Pointer.class);
        List<Pointer> pointers = new ArrayList<>();
        pointers.add(mockPointer1);
        pointers.add(mockPointer2);
        when(mockNodeSet.getPointers()).thenReturn(pointers);
        basicNodeSet.add(mockNodeSet);
        assertEquals(2, basicNodeSet.getPointers().size());
        assertTrue(basicNodeSet.getPointers().contains(mockPointer1));
        assertTrue(basicNodeSet.getPointers().contains(mockPointer2));
    }

    @Test
    public void testClearCacheLists() throws Exception {
        // Use reflection to invoke the private method clearCacheLists
        java.lang.reflect.Method method = BasicNodeSet.class.getDeclaredMethod("clearCacheLists");
        method.setAccessible(true);
        // Call the method
        method.invoke(basicNodeSet);
        // Validate that the cache lists are cleared
        // Ensure pointers are still accessible
        assertNotNull(basicNodeSet.getPointers());
        // Nodes should be null
        assertNull(basicNodeSet.getNodes());
        // Values should be null
        assertNull(basicNodeSet.getValues());
    }
}
