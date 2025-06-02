package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.util.ValueUtils;

public class // Additional tests can be added here to cover other branches and methods in BeanPropertyPointer
BeanPropertyPointer_createPath_12_1_Test {

    private BeanPropertyPointer beanPropertyPointer;

    private JXPathBeanInfo mockBeanInfo;

    private JXPathContext mockContext;

    @BeforeEach
    public void setUp() {
        mockBeanInfo = mock(JXPathBeanInfo.class);
        mockContext = mock(JXPathContext.class);
        beanPropertyPointer = new BeanPropertyPointer(null, mockBeanInfo);
    }

    @Test
    public void testCreatePathWhenImmediateNodeIsNull() throws Exception {
        // Arrange
        Method getImmediateNodeMethod = BeanPropertyPointer.class.getDeclaredMethod("getImmediateNode");
        getImmediateNodeMethod.setAccessible(true);
        when(getImmediateNodeMethod.invoke(beanPropertyPointer)).thenReturn(null);
        // Act
        NodePointer result = beanPropertyPointer.createPath(mockContext);
        // Assert
        assertNotNull(result);
        // Additional assertions can be added here to verify the state of beanPropertyPointer if needed
    }

    @Test
    public void testCreatePathWhenImmediateNodeIsNotNull() throws Exception {
        // Arrange
        Method getImmediateNodeMethod = BeanPropertyPointer.class.getDeclaredMethod("getImmediateNode");
        getImmediateNodeMethod.setAccessible(true);
        when(getImmediateNodeMethod.invoke(beanPropertyPointer)).thenReturn(new Object());
        // Act
        NodePointer result = beanPropertyPointer.createPath(mockContext);
        // Assert
        assertNotNull(result);
        // Additional assertions can be added here to verify the state of beanPropertyPointer if needed
    }
}
