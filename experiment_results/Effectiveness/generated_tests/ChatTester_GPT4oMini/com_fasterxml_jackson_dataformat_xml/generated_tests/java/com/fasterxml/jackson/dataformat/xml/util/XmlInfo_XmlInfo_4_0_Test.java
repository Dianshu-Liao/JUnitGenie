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
        // No setup needed as each test initializes the xmlInfo instance
    }

    @Test
    public void testConstructorWithAllNulls() {
        xmlInfo = new XmlInfo(null, null, null, null);
        assertEquals("", invokePrivateField("_namespace"));
        assertEquals(false, invokePrivateField("_isAttribute"));
        assertEquals(false, invokePrivateField("_isText"));
        assertEquals(false, invokePrivateField("_isCData"));
    }

    @Test
    public void testConstructorWithMixedValues() {
        xmlInfo = new XmlInfo(true, "http://example.com", null, true);
        assertEquals("http://example.com", invokePrivateField("_namespace"));
        assertEquals(true, invokePrivateField("_isAttribute"));
        assertEquals(false, invokePrivateField("_isText"));
        assertEquals(true, invokePrivateField("_isCData"));
    }

    @Test
    public void testConstructorWithAllFalse() {
        xmlInfo = new XmlInfo(false, "", false, false);
        assertEquals("", invokePrivateField("_namespace"));
        assertEquals(false, invokePrivateField("_isAttribute"));
        assertEquals(false, invokePrivateField("_isText"));
        assertEquals(false, invokePrivateField("_isCData"));
    }

    @Test
    public void testConstructorWithNullIsAttribute() {
        xmlInfo = new XmlInfo(null, "http://example.com", true, false);
        assertEquals("http://example.com", invokePrivateField("_namespace"));
        assertEquals(false, invokePrivateField("_isAttribute"));
        assertEquals(true, invokePrivateField("_isText"));
        assertEquals(false, invokePrivateField("_isCData"));
    }

    @Test
    public void testConstructorWithNullIsText() {
        xmlInfo = new XmlInfo(false, "http://example.com", null, true);
        assertEquals("http://example.com", invokePrivateField("_namespace"));
        assertEquals(false, invokePrivateField("_isAttribute"));
        assertEquals(false, invokePrivateField("_isText"));
        assertEquals(true, invokePrivateField("_isCData"));
    }

    @Test
    public void testConstructorWithNullIsCData() {
        xmlInfo = new XmlInfo(false, "http://example.com", true, null);
        assertEquals("http://example.com", invokePrivateField("_namespace"));
        assertEquals(false, invokePrivateField("_isAttribute"));
        assertEquals(true, invokePrivateField("_isText"));
        assertEquals(false, invokePrivateField("_isCData"));
    }

    private Object invokePrivateField(String fieldName) {
        try {
            java.lang.reflect.Field field = XmlInfo.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(xmlInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
