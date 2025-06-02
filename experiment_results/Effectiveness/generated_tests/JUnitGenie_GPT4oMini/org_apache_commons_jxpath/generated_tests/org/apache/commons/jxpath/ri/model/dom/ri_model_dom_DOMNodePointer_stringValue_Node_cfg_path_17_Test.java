package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.CDATASection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            // Set up a test document with a text node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);
            Node textNode = doc.createTextNode("Sample Text");
            root.appendChild(textNode);

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("Sample Text", result);

        } catch (Exception e) {
            e.printStackTrace();
            // Handling any unexpected exceptions
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            // Set up a test document with a comment node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);
            Node commentNode = doc.createComment("This is a comment");
            root.appendChild(commentNode);

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            
            String result = (String) method.invoke(pointer, commentNode);
            assertEquals("", result);

        } catch (Exception e) {
            e.printStackTrace();
            // Handling any unexpected exceptions
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCDATASection() {
        try {
            // Set up a test document with a CDATA section
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);
            CDATASection cdataNode = doc.createCDATASection("Some CDATA content");
            root.appendChild(cdataNode);

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            
            String result = (String) method.invoke(pointer, cdataNode);
            assertEquals("Some CDATA content", result);

        } catch (Exception e) {
            e.printStackTrace();
            // Handling any unexpected exceptions
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithMultipleChildNodes() {
        try {
            // Set up a test document with mixed child nodes
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);
            root.appendChild(doc.createTextNode("Header"));
            root.appendChild(doc.createComment("This is a comment"));
            root.appendChild(doc.createCDATASection("Some CDATA content"));

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            
            String result = (String) method.invoke(pointer, root);
            assertEquals("HeaderSome CDATA content", result);

        } catch (Exception e) {
            e.printStackTrace();
            // Handling any unexpected exceptions
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstructionNode() {
        try {
            // Set up a test document with a processing instruction node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);
            Node piNode = doc.createProcessingInstruction("target", "data");
            root.appendChild(piNode);

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            
            String result = (String) method.invoke(pointer, piNode);
            assertEquals("data", result);

        } catch (Exception e) {
            e.printStackTrace();
            // Handling any unexpected exceptions
        }
    }

}