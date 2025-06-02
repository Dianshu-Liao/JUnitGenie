package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer;
import org.jdom.Attribute;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_jdom_JDOMAttributePointer_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, new Attribute("attrName", "value", Namespace.NO_NAMESPACE));
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, new Attribute("attrName", "value", Namespace.NO_NAMESPACE));
        assertFalse(pointer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, new Attribute("attrName", "value", Namespace.NO_NAMESPACE));
        String differentObject = "Not a JDOMAttributePointer";
        assertFalse(pointer.equals(differentObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentAttributes() {
        JDOMAttributePointer pointer1 = new JDOMAttributePointer(null, new Attribute("attrName1", "value1", Namespace.NO_NAMESPACE));
        JDOMAttributePointer pointer2 = new JDOMAttributePointer(null, new Attribute("attrName2", "value2", Namespace.NO_NAMESPACE));
        assertFalse(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameAttributes() {
        JDOMAttributePointer pointer1 = new JDOMAttributePointer(null, new Attribute("attrName", "value", Namespace.NO_NAMESPACE));
        JDOMAttributePointer pointer2 = new JDOMAttributePointer(null, new Attribute("attrName", "value", Namespace.NO_NAMESPACE));
        assertTrue(pointer1.equals(pointer2));
    }


}