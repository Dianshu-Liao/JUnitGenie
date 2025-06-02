package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributePointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_model_dom_DOMAttributePointer_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        DOMAttributePointer pointer = new DOMAttributePointer(null, null);
        assertTrue(pointer.equals(pointer)); // Testing the case where object == this
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject() {
        DOMAttributePointer pointer1 = new DOMAttributePointer(null, null);
        DOMAttributePointer pointer2 = new DOMAttributePointer(null, null);
        assertTrue(!pointer1.equals(pointer2)); // Testing the case where object is a different instance
    }

}