package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;

class DynamicPointerFactory_createNodePointer_1_0_Test {

    private DynamicPointerFactory dynamicPointerFactory;

    @BeforeEach
    void setUp() {
        dynamicPointerFactory = new DynamicPointerFactory();
    }

    @Test
    void testCreateNodePointerWithDynamicBean() {
        // Arrange
        QName qName = new QName("prefix", "localName");
        TestBean testBean = new TestBean();
        Locale locale = Locale.ENGLISH;
        JXPathBeanInfo beanInfoMock = mock(JXPathBeanInfo.class);
        DynamicPropertyHandler handlerMock = mock(DynamicPropertyHandler.class);
        when(JXPathIntrospector.getBeanInfo(TestBean.class)).thenReturn(beanInfoMock);
        when(beanInfoMock.isDynamic()).thenReturn(true);
        when(ValueUtils.getDynamicPropertyHandler(any())).thenReturn(handlerMock);
        // Act
        NodePointer result = dynamicPointerFactory.createNodePointer(qName, testBean, locale);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof DynamicPointer);
    }

    @Test
    void testCreateNodePointerWithNonDynamicBean() {
        // Arrange
        QName qName = new QName("prefix", "localName");
        NonDynamicBean nonDynamicBean = new NonDynamicBean();
        Locale locale = Locale.ENGLISH;
        JXPathBeanInfo beanInfoMock = mock(JXPathBeanInfo.class);
        when(JXPathIntrospector.getBeanInfo(NonDynamicBean.class)).thenReturn(beanInfoMock);
        when(beanInfoMock.isDynamic()).thenReturn(false);
        // Act
        NodePointer result = dynamicPointerFactory.createNodePointer(qName, nonDynamicBean, locale);
        // Assert
        assertNull(result);
    }

    // Helper classes for testing
    public static class TestBean {
        // This class is treated as dynamic by the JXPathIntrospector
    }

    public static class NonDynamicBean {
        // This class is treated as non-dynamic by the JXPathIntrospector
    }
}
