package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Locale;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURI_WhenPrefixIsXml() {
        // Set up
        Document document = new Document();
        JDOMNodePointer pointer = new JDOMNodePointer(document, null);
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_WhenNodeIsElement() {
        // Set up
        Element element = new Element("example", Namespace.getNamespace("test", "http://example.com"));
        JDOMNodePointer pointer = new JDOMNodePointer(element, null);

        // Act
        String result = pointer.getNamespaceURI("test");
        
        // Assert
        assertEquals("http://example.com", result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_WhenPrefixIsUnknown() {
        // Set up
        Document document = new Document(); // an empty Document
        JDOMNodePointer pointer = new JDOMNodePointer(document, null);
        
        // Act
        String result = pointer.getNamespaceURI("unknown");
        
        // Assert
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURI_WhenNodeIsNull() {
        // Set up
        JDOMNodePointer pointer = new JDOMNodePointer(null, (Object) null); // Specify Object to resolve ambiguity
        
        // Act
        String result = pointer.getNamespaceURI("xml");
        
        // Assert
        assertEquals(null, result);
    }

}