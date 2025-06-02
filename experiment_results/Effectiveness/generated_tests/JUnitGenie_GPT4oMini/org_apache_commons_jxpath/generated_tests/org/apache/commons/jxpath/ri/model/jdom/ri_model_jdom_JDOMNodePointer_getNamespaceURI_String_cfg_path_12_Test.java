package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import java.util.Locale;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNode() {
        // Arrange
        JDOMNodePointer pointer = new JDOMNodePointer((Object) null, Locale.getDefault()); // Specify a Locale
        String prefix = "example";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        // Arrange
        Document document = new Document();
        JDOMNodePointer pointer = new JDOMNodePointer(document, Locale.getDefault()); // Specify a Locale
        String prefix = "xml";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        // Arrange
        Element element = new Element("root", Namespace.XML_NAMESPACE);
        JDOMNodePointer pointer = new JDOMNodePointer(element, Locale.getDefault()); // Specify a Locale
        String prefix = "xml";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNonExistentPrefix() {
        // Arrange
        Element element = new Element("root");
        JDOMNodePointer pointer = new JDOMNodePointer(element, Locale.getDefault()); // Specify a Locale
        String prefix = "nonexistent";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithPrefixEqualXml() {
        // Arrange
        Element element = new Element("root", Namespace.XML_NAMESPACE);
        JDOMNodePointer pointer = new JDOMNodePointer(element, Locale.getDefault()); // Specify a Locale
        String prefix = "xml";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertEquals(Namespace.XML_NAMESPACE.getURI(), result);
    }


}