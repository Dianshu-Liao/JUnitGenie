package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_XmlInfo__init__Boolean_String_Boolean_Boolean_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testXmlInfoInitialization() {
        try {
            // Initialize parameters that will go through the constructor
            Boolean isAttribute = true;
            String ns = "http://example.com";
            Boolean isText = false;
            Boolean isCData = true;

            // Create an instance of XmlInfo
            XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
            
            // Check the internal state through reflection (assuming the fields are accessible)
            java.lang.reflect.Field isAttributeField = XmlInfo.class.getDeclaredField("_isAttribute");
            isAttributeField.setAccessible(true);
            assertEquals("Expected _isAttribute to be true", true, isAttributeField.getBoolean(xmlInfo));

            java.lang.reflect.Field namespaceField = XmlInfo.class.getDeclaredField("_namespace");
            namespaceField.setAccessible(true);
            assertEquals("Expected _namespace to match", ns, namespaceField.get(xmlInfo));

            java.lang.reflect.Field isTextField = XmlInfo.class.getDeclaredField("_isText");
            isTextField.setAccessible(true);
            assertEquals("Expected _isText to be false", false, isTextField.getBoolean(xmlInfo));

            java.lang.reflect.Field isCDataField = XmlInfo.class.getDeclaredField("_isCData");
            isCDataField.setAccessible(true);
            assertEquals("Expected _isCData to be true", true, isCDataField.getBoolean(xmlInfo));

        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testXmlInfoInitializationWithNulls() {
        try {
            // Initialize with null values
            XmlInfo xmlInfo = new XmlInfo(null, null, null, null);
            
            // Check the internal state through reflection
            java.lang.reflect.Field isAttributeField = XmlInfo.class.getDeclaredField("_isAttribute");
            isAttributeField.setAccessible(true);
            assertEquals("Expected _isAttribute to be false when input is null", false, isAttributeField.getBoolean(xmlInfo));

            java.lang.reflect.Field namespaceField = XmlInfo.class.getDeclaredField("_namespace");
            namespaceField.setAccessible(true);
            assertEquals("Expected _namespace to be empty when input is null", "", namespaceField.get(xmlInfo));

            java.lang.reflect.Field isTextField = XmlInfo.class.getDeclaredField("_isText");
            isTextField.setAccessible(true);
            assertEquals("Expected _isText to be false when input is null", false, isTextField.getBoolean(xmlInfo));

            java.lang.reflect.Field isCDataField = XmlInfo.class.getDeclaredField("_isCData");
            isCDataField.setAccessible(true);
            assertEquals("Expected _isCData to be false when input is null", false, isCDataField.getBoolean(xmlInfo));

        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

}