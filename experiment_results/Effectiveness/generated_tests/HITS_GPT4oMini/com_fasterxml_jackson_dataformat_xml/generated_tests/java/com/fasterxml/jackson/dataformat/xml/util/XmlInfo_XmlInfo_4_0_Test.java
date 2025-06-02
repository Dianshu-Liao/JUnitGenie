package com.fasterxml.jackson.dataformat.xml.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XmlInfo_XmlInfo_4_0_Test {

    @Test
    public void testXmlInfoWithAllParametersNull() {
        XmlInfo xmlInfo = new XmlInfo(null, null, null, null);
        assertFalse(xmlInfo._isAttribute);
        assertEquals("", xmlInfo._namespace);
        assertFalse(xmlInfo._isText);
        assertFalse(xmlInfo._isCData);
    }

    @Test
    public void testXmlInfoWithIsAttributeTrue() {
        XmlInfo xmlInfo = new XmlInfo(true, "http://example.com", true, false);
        assertTrue(xmlInfo._isAttribute);
        assertEquals("http://example.com", xmlInfo._namespace);
        assertTrue(xmlInfo._isText);
        assertFalse(xmlInfo._isCData);
    }

    @Test
    public void testXmlInfoWithIsAttributeFalse() {
        XmlInfo xmlInfo = new XmlInfo(false, "http://example.com", false, true);
        assertFalse(xmlInfo._isAttribute);
        assertEquals("http://example.com", xmlInfo._namespace);
        assertFalse(xmlInfo._isText);
        assertTrue(xmlInfo._isCData);
    }

    @Test
    public void testXmlInfoWithNamespaceNull() {
        XmlInfo xmlInfo = new XmlInfo(true, null, true, false);
        assertTrue(xmlInfo._isAttribute);
        assertEquals("", xmlInfo._namespace);
        assertTrue(xmlInfo._isText);
        assertFalse(xmlInfo._isCData);
    }

    @Test
    public void testXmlInfoWithIsTextTrue() {
        XmlInfo xmlInfo = new XmlInfo(true, "http://example.com", true, true);
        assertTrue(xmlInfo._isAttribute);
        assertEquals("http://example.com", xmlInfo._namespace);
        assertTrue(xmlInfo._isText);
        assertTrue(xmlInfo._isCData);
    }

    @Test
    public void testXmlInfoWithIsCDataTrue() {
        XmlInfo xmlInfo = new XmlInfo(false, "http://example.com", false, true);
        assertFalse(xmlInfo._isAttribute);
        assertEquals("http://example.com", xmlInfo._namespace);
        assertFalse(xmlInfo._isText);
        assertTrue(xmlInfo._isCData);
    }
}
