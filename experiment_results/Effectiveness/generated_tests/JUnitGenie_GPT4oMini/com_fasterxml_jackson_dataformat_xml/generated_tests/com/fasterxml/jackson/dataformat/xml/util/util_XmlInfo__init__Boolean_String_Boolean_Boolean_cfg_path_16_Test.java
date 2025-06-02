package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_XmlInfo__init__Boolean_String_Boolean_Boolean_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testXmlInfoConstructor() {
        // Test with all parameters as non-null values
        Boolean isAttribute = true;
        String ns = "namespace";
        Boolean isText = true;
        Boolean isCData = true;

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        // Validate the internal state of the object
        assertEquals(true, xmlInfo._isAttribute);
        assertEquals("namespace", xmlInfo._namespace);
        assertEquals(true, xmlInfo._isText);
        assertEquals(true, xmlInfo._isCData);
    }

    @Test(timeout = 4000)
    public void testXmlInfoConstructorWithNulls() {
        // Test with some parameters as null
        Boolean isAttribute = null;
        String ns = null;
        Boolean isText = null;
        Boolean isCData = null;

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        // Validate the internal state of the object
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(false, xmlInfo._isCData);
    }

}