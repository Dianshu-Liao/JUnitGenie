package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Locale;

public class ri_model_jdom_JDOMNodePointer_getNamespaceURI_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithNullNode() {
        // Arrange
        // Specify the Locale to resolve the constructor ambiguity
        JDOMNodePointer pointer = new JDOMNodePointer((Object) null, Locale.getDefault());
        String prefix = "somePrefix";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithDocumentNode() {
        // Arrange
        Document document = new Document();
        JDOMNodePointer pointer = new JDOMNodePointer(document, Locale.getDefault());
        String prefix = "somePrefix";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertNull(result); // Assuming no namespace is defined for the prefix
    }

    @Test(timeout = 4000)
    public void testGetNamespaceURIWithElementNode() {
        // Arrange
        Element element = new Element("root", Namespace.XML_NAMESPACE);
        Document document = new Document(element);
        JDOMNodePointer pointer = new JDOMNodePointer(document, Locale.getDefault());
        String prefix = "xml";

        // Act
        String result = pointer.getNamespaceURI(prefix);

        // Assert
        assertNull(result); // Assuming the expected URI is null for the given prefix
    }

}