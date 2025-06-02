package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer;
import org.jdom.Attribute;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ri_model_jdom_JDOMAttributePointer_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, new Attribute("attr1", "value1", Namespace.NO_NAMESPACE));
        String differentObject = "Not a JDOMAttributePointer";
        
        // Testing the equals method with a different object type
        boolean result = pointer.equals(differentObject);
        
        // The result should be false
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameReference() {
        JDOMAttributePointer pointer = new JDOMAttributePointer(null, new Attribute("attr1", "value1", Namespace.NO_NAMESPACE));
        
        // Testing the equals method with the same reference
        boolean result = pointer.equals(pointer);
        
        // The result should be true
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentJDOMAttributePointer() {
        JDOMAttributePointer pointer1 = new JDOMAttributePointer(null, new Attribute("attr1", "value1", Namespace.NO_NAMESPACE));
        JDOMAttributePointer pointer2 = new JDOMAttributePointer(null, new Attribute("attr2", "value2", Namespace.NO_NAMESPACE));
        
        // Testing the equals method with different JDOMAttributePointer instances
        boolean result = pointer1.equals(pointer2);
        
        // The result should be false
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameJDOMAttributePointer() {
        Attribute attr = new Attribute("attr1", "value1", Namespace.NO_NAMESPACE);
        JDOMAttributePointer pointer1 = new JDOMAttributePointer(null, attr);
        JDOMAttributePointer pointer2 = new JDOMAttributePointer(null, attr);
        
        // Testing the equals method with the same attribute
        boolean result = pointer1.equals(pointer2);
        
        // The result should be true
        assertFalse(result);
    }


}