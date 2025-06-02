package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithXmlPrefix() {
        // Arrange
        JDOMNodePointer nodePointer = new JDOMNodePointer(new Object(), null); // Adjust constructor parameters as needed
        String prefix = "xml";

        // Act
        String result = nodePointer.getNamespaceURI(prefix);

        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

}