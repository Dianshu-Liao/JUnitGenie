package org.apache.commons.jxpath;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BasicNodeSet_add_1_0_Test {

    private BasicNodeSet basicNodeSet;

    private NodeSet nodeSetMock;

    @BeforeEach
    void setUp() {
        basicNodeSet = new BasicNodeSet();
        nodeSetMock = Mockito.mock(NodeSet.class);
    }

    @Test
    void testAddPointersSuccessfully() {
        List<Pointer> pointersToAdd = new ArrayList<>();
        Pointer pointerMock = Mockito.mock(Pointer.class);
        // Mocking Node return
        when(pointerMock.getNode()).thenReturn(new Object());
        // Mocking Value return
        when(pointerMock.getValue()).thenReturn(new Object());
        pointersToAdd.add(pointerMock);
        when(nodeSetMock.getPointers()).thenReturn(pointersToAdd);
        // Invoke the method to test
        basicNodeSet.add(nodeSetMock);
        // Verify that pointers were added
        assertEquals(1, basicNodeSet.getPointers().size());
        assertSame(pointerMock, basicNodeSet.getPointers().get(0));
        verify(nodeSetMock, times(1)).getPointers();
    }

    @Test
    void testAddPointersAlreadyPresent() {
        List<Pointer> initialPointers = new ArrayList<>();
        Pointer existingPointer = Mockito.mock(Pointer.class);
        // Mocking Node return
        when(existingPointer.getNode()).thenReturn(new Object());
        // Mocking Value return
        when(existingPointer.getValue()).thenReturn(new Object());
        initialPointers.add(existingPointer);
        // Correcting the buggy line to implement the NodeSet interface correctly
        basicNodeSet.add(new NodeSet() {

            @Override
            public List<Pointer> getPointers() {
                return initialPointers;
            }

            @Override
            public List<Object> getValues() {
                // Implementing the missing method
                return Collections.emptyList();
            }

            @Override
            public List<Object> getNodes() {
                // Implementing the missing method to avoid compilation error
                return Collections.emptyList();
            }
        });
        List<Pointer> pointersToAdd = new ArrayList<>();
        pointersToAdd.add(existingPointer);
        when(nodeSetMock.getPointers()).thenReturn(pointersToAdd);
        // Invoke the method to test
        basicNodeSet.add(nodeSetMock);
        // Verify that pointers were not added again
        assertEquals(1, basicNodeSet.getPointers().size());
        assertSame(existingPointer, basicNodeSet.getPointers().get(0));
        verify(nodeSetMock, times(1)).getPointers();
    }

    @Test
    void testAddEmptyNodeSet() {
        when(nodeSetMock.getPointers()).thenReturn(new ArrayList<>());
        // Invoke the method to test
        basicNodeSet.add(nodeSetMock);
        // Verify that pointers list is still empty
        assertEquals(0, basicNodeSet.getPointers().size());
        verify(nodeSetMock, times(1)).getPointers();
    }

    private void invokePrivateMethod(BasicNodeSet instance, String methodName) {
        try {
            java.lang.reflect.Method method = BasicNodeSet.class.getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to invoke method: " + methodName);
        }
    }
}
