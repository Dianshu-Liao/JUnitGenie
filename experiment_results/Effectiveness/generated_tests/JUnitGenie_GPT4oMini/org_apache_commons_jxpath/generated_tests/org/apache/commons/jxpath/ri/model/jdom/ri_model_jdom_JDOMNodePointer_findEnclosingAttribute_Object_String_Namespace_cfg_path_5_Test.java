package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_jdom_JDOMNodePointer_findEnclosingAttribute_Object_String_Namespace_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testFindEnclosingAttribute() {
        try {
            // Set up the test data
            Namespace ns = Namespace.getNamespace("http://www.example.com/ns");
            Element childElement = new Element("child", ns);
            childElement.setAttribute("sampleAttr", "sampleValue");

            Element parentElement = new Element("parent", ns);
            parentElement.addContent(childElement);
            
            // Use reflection to access the protected static method
            String attrName = "sampleAttr";
            String result = (String) JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class)
                    .invoke(null, childElement, attrName, ns);
            
            // Assert the expected result
            assertEquals("sampleValue", result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFindEnclosingAttributeNoAttribute() {
        try {
            // Set up the test data
            Namespace ns = Namespace.getNamespace("http://www.example.com/ns");
            Element childElement = new Element("child", ns);
            
            // No attribute is set on the child element

            Element parentElement = new Element("parent", ns);
            parentElement.addContent(childElement);
            
            // Use reflection to access the protected static method
            String attrName = "nonExistentAttr"; 
            String result = (String) JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class)
                    .invoke(null, childElement, attrName, ns);
            
            // Assert the expected result
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFindEnclosingAttributeWithNullParent() {
        try {
            // Set up the test data
            Namespace ns = Namespace.getNamespace("http://www.example.com/ns");
            Element childElement = new Element("child", ns);
            childElement.setAttribute("sampleAttr", "sampleValue");
            
            // Assuming childElement has no parent to simulate null return
            // Use reflection to access the protected static method
            String attrName = "sampleAttr";
            String result = (String) JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class)
                    .invoke(null, childElement, attrName, ns);
            
            // Assert that the method returns null because there is no parent
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

}