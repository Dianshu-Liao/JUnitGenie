// Test method
package org.apache.commons.jxpath.ri.model.beans;

import java.beans.PropertyDescriptor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BeanPropertyPointer_setPropertyIndex_4_0_Test {

    private BeanPropertyPointer beanPropertyPointer;

    private JXPathBeanInfo mockBeanInfo;

    // Define UNINITIALIZED
    private static final Object UNINITIALIZED = new Object();

    @BeforeEach
    public void setUp() {
        mockBeanInfo = Mockito.mock(JXPathBeanInfo.class);
        beanPropertyPointer = new BeanPropertyPointer(null, mockBeanInfo);
    }

    @Test
    public void testSetPropertyIndex_ChangesIndex() throws Exception {
        // Arrange
        int initialIndex = 0;
        int newIndex = 1;
        // Use reflection to set the initial property index
        setPrivateField(beanPropertyPointer, "propertyIndex", initialIndex);
        // Act
        beanPropertyPointer.setPropertyIndex(newIndex);
        // Assert
        assertNull(getPrivateField(beanPropertyPointer, "propertyName"));
        assertNull(getPrivateField(beanPropertyPointer, "propertyDescriptor"));
        assertEquals(UNINITIALIZED, getPrivateField(beanPropertyPointer, "baseValue"));
        assertEquals(UNINITIALIZED, getPrivateField(beanPropertyPointer, "value"));
    }

    @Test
    public void testSetPropertyIndex_NoChange() throws Exception {
        // Arrange
        int index = 1;
        // Use reflection to set the initial property index
        setPrivateField(beanPropertyPointer, "propertyIndex", index);
        // Act
        beanPropertyPointer.setPropertyIndex(index);
        // Assert
        assertNull(getPrivateField(beanPropertyPointer, "propertyName"));
        assertNull(getPrivateField(beanPropertyPointer, "propertyDescriptor"));
        assertEquals(UNINITIALIZED, getPrivateField(beanPropertyPointer, "baseValue"));
        assertEquals(UNINITIALIZED, getPrivateField(beanPropertyPointer, "value"));
    }

    @Test
    public void testSetPropertyIndex_ChangesPropertyIndex() throws Exception {
        // Arrange
        int initialIndex = 1;
        int newIndex = 2;
        // Use reflection to set the initial property index
        setPrivateField(beanPropertyPointer, "propertyIndex", initialIndex);
        // Act
        beanPropertyPointer.setPropertyIndex(newIndex);
        // Assert
        assertNull(getPrivateField(beanPropertyPointer, "propertyName"));
        assertNull(getPrivateField(beanPropertyPointer, "propertyDescriptor"));
        assertEquals(UNINITIALIZED, getPrivateField(beanPropertyPointer, "baseValue"));
        assertEquals(UNINITIALIZED, getPrivateField(beanPropertyPointer, "value"));
    }

    // Reflection helper methods
    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
