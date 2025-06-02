package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.JXPathBeanInfo;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class BeanPointer_hashCode_6_0_Test {

    @Test
    public void testHashCode_NullName() {
        JXPathBeanInfo beanInfo = Mockito.mock(JXPathBeanInfo.class);
        BeanPointer beanPointer = new BeanPointer(null, new Object(), beanInfo, Locale.getDefault());
        assertEquals(0, beanPointer.hashCode());
    }

    @Test
    public void testHashCode_ValidName() {
        QName qName = new QName("testName");
        JXPathBeanInfo beanInfo = Mockito.mock(JXPathBeanInfo.class);
        BeanPointer beanPointer = new BeanPointer(qName, new Object(), beanInfo, Locale.getDefault());
        assertEquals(qName.hashCode(), beanPointer.hashCode());
    }

    @Test
    public void testHashCode_ValidNameWithPrefix() {
        QName qName = new QName("prefix", "localName");
        JXPathBeanInfo beanInfo = Mockito.mock(JXPathBeanInfo.class);
        BeanPointer beanPointer = new BeanPointer(qName, new Object(), beanInfo, Locale.getDefault());
        assertEquals(qName.hashCode(), beanPointer.hashCode());
    }
}
