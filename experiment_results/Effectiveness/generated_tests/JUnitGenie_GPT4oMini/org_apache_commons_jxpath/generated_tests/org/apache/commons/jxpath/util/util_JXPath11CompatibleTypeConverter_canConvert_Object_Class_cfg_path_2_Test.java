package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.util.JXPath11CompatibleTypeConverter;
import org.apache.commons.jxpath.NodeSet;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class util_JXPath11CompatibleTypeConverter_canConvert_Object_Class_cfg_path_2_Test {


    @Test(timeout = 4000)
    public void testCanConvertWithNonNodeSet() {
        JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();
        String nonNodeSetObject = "string";
        boolean result = converter.canConvert(nonNodeSetObject, String.class);
        assertFalse(result);
    }

}
