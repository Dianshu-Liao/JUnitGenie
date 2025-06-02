package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_XmlInfo__init__Boolean_String_Boolean_Boolean_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testXmlInfoConstructorWithNonNullParams() {
        Boolean isAttribute = true;
        String ns = "namespace";
        Boolean isText = true;
        Boolean isCData = true;

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        // Test that the fields are correctly set
        assertEquals(true, xmlInfo._isAttribute);
        assertEquals("namespace", xmlInfo._namespace);
        assertEquals(true, xmlInfo._isText);
        assertEquals(true, xmlInfo._isCData);
    }

    @Test(timeout = 4000)
    public void testXmlInfoConstructorWithNullParams() {
        XmlInfo xmlInfo = new XmlInfo(null, null, null, null);
        
        // Test that the fields are set to defaults
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(false, xmlInfo._isCData);
    }

    @Test(timeout = 4000)
    public void testXmlInfoConstructorWithMixedParams() {
        Boolean isAttribute = null;
        String ns = "namespace";
        Boolean isText = null;
        Boolean isCData = true;

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        // Test that fields handle mixed null and non-null correctly
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("namespace", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(true, xmlInfo._isCData);
    }

}