package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testStringValueWithTextNodeAndPreserve() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            Element child = document.createElement("child");
            child.appendChild(document.createTextNode("  Sample Text  "));
            root.appendChild(child);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault(), null);

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with a text node and "preserve" attribute
            String result = (String) method.invoke(pointer, child);
            assertEquals("Sample Text", result.trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            Node commentNode = document.createComment("This is a comment");
            root.appendChild(commentNode);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault(), null);

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with a comment node
            String result = (String) method.invoke(pointer, commentNode);
            assertEquals("", result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCDataSectionNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            Node cdataNode = document.createCDATASection("This is CDATA");
            root.appendChild(cdataNode);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault(), null);

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with a CDATA section node
            String result = (String) method.invoke(pointer, cdataNode);
            assertEquals("This is CDATA", result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}