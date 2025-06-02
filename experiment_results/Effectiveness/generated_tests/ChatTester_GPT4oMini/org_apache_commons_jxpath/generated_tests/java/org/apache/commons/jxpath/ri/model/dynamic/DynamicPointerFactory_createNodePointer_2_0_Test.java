package org.apache.commons.jxpath.ri.model.dynamic;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicPointerFactory_createNodePointer_2_0_Test {

    private DynamicPointerFactory dynamicPointerFactory;

    @BeforeEach
    public void setUp() {
        dynamicPointerFactory = new DynamicPointerFactory();
    }

    @Test
    public void testCreateNodePointerWithNullBean() {
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("test");
        NodePointer result = dynamicPointerFactory.createNodePointer(parent, name, null);
        assertNotNull(result);
        assertTrue(result instanceof NullPointer);
        assertEquals(parent, ((NullPointer) result).getParent());
        assertEquals(name, ((NullPointer) result).getName());
    }

    @Test
    public void testCreateNodePointerWithDynamicBean() {
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("test");
        // Replace with a mock or actual dynamic bean
        Object bean = new Object();
        JXPathBeanInfo beanInfo = Mockito.mock(JXPathBeanInfo.class);
        DynamicPropertyHandler handler = Mockito.mock(DynamicPropertyHandler.class);
        when(beanInfo.isDynamic()).thenReturn(true);
        when(beanInfo.getDynamicPropertyHandlerClass()).thenReturn(DynamicPropertyHandler.class);
        when(ValueUtils.getDynamicPropertyHandler(DynamicPropertyHandler.class)).thenReturn(handler);
        when(JXPathIntrospector.getBeanInfo(bean.getClass())).thenReturn(beanInfo);
        NodePointer result = dynamicPointerFactory.createNodePointer(parent, name, bean);
        assertNotNull(result);
        assertTrue(result instanceof DynamicPointer);
        assertEquals(parent, ((DynamicPointer) result).getParent());
        assertEquals(name, ((DynamicPointer) result).getName());
        // Repairing the buggy line
        assertEquals(bean, ((DynamicPointer) result).getBaseValue());
        // Note: The DynamicPointer class does not have a getHandler() method, so this line was removed.
    }

    @Test
    public void testCreateNodePointerWithNonDynamicBean() {
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("test");
        // Replace with a mock or actual non-dynamic bean
        Object bean = new Object();
        JXPathBeanInfo beanInfo = Mockito.mock(JXPathBeanInfo.class);
        when(beanInfo.isDynamic()).thenReturn(false);
        when(JXPathIntrospector.getBeanInfo(bean.getClass())).thenReturn(beanInfo);
        NodePointer result = dynamicPointerFactory.createNodePointer(parent, name, bean);
        assertNull(result);
    }
}
