package org.apache.commons.jxpath.ri.model.jdom;
import static org.junit.Assert.*;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.jdom.Element;
import org.junit.Test;
import org.jdom.Namespace;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.JDOMException;
import org.jdom.Namespace;

public class ri_model_jdom_JDOMNodePointer_testNode_NodePointer_Object_NodeTest_cfg_path_25_Test {




    @Test(timeout = 4000)
    public void testNode_withNullTest() {
        try {
            // Setup
            Element node = new Element("testElement");
            NodePointer pointer = new JDOMNodePointer(node, null); // Added Locale parameter

            // Execute
            boolean result = JDOMNodePointer.testNode(pointer, node, null);

            // Verify
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception should not have occurred.");
        }
    }

}
