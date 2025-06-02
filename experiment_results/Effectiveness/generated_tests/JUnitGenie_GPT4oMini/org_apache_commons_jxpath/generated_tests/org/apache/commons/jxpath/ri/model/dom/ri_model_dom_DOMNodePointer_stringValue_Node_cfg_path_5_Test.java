package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.CDATASection;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Comment;
import org.w3c.dom.Text;
import org.w3c.dom.DOMImplementation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            // Create a sample document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            Text textNode = document.createTextNode("  Hello World  ");
            root.appendChild(textNode);
            document.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            // Create a sample document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Comment commentNode = document.createComment("This is a comment");
            Element root = document.createElement("root");
            root.appendChild(commentNode);
            document.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(commentNode, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, commentNode);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCDATASection() {
        try {
            // Create a sample document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            CDATASection cdataSection = document.createCDATASection("Some CDATA content");
            Element root = document.createElement("root");
            root.appendChild(cdataSection);
            document.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(cdataSection, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, cdataSection);
            assertEquals("Some CDATA content", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstructionNode() {
        try {
            // Create a sample document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            ProcessingInstruction piNode = document.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"style.xsl\"");
            Element root = document.createElement("root");
            root.appendChild(piNode);
            document.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(piNode, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, piNode);
            assertEquals("type=\"text/xsl\" href=\"style.xsl\"", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}