package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_model_jdom_JDOMNamespacePointer_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        assertTrue(pointer.equals(pointer)); // Testing the case where object == this
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject() {
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(null, "prefix");
        JDOMNamespacePointer pointer2 = new JDOMNamespacePointer(null, "prefix");
        assertTrue(pointer1.equals(pointer2)); // Testing the case where object is an instance of JDOMNamespacePointer with the same prefix
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        assertTrue(!pointer.equals(null)); // Testing the case where object is null
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        assertTrue(!pointer.equals("string")); // Testing the case where object is of a different type
    }

}