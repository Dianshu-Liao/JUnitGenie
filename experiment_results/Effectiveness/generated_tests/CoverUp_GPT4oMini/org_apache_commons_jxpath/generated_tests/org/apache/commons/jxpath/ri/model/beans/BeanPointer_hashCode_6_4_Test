package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathBeanInfo;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.beans.BeanPointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BeanPointer_hashCode_6_4_Test {

    private BeanPointer beanPointerWithNullName;

    private BeanPointer beanPointerWithValidName;

    private QName validQName;

    @BeforeEach
    public void setUp() {
        // Create a QName instance for testing
        validQName = new QName("prefix", "localName");
        // Create a mock JXPathBeanInfo instance
        JXPathBeanInfo mockBeanInfo = mock(JXPathBeanInfo.class);
        // Create BeanPointer instances using the correct constructor
        beanPointerWithNullName = new BeanPointer(validQName, null, mockBeanInfo, null);
        beanPointerWithValidName = new BeanPointer(null, validQName, new Object(), mockBeanInfo);
    }

    @Test
    public void testHashCodeWithNullName() {
        // When name is null, hashCode should return 0
        assertEquals(0, beanPointerWithNullName.hashCode());
    }

    @Test
    public void testHashCodeWithValidName() {
        // When name is valid, hashCode should return the hashCode of QName
        assertEquals(validQName.hashCode(), beanPointerWithValidName.hashCode());
    }
}
