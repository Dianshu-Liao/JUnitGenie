package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// Importing Method class
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BeanAttributeIterator_BeanAttributeIterator_3_1_Test {

    private BeanAttributeIterator iterator;

    private PropertyOwnerPointer mockParent;

    private QName mockQName;

    @BeforeEach
    void setUp() {
        // Mocking the abstract class
        mockParent = mock(PropertyOwnerPointer.class);
        mockQName = new QName("xml", "lang");
        iterator = new BeanAttributeIterator(mockParent, mockQName);
    }

    @Test
    void testConstructorWithWildcardName() {
        QName wildcardQName = new QName("*");
        BeanAttributeIterator wildcardIterator = new BeanAttributeIterator(mockParent, wildcardQName);
        assertNotNull(wildcardIterator);
    }

    @Test
    void testGetNodePointerWhenIncludeXmlLangAndPositionIsOne() throws Exception {
        setPositionUsingReflection(1);
        NodePointer result = iterator.getNodePointer();
        assertNotNull(result);
        assertTrue(result instanceof LangAttributePointer);
    }

    @Test
    void testGetNodePointerWhenNotIncludeXmlLang() throws Exception {
        QName nonXmlQName = new QName("nonXmlPrefix", "nonXmlName");
        BeanAttributeIterator nonXmlIterator = new BeanAttributeIterator(mockParent, nonXmlQName);
        NodePointer result = nonXmlIterator.getNodePointer();
        assertNotNull(result);
    }

    @Test
    void testSetPositionWhenIncludeXmlLang() {
        setPositionUsingReflection(1);
        assertTrue(iterator.setPosition(1));
        assertFalse(iterator.setPosition(2));
    }

    @Test
    void testSetPositionWhenNotIncludeXmlLang() {
        QName nonXmlQName = new QName("nonXmlPrefix", "nonXmlName");
        BeanAttributeIterator nonXmlIterator = new BeanAttributeIterator(mockParent, nonXmlQName);
        assertTrue(nonXmlIterator.setPosition(1));
    }

    private void setPositionUsingReflection(int position) {
        try {
            Method method = BeanAttributeIterator.class.getDeclaredMethod("setPosition", int.class);
            method.setAccessible(true);
            method.invoke(iterator, position);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
