package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithXmlPrefix() {
        // Arrange
        Document document = new Document();
        Element rootElement = new Element("root", Namespace.XML_NAMESPACE);
        document.setRootElement(rootElement);
        JDOMNodePointer pointer = new JDOMNodePointer(document, null);

        // Act
        String result = pointer.getNamespaceURI("xml");

        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNonXmlPrefix() {
        // Arrange
        Document document = new Document();
        Element rootElement = new Element("root", Namespace.getNamespace("custom", "http://custom.namespace"));
        document.setRootElement(rootElement);
        JDOMNodePointer pointer = new JDOMNodePointer(document, null);

        // Act
        String result = pointer.getNamespaceURI("custom");

        // Assert
        assertEquals("http://custom.namespace", result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullPrefix() {
        // Arrange
        Document document = new Document();
        Element rootElement = new Element("root");
        document.setRootElement(rootElement);
        JDOMNodePointer pointer = new JDOMNodePointer(document, null);

        // Act
        String result = pointer.getNamespaceURI(null);

        // Assert
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithEmptyPrefix() {
        // Arrange
        Document document = new Document();
        Element rootElement = new Element("root");
        document.setRootElement(rootElement);
        JDOMNodePointer pointer = new JDOMNodePointer(document, null);

        // Act
        String result = pointer.getNamespaceURI("");

        // Assert
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithInvalidNode() {
        // Arrange
        JDOMNodePointer pointer = new JDOMNodePointer(new Object(), null);

        // Act
        String result = pointer.getNamespaceURI("xml");

        // Assert
        assertEquals(null, result);
    }

}