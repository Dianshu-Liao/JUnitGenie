package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;

public class DynamicPointerFactory_createNodePointer_1_0_Test {

    private DynamicPointerFactory dynamicPointerFactory;

    @BeforeEach
    public void setUp() {
        dynamicPointerFactory = new DynamicPointerFactory();
    }

    @Test
    public void testCreateNodePointer_WithDynamicBean() {
        // Arrange
        QName name = new QName("testName");
        Object bean = mock(DynamicBean.class);
        Locale locale = Locale.ENGLISH;
        JXPathBeanInfo beanInfo = mock(JXPathBeanInfo.class);
        DynamicPropertyHandler handler = mock(DynamicPropertyHandler.class);
        when(JXPathIntrospector.getBeanInfo(DynamicBean.class)).thenReturn(beanInfo);
        when(beanInfo.isDynamic()).thenReturn(true);
        when(ValueUtils.getDynamicPropertyHandler(any())).thenReturn(handler);
        // Act
        NodePointer result = dynamicPointerFactory.createNodePointer(name, bean, locale);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof DynamicPointer);
    }

    @Test
    public void testCreateNodePointer_WithNonDynamicBean() {
        // Arrange
        QName name = new QName("testName");
        Object bean = new NonDynamicBean();
        Locale locale = Locale.ENGLISH;
        JXPathBeanInfo beanInfo = mock(JXPathBeanInfo.class);
        when(JXPathIntrospector.getBeanInfo(NonDynamicBean.class)).thenReturn(beanInfo);
        when(beanInfo.isDynamic()).thenReturn(false);
        // Act
        NodePointer result = dynamicPointerFactory.createNodePointer(name, bean, locale);
        // Assert
        assertNull(result);
    }

    @Test
    public void testCreateNodePointer_WithNullBean() {
        // Arrange
        QName name = new QName("testName");
        Object bean = null;
        Locale locale = Locale.ENGLISH;
        // Act
        NodePointer result = dynamicPointerFactory.createNodePointer(name, bean, locale);
        // Assert
        assertNull(result);
    }

    // Mock classes for testing
    private static class DynamicBean {
        // This class would represent a dynamic bean.
    }

    private static class NonDynamicBean {
        // This class would represent a non-dynamic bean.
    }
}
