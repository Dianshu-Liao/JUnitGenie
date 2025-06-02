package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_XmlInfo__init__Boolean_String_Boolean_Boolean_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testXmlInfoConstructor() {
        // Test with all parameters as non-null values
        XmlInfo xmlInfo = new XmlInfo(Boolean.TRUE, "namespace", Boolean.TRUE, Boolean.TRUE);
        assertEquals(true, xmlInfo._isAttribute);
        assertEquals("namespace", xmlInfo._namespace);
        assertEquals(true, xmlInfo._isText);
        assertEquals(true, xmlInfo._isCData);

        // Test with some parameters as null
        xmlInfo = new XmlInfo(null, null, null, null);
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(false, xmlInfo._isCData);
        
        // Test with mixed null and non-null values
        xmlInfo = new XmlInfo(Boolean.FALSE, "namespace", null, Boolean.TRUE);
        assertEquals(false, xmlInfo._isAttribute);
        assertEquals("namespace", xmlInfo._namespace);
        assertEquals(false, xmlInfo._isText);
        assertEquals(true, xmlInfo._isCData);
    }

}