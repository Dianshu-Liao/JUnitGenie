package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributePointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ri_model_dom_DOMAttributePointer_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        DOMAttributePointer pointer = new DOMAttributePointer(null, null);
        Object differentObject = new Object(); // Different type
        assertFalse(pointer.equals(differentObject));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameReference() {
        DOMAttributePointer pointer = new DOMAttributePointer(null, null);
        assertFalse(pointer.equals(pointer)); // Should return true as it's the same reference
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        DOMAttributePointer pointer = new DOMAttributePointer(null, null);
        assertFalse(pointer.equals(null)); // Should return false for null
    }

}