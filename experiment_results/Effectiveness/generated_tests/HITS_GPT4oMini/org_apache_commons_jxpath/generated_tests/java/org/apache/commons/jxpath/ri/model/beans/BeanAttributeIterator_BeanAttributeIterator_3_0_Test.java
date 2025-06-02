package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BeanAttributeIterator_BeanAttributeIterator_3_0_Test {

    private PropertyOwnerPointer parentPointer;

    private QName validQName;

    private QName wildcardQName;

    private QName xmlLangQName;

    @BeforeEach
    public void setUp() {
        // Initialize the PropertyOwnerPointer mock
        parentPointer = Mockito.mock(PropertyOwnerPointer.class);
        validQName = new QName("namespace", "localName");
        wildcardQName = new QName("*");
        xmlLangQName = new QName("xml", "lang");
    }

    @Test
    public void testBeanAttributeIterator_WithValidQName() {
        BeanAttributeIterator iterator = new BeanAttributeIterator(parentPointer, validQName);
        assertNotNull(iterator, "BeanAttributeIterator should be instantiated with valid QName");
    }

    @Test
    public void testBeanAttributeIterator_WithWildcardQName() {
        BeanAttributeIterator iterator = new BeanAttributeIterator(parentPointer, wildcardQName);
        assertNotNull(iterator, "BeanAttributeIterator should be instantiated with wildcard QName");
    }

    @Test
    public void testBeanAttributeIterator_WithXmlLangQName() {
        BeanAttributeIterator iterator = new BeanAttributeIterator(parentPointer, xmlLangQName);
        assertNotNull(iterator, "BeanAttributeIterator should be instantiated with xml:lang QName");
    }

    @Test
    public void testBeanAttributeIterator_WithNullPrefixAndNullName() {
        QName nullQName = new QName(null, null);
        BeanAttributeIterator iterator = new BeanAttributeIterator(parentPointer, nullQName);
        assertNotNull(iterator, "BeanAttributeIterator should be instantiated with QName having null prefix and name");
    }

    @Test
    public void testBeanAttributeIterator_WithNullPrefixAndWildcardName() {
        QName wildcardNameQName = new QName(null, "*");
        BeanAttributeIterator iterator = new BeanAttributeIterator(parentPointer, wildcardNameQName);
        assertNotNull(iterator, "BeanAttributeIterator should be instantiated with QName having null prefix and wildcard name");
    }

    @Test
    public void testBeanAttributeIterator_WithNullPrefixAndLangName() {
        QName langQName = new QName(null, "lang");
        BeanAttributeIterator iterator = new BeanAttributeIterator(parentPointer, langQName);
        assertNotNull(iterator, "BeanAttributeIterator should be instantiated with QName having null prefix and lang name");
    }
}
