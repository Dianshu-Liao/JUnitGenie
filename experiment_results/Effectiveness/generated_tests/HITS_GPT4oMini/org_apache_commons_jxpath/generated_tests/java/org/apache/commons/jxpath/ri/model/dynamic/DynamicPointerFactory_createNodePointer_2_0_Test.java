package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DynamicPointerFactory_createNodePointer_2_0_Test {

    @Test
    public void testCreateNodePointer_NullBean() {
        DynamicPointerFactory factory = new DynamicPointerFactory();
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        NodePointer result = factory.createNodePointer(parent, name, null);
        assertNotNull(result);
        assertTrue(result instanceof NullPointer);
    }

    @Test
    public void testCreateNodePointer_DynamicBean() {
        DynamicPointerFactory factory = new DynamicPointerFactory();
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        // Assuming DynamicBean is a valid dynamic bean class
        DynamicBean dynamicBean = new DynamicBean();
        // Mock JXPathIntrospector to return a dynamic bean info
        JXPathBeanInfo beanInfo = mock(JXPathBeanInfo.class);
        when(beanInfo.isDynamic()).thenReturn(true);
        when(JXPathIntrospector.getBeanInfo(dynamicBean.getClass())).thenReturn(beanInfo);
        // Mock ValueUtils to return a dynamic property handler
        DynamicPropertyHandler handler = mock(DynamicPropertyHandler.class);
        when(ValueUtils.getDynamicPropertyHandler(dynamicBean.getClass())).thenReturn(handler);
        NodePointer result = factory.createNodePointer(parent, name, dynamicBean);
        assertNotNull(result);
        assertTrue(result instanceof DynamicPointer);
    }

    @Test
    public void testCreateNodePointer_NonDynamicBean() {
        DynamicPointerFactory factory = new DynamicPointerFactory();
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        // Assuming NonDynamicBean is a valid non-dynamic bean class
        NonDynamicBean nonDynamicBean = new NonDynamicBean();
        // Mock JXPathIntrospector to return a non-dynamic bean info
        JXPathBeanInfo beanInfo = mock(JXPathBeanInfo.class);
        when(beanInfo.isDynamic()).thenReturn(false);
        when(JXPathIntrospector.getBeanInfo(nonDynamicBean.getClass())).thenReturn(beanInfo);
        NodePointer result = factory.createNodePointer(parent, name, nonDynamicBean);
        assertNull(result);
    }

    // Mock dynamic bean class for testing
    public static class DynamicBean {
        // Simulate dynamic properties
    }

    // Mock non-dynamic bean class for testing
    public static class NonDynamicBean {
        // Simulate non-dynamic properties
    }
}
