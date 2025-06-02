package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_jdom_JDOMNamespacePointer_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObjectType() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        Object differentObject = new Object();
        assertFalse(pointer.equals(differentObject));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        assertFalse(pointer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualPrefixes() {
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(null, "prefix");
        JDOMNamespacePointer pointer2 = new JDOMNamespacePointer(null, "prefix");
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentPrefixes() {
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(null, "prefix1");
        JDOMNamespacePointer pointer2 = new JDOMNamespacePointer(null, "prefix2");
        assertFalse(pointer1.equals(pointer2));
    }

}