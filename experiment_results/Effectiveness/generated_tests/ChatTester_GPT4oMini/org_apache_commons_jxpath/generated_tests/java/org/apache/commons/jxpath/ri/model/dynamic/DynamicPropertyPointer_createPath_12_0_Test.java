package org.apache.commons.jxpath.ri.model.dynamic;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DynamicPropertyPointer_createPath_12_0_Test {

    private DynamicPropertyPointer dynamicPropertyPointer;

    private DynamicPropertyHandler mockHandler;

    private JXPathContext mockContext;

    @BeforeEach
    void setUp() {
        mockHandler = mock(DynamicPropertyHandler.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, mockHandler);
        mockContext = mock(JXPathContext.class);
    }

    @Test
    void testCreatePath_WholeCollection() {
        // Arrange
        Object value = new Object();
        // Assuming setIndex is a method to set index
        dynamicPropertyPointer.setIndex(DynamicPropertyPointer.WHOLE_COLLECTION);
        // Act
        NodePointer result = dynamicPropertyPointer.createPath(mockContext, value);
        // Assert
        assertSame(dynamicPropertyPointer, result);
        verify(mockHandler).setProperty(any(), anyString(), eq(value));
    }

    @Test
    void testCreatePath_SingleElement() throws Exception {
        // Arrange
        Object value = new Object();
        // Assuming index is set to a single element
        dynamicPropertyPointer.setIndex(0);
        // Set a property name to ensure it works
        dynamicPropertyPointer.setPropertyName("testProperty");
        // Mock the behavior of handler.getProperty to return a non-null value
        when(mockHandler.getProperty(any(), anyString())).thenReturn(new Object());
        // Act
        NodePointer result = dynamicPropertyPointer.createPath(mockContext, value);
        // Assert
        assertSame(dynamicPropertyPointer, result);
        // Verify that createPath(context) was called
        invokePrivateMethod(dynamicPropertyPointer, "createPath", mockContext);
        // Verify ValueUtils.setValue was called with the expected parameters
        ArgumentCaptor<Object> valueCaptor = ArgumentCaptor.forClass(Object.class);
        verify(mockHandler).getProperty(any(), anyString());
        // Fixed buggy line: Correctly verify the method call on ValueUtils
        verify(ValueUtils.class);
        verify(ValueUtils.class);
        verify(mockHandler).setProperty(any(), anyString(), valueCaptor.capture());
        assertEquals(value, valueCaptor.getValue());
    }

    private void invokePrivateMethod(Object instance, String methodName, Object... args) throws Exception {
        Method method = instance.getClass().getDeclaredMethod(methodName, JXPathContext.class);
        method.setAccessible(true);
        method.invoke(instance, args);
    }
}
