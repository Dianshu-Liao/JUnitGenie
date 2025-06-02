package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer;
import org.jdom.Attribute;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_model_jdom_JDOMAttributePointer_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, null);
        assertTrue(pointer.equals(pointer)); // Testing the case where object == this
    }


    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, null);
        assertTrue(!pointer.equals(null)); // Testing the case where object is null
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, null);
        assertTrue(!pointer.equals("string")); // Testing the case where object is not an instance of JDOMAttributePointer
    }


}
