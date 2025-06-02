package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_XmlInfo__init__Boolean_String_Boolean_Boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testXmlInfoConstructor() {
        // Test case for all parameters being non-null
        Boolean isAttribute = true;
        String ns = "namespace";
        Boolean isText = false;
        Boolean isCData = true;

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        // Assertions to verify the internal state
        assertEquals(true, xmlInfo._isAttribute);
        assertEquals("namespace", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(true, xmlInfo._isCData);
    }

    @Test(timeout = 4000)
    public void testXmlInfoConstructorWithNullParameters() {
        // Test case for parameters with null values
        Boolean isAttribute = null;
        String ns = null;
        Boolean isText = null;
        Boolean isCData = null;

        XmlInfo xmlInfo = new XmlInfo(isAttribute, ns, isText, isCData);
        
        // Assertions to verify the default values
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(false, xmlInfo._isCData);
    }

}