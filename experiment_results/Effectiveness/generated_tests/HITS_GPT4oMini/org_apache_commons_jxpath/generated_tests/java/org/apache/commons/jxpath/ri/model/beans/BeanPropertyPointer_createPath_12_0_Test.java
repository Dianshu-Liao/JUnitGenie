package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.beans.PropertyDescriptor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.util.ValueUtils;

class BeanPropertyPointer_createPath_12_0_Test {

    private BeanPropertyPointer beanPropertyPointer;

    private JXPathContext context;

    private JXPathBeanInfo beanInfo;

    @BeforeEach
    void setUp() {
        // Mock or create a JXPathBeanInfo instance as needed for testing
        beanInfo = new JXPathBeanInfo() {

            @Override
            public boolean isAtomic() {
                return false;
            }

            @Override
            public PropertyDescriptor[] getPropertyDescriptors() {
                return new PropertyDescriptor[0];
            }

            @Override
            public Class<?> getDynamicPropertyHandlerClass() {
                return null;
            }

            @Override
            public PropertyDescriptor getPropertyDescriptor(String propertyName) {
                return null;
            }

            @Override
            public boolean isDynamic() {
                // Implementing the required abstract method
                return false;
            }
        };
        beanPropertyPointer = new BeanPropertyPointer(null, beanInfo);
        context = JXPathContext.newContext(new Object());
    }

    @Test
    void testCreatePath_WhenImmediateNodeIsNull() {
        // Act
        NodePointer result = beanPropertyPointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertEquals(beanPropertyPointer, result);
    }

    @Test
    void testCreatePath_WhenImmediateNodeIsNotNull() {
        // Arrange
        beanPropertyPointer.setPropertyName("testProperty");
        // Simulate that immediate node is initialized
        beanPropertyPointer.getImmediateNode();
        // Act
        NodePointer result = beanPropertyPointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertEquals(beanPropertyPointer, result);
    }
}
