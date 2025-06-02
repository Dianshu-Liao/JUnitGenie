package org.apache.commons.jxpath.ri.model.beans;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class BeanPropertyPointer_setPropertyIndex_4_0_Test {

    private BeanPropertyPointer beanPropertyPointer;

    private NodePointer mockNodePointer;

    private JXPathBeanInfo mockBeanInfo;

    private static final Object UNINITIALIZED = new Object();

    @BeforeEach
    public void setUp() {
        mockNodePointer = mock(NodePointer.class);
        mockBeanInfo = mock(JXPathBeanInfo.class);
        beanPropertyPointer = new BeanPropertyPointer(mockNodePointer, mockBeanInfo);
    }

    @Test
    public void testSetPropertyIndex_ChangeIndex() {
        int initialIndex = 0;
        beanPropertyPointer.setPropertyIndex(initialIndex);
        int newIndex = 1;
        beanPropertyPointer.setPropertyIndex(newIndex);
        assertNotEquals(initialIndex, beanPropertyPointer.getPropertyIndex());
        assertEquals(newIndex, beanPropertyPointer.getPropertyIndex());
    }

    @Test
    public void testSetPropertyIndex_SameIndex() {
        int index = 2;
        beanPropertyPointer.setPropertyIndex(index);
        beanPropertyPointer.setPropertyIndex(index);
        assertEquals(index, beanPropertyPointer.getPropertyIndex());
    }

    @Test
    public void testSetPropertyIndex_InitialState() {
        // Verify initial state before setting any index
        assertEquals(UNINITIALIZED, beanPropertyPointer.getBaseValue());
        assertEquals(UNINITIALIZED, beanPropertyPointer.getValue());
        beanPropertyPointer.setPropertyIndex(0);
        assertEquals(UNINITIALIZED, beanPropertyPointer.getBaseValue());
        assertEquals(UNINITIALIZED, beanPropertyPointer.getValue());
    }
}
