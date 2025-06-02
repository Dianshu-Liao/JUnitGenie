package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;

public class BeanPropertyPointer_createPath_12_0_Test {

    private BeanPropertyPointer beanPropertyPointer;

    private JXPathBeanInfo mockBeanInfo;

    private NodePointer mockParent;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        mockBeanInfo = mock(JXPathBeanInfo.class);
        beanPropertyPointer = new BeanPropertyPointer(mockParent, mockBeanInfo);
    }

    @Test
    public void testCreatePathWhenImmediateNodeIsNull() throws Exception {
        // Arrange
        JXPathContext mockContext = mock(JXPathContext.class);
        // Simulating the immediate node being null
        Mockito.when(beanPropertyPointer.getImmediateNode()).thenReturn(null);
        // Act
        NodePointer result = beanPropertyPointer.createPath(mockContext);
        // Assert
        assertEquals(beanPropertyPointer, result);
        // Accessing the private static field UNINITIALIZED using reflection
        java.lang.reflect.Field uninitializedField = BeanPropertyPointer.class.getDeclaredField("UNINITIALIZED");
        uninitializedField.setAccessible(true);
        Object uninitializedValue = uninitializedField.get(null);
        assertEquals(uninitializedValue, invokePrivateMethod("getBaseValue"));
        assertEquals(uninitializedValue, invokePrivateMethod("getValue"));
    }

    @Test
    public void testCreatePathWhenImmediateNodeIsNotNull() throws Exception {
        // Arrange
        JXPathContext mockContext = mock(JXPathContext.class);
        // Simulating the immediate node being not null
        Mockito.when(beanPropertyPointer.getImmediateNode()).thenReturn(new Object());
        // Act
        NodePointer result = beanPropertyPointer.createPath(mockContext);
        // Assert
        assertEquals(beanPropertyPointer, result);
        // Additional assertions can be added based on the expected behavior of super.createPath(context)
    }

    // Reflection method to invoke private methods
    private Object invokePrivateMethod(String methodName, Class<?>... parameterTypes) throws Exception {
        java.lang.reflect.Method method = BeanPropertyPointer.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(beanPropertyPointer);
    }
}
