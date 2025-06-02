package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Locale;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNode() {
        // Arrange
        JDOMNodePointer pointer = new JDOMNodePointer((Object) null, Locale.getDefault()); // Cast null to Object to resolve ambiguity
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        // Arrange
        Document document = new Document();
        JDOMNodePointer pointer = new JDOMNodePointer(document, Locale.getDefault()); // Specify Locale to resolve ambiguity
        Element rootElement = new Element("root", Namespace.XML_NAMESPACE);
        document.setRootElement(rootElement);
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertNull(result); // Since the root element has no namespace URI for "xml"
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        // Arrange
        Element element = new Element("testElement", Namespace.XML_NAMESPACE);
        JDOMNodePointer pointer = new JDOMNodePointer(element, Locale.getDefault()); // Specify Locale to resolve ambiguity
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertNull(result); // Since the element has no namespace URI for "xml"
    }

}