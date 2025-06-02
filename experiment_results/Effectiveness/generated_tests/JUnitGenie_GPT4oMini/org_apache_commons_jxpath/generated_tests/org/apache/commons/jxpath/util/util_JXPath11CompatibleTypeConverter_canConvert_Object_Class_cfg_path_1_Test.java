package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.JXPath11CompatibleTypeConverter;
import org.apache.commons.jxpath.NodeSet;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class util_JXPath11CompatibleTypeConverter_canConvert_Object_Class_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCanConvertWithNonNodeSet() {
        JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();
        String nonNodeSetObject = "Not a NodeSet";
        Class<NodeSet> toType = NodeSet.class;

        boolean result = converter.canConvert(nonNodeSetObject, toType);
        assertFalse(result);
    }

}