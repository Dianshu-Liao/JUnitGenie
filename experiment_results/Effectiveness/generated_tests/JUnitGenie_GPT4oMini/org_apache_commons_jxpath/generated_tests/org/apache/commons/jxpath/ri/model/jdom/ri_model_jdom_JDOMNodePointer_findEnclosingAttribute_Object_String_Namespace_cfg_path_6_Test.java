package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_findEnclosingAttribute_Object_String_Namespace_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testFindEnclosingAttribute() {
        try {
            // Setup
            Namespace ns = Namespace.getNamespace("http://example.com");
            Element childElement = new Element("child");
            childElement.setAttribute("testAttr", "testValue", ns);
            Element parentElement = new Element("parent");
            parentElement.addContent(childElement);

            // Execute
            String result = JDOMNodePointer.findEnclosingAttribute(childElement, "testAttr", ns);

            // Verify
            assertEquals("testValue", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}