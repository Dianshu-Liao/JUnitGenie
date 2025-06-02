package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_XmlInfo__init__Boolean_String_Boolean_Boolean_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testXmlInfoConstructorWithAllParameters() {
        Boolean isAttribute = true;
        String ns = "namespace";
        Boolean isText = false;
        Boolean isCData = true;

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        // Accessing protected fields via reflection to validate the behavior
        assertFieldValue(xmlInfo, "_isAttribute", true);
        assertFieldValue(xmlInfo, "_namespace", "namespace");
        assertFieldValue(xmlInfo, "_isText", false);
        assertFieldValue(xmlInfo, "_isCData", true);
    }

    @Test(timeout = 4000)
    public void testXmlInfoConstructorWithNullValues() {
        Boolean isAttribute = null; // should default to false
        String ns = null; // should default to empty string
        Boolean isText = null; // should default to false
        Boolean isCData = null; // should default to false

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        assertFieldValue(xmlInfo, "_isAttribute", false);
        assertFieldValue(xmlInfo, "_namespace", "");
        assertFieldValue(xmlInfo, "_isText", false);
        assertFieldValue(xmlInfo, "_isCData", false);
    }

    private void assertFieldValue(XmlInfo xmlInfo, String fieldName, Object expectedValue) {
        try {
            java.lang.reflect.Field field = XmlInfo.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object actualValue = field.get(xmlInfo);
            assertEquals(expectedValue, actualValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}