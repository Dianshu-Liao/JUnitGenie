package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.CDATASection;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Comment;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            Text textNode = doc.createTextNode("  Sample Text  ");
            root.appendChild(textNode);
            doc.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(doc.getDocumentElement(), Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method with a text node
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("Sample Text", result);
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
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            Comment commentNode = doc.createComment("This is a comment");
            root.appendChild(commentNode);
            doc.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(doc.getDocumentElement(), Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method with a comment node
            String result = (String) method.invoke(pointer, commentNode);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCDATASection() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            CDATASection cdataSection = doc.createCDATASection("Sample CDATA");
            root.appendChild(cdataSection);
            doc.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(doc.getDocumentElement(), Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method with a CDATA section
            String result = (String) method.invoke(pointer, cdataSection);
            assertEquals("Sample CDATA", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstructionNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            ProcessingInstruction piNode = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"style.xsl\"");
            root.appendChild(piNode);
            doc.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(doc.getDocumentElement(), Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method with a processing instruction node
            String result = (String) method.invoke(pointer, piNode);
            assertEquals("type=\"text/xsl\" href=\"style.xsl\"", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}