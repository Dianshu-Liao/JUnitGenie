package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_jdom_JDOMNodePointer_findEnclosingAttribute_Object_String_Namespace_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFindEnclosingAttributeWithValidElement() {
        try {
            // Setup
            Namespace ns = Namespace.getNamespace("http://example.com");
            Element element = new Element("testElement", ns);
            element.setAttribute("testAttr", "testValue");
            Object n = element; // n is an instance of org.jdom.Element
            String attrName = "testAttr";

            // Invoke the method using reflection
            String result = (String) JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class)
                    .invoke(null, n, attrName, ns);

            // Verify the result
            assertEquals("testValue", result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFindEnclosingAttributeWithNullElement() {
        try {
            // Setup
            Object n = null; // n is null
            String attrName = "testAttr";
            Namespace ns = Namespace.getNamespace("http://example.com");

            // Invoke the method using reflection
            String result = (String) JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class)
                    .invoke(null, n, attrName, ns);

            // Verify the result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFindEnclosingAttributeWithEmptyAttribute() {
        try {
            // Setup
            Namespace ns = Namespace.getNamespace("http://example.com");
            Element element = new Element("testElement", ns);
            element.setAttribute("testAttr", ""); // Empty attribute
            Object n = element; // n is an instance of org.jdom.Element
            String attrName = "testAttr";

            // Invoke the method using reflection
            String result = (String) JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class)
                    .invoke(null, n, attrName, ns);

            // Verify the result
            assertNull(result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

}