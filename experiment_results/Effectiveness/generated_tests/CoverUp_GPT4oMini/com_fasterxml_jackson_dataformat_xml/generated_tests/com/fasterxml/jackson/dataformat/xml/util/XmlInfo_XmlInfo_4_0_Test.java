package com.fasterxml.jackson.dataformat.xml.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XmlInfo_XmlInfo_4_0_Test {

    private XmlInfo xmlInfo;

    @BeforeEach
    public void setUp() {
        // Initialize with default values for testing
        xmlInfo = new XmlInfo(false, "http://example.com", true, false);
    }

    @Test
    public void testConstructorWithNullValues() {
        XmlInfo xmlInfoNulls = new XmlInfo(null, null, null, null);
        assertEquals("", xmlInfoNulls.getNamespace());
        // Since isAttribute, isText, and isCData are null, they should default to false
        assertEquals(false, invokePrivateField(xmlInfoNulls, "_isAttribute"));
        assertEquals(false, invokePrivateField(xmlInfoNulls, "_isText"));
        assertEquals(false, invokePrivateField(xmlInfoNulls, "_isCData"));
    }

    @Test
    public void testConstructorWithFalseValues() {
        XmlInfo xmlInfoFalse = new XmlInfo(false, "http://example.com", false, false);
        assertEquals("http://example.com", xmlInfoFalse.getNamespace());
        assertEquals(false, invokePrivateField(xmlInfoFalse, "_isAttribute"));
        assertEquals(false, invokePrivateField(xmlInfoFalse, "_isText"));
        assertEquals(false, invokePrivateField(xmlInfoFalse, "_isCData"));
    }

    @Test
    public void testConstructorWithTrueValues() {
        XmlInfo xmlInfoTrue = new XmlInfo(true, "http://example.com", true, true);
        assertEquals("http://example.com", xmlInfoTrue.getNamespace());
        assertEquals(true, invokePrivateField(xmlInfoTrue, "_isAttribute"));
        assertEquals(true, invokePrivateField(xmlInfoTrue, "_isText"));
        assertEquals(true, invokePrivateField(xmlInfoTrue, "_isCData"));
    }

    @Test
    public void testConstructorWithMixedValues() {
        XmlInfo xmlInfoMixed = new XmlInfo(true, null, false, null);
        assertEquals("", xmlInfoMixed.getNamespace());
        assertEquals(true, invokePrivateField(xmlInfoMixed, "_isAttribute"));
        assertEquals(false, invokePrivateField(xmlInfoMixed, "_isText"));
        assertEquals(false, invokePrivateField(xmlInfoMixed, "_isCData"));
    }

    private boolean invokePrivateField(XmlInfo xmlInfo, String fieldName) {
        try {
            java.lang.reflect.Field field = XmlInfo.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.getBoolean(xmlInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
