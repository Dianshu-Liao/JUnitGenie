package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Locale;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNode() {
        // Arrange
        JDOMNodePointer pointer = new JDOMNodePointer((Object) null, Locale.getDefault());
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        // Arrange
        Document document = new Document();
        JDOMNodePointer pointer = new JDOMNodePointer(document, Locale.getDefault());
        Namespace namespace = Namespace.getNamespace("xml", "http://www.w3.org/XML/1998/namespace");
        Element rootElement = new Element("root", namespace);
        document.setRootElement(rootElement);
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertNull(result); // Since the namespace is not defined in the root element
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        // Arrange
        Namespace namespace = Namespace.getNamespace("xml", "http://www.w3.org/XML/1998/namespace");
        Element element = new Element("element", namespace);
        JDOMNodePointer pointer = new JDOMNodePointer(element, Locale.getDefault());
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertNull(result); // Since the namespace is not defined in the element
    }

}