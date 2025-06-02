package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullElement() {
        // Arrange
        JDOMNodePointer pointer = new JDOMNodePointer(new Object(), null); // Using a constructor that initializes the node
        String prefix = "nonexistentPrefix"; // A prefix that does not correspond to any namespace

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithXmlPrefix() {
        // Arrange
        JDOMNodePointer pointer = new JDOMNodePointer(new Document(), null); // Using a Document as the node
        String prefix = "xml";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        // Arrange
        Element element = new Element("testElement", Namespace.XML_NAMESPACE);
        JDOMNodePointer pointer = new JDOMNodePointer(element, null); // Using an Element as the node
        String prefix = "testElement";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertEquals(element.getNamespace(prefix).getURI(), result);
    }


}