package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Text;
import org.w3c.dom.Comment;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstruction() {
        try {
            // Create a sample ProcessingInstruction node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            ProcessingInstruction pi = doc.createProcessingInstruction("target", "data");

            // Instantiate the DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(pi, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method and assert the expected output
            String result = (String) method.invoke(pointer, pi);
            assertEquals("data", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            // Create a sample Comment node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Comment comment = doc.createComment("This is a comment");

            // Instantiate the DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(comment, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method and assert the expected output
            String result = (String) method.invoke(pointer, comment);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            // Create a sample Text node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Text textNode = doc.createTextNode("   Hello World!   ");

            // Instantiate the DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(textNode, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method and assert the expected output
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("Hello World!", result.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCDATASection() {
        try {
            // Create a sample CDATASection node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            CDATASection cdataSection = doc.createCDATASection("Some CDATA content");

            // Instantiate the DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(cdataSection, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method and assert the expected output
            String result = (String) method.invoke(pointer, cdataSection);
            assertEquals("Some CDATA content", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}