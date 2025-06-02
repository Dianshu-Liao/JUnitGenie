package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_XmlInfo__init__Boolean_String_Boolean_Boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testXmlInfoConstructor() {
        // Test with all parameters as null
        XmlInfo xmlInfo = new XmlInfo(null, null, null, null);
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(false, xmlInfo._isCData);

        // Test with some parameters as null
        xmlInfo = new XmlInfo(true, "namespace", null, true);
        assertEquals(true, xmlInfo._isAttribute);
        assertEquals("namespace", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(true, xmlInfo._isCData);

        // Test with all parameters provided
        xmlInfo = new XmlInfo(false, "anotherNamespace", true, false);
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("anotherNamespace", xmlInfo._namespace);
        assertEquals(true, xmlInfo._isText);
        assertEquals(false, xmlInfo._isCData);
    }

}