package org.apache.commons.jxpath.ri.model.beans;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PropertyIterator_getLength_8_0_Test {

    private PropertyIterator propertyIterator;

    private PropertyOwnerPointer mockOwnerPointer;

    private NodePointer mockNodePointer;

    private PropertyPointer mockPropertyPointer;

    @BeforeEach
    public void setUp() {
        mockOwnerPointer = Mockito.mock(PropertyOwnerPointer.class);
        mockNodePointer = Mockito.mock(NodePointer.class);
        mockPropertyPointer = Mockito.mock(PropertyPointer.class);
        propertyIterator = new PropertyIterator(mockOwnerPointer, "testName", false, mockNodePointer);
        // Use reflection to set the private propertyNodePointer
        try {
            java.lang.reflect.Field field = PropertyIterator.class.getDeclaredField("propertyNodePointer");
            field.setAccessible(true);
            field.set(propertyIterator, mockPropertyPointer);
        } catch (Exception e) {
            fail("Reflection setup failed: " + e.getMessage());
        }
    }

    private int invokeGetLength() {
        try {
            Method method = PropertyIterator.class.getDeclaredMethod("getLength");
            method.setAccessible(true);
            return (int) method.invoke(propertyIterator);
        } catch (Exception e) {
            fail("Failed to invoke getLength: " + e.getMessage());
            // This will never be reached due to the fail() call
            return -1;
        }
    }

    @Test
    public void testLengthReturnsCorrectLength() {
        Mockito.when(mockPropertyPointer.getLength()).thenReturn(5);
        int length = invokeGetLength();
        assertEquals(5, length);
    }

    @Test
    public void testLengthHandlesException() {
        Mockito.doThrow(new RuntimeException("Test Exception")).when(mockPropertyPointer).getLength();
        Mockito.doNothing().when(mockPropertyPointer).handle(Mockito.any(Throwable.class));
        int length = invokeGetLength();
        assertEquals(0, length);
    }

    @Test
    public void testLengthWithNegativeLength() {
        Mockito.when(mockPropertyPointer.getLength()).thenReturn(-1);
        int length = invokeGetLength();
        assertEquals(-1, length);
    }

    @Test
    public void testLengthWithZeroLength() {
        Mockito.when(mockPropertyPointer.getLength()).thenReturn(0);
        int length = invokeGetLength();
        assertEquals(0, length);
    }

    @Test
    public void testLengthWithMultipleCalls() {
        Mockito.when(mockPropertyPointer.getLength()).thenReturn(3);
        assertEquals(3, invokeGetLength());
        assertEquals(3, invokeGetLength());
        assertEquals(3, invokeGetLength());
    }
}
