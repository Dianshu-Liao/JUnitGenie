package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Locale;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithXmlPrefix() {
        // Arrange
        Document document = new Document();
        Element rootElement = new Element("root");
        document.setRootElement(rootElement);
        JDOMNodePointer pointer = new JDOMNodePointer(document, null);

        // Act
        String result = pointer.getNamespaceURI("xml");

        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNonExistentPrefix() {
        // Arrange
        Element element = new Element("testElement");
        JDOMNodePointer pointer = new JDOMNodePointer(element, null);

        // Act
        String result = pointer.getNamespaceURI("nonExistentPrefix");

        // Assert
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNode() {
        // Arrange
        JDOMNodePointer pointer = new JDOMNodePointer(null, (Object) Locale.getDefault()); // Cast to Object to resolve ambiguity

        // Act
        String result = pointer.getNamespaceURI("xml");

        // Assert
        assertEquals(null, result);
    }

}