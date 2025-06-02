package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMAttributePointer_asPath__cfg_path_1_Test {


    @Test(timeout = 4000)
    public void testAsPathWithoutParent() {
        try {
            // Setup
            Attribute attribute = new Attribute("attrName", "attrValue", Namespace.NO_NAMESPACE);
            JDOMAttributePointer pointer = new JDOMAttributePointer(null, attribute);

            // Execute
            String result = pointer.asPath();

            // Verify
            assertEquals("@attrName", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
