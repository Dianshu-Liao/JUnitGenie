package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_model_jdom_JDOMNamespacePointer_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithSameObject() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        assertTrue("An object should be equal to itself.", pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(null, "prefix");
        assertFalse("An object should not be equal to a different type.", pointer.equals("some string"));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentPrefix() {
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(null, "prefix1");
        JDOMNamespacePointer pointer2 = new JDOMNamespacePointer(null, "prefix2");
        assertFalse("Two JDOMNamespacePointer instances with different prefixes should not be equal.", pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSamePrefix() {
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(null, "prefix");
        JDOMNamespacePointer pointer2 = new JDOMNamespacePointer(null, "prefix");
        assertTrue("Two JDOMNamespacePointer instances with the same prefix should be equal.", pointer1.equals(pointer2));
    }

}