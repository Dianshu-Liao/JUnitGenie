package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_findEnclosingAttribute_Object_String_Namespace_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFindEnclosingAttribute() {
        try {
            // Create a mock Element with the desired attribute
            Namespace ns = Namespace.getNamespace("http://example.com");
            Element childElement = new Element("child", ns);
            childElement.setAttribute("testAttr", "testValue");
            Element parentElement = new Element("parent", ns);
            parentElement.addContent(childElement);

            // Use reflection to access the protected static method
            String attrName = "testAttr";
            Object result = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class)
                    .invoke(null, childElement, attrName, ns);

            // Assert that the returned attribute value is as expected
            assertEquals("testValue", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}