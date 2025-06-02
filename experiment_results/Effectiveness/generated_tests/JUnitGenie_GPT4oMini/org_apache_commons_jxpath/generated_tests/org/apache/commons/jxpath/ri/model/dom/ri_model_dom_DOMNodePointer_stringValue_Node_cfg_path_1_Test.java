package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstruction() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create a processing instruction node
            ProcessingInstruction pi = document.createProcessingInstruction("myInstruction", "some data");
            document.appendChild(pi);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(pi, null);

            // Access the private method using reflection
            java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, pi);
            assertEquals("some data", result);
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

            // Create a comment node
            Node commentNode = document.createComment("This is a comment");
            document.appendChild(commentNode);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(commentNode, null);

            // Access the private method using reflection
            java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, commentNode);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create a text node
            Node textNode = document.createTextNode("   some text   ");
            // Append the text node to a new element instead of the document directly
            Element element = document.createElement("root");
            element.appendChild(textNode);
            document.appendChild(element);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(textNode, null);

            // Access the private method using reflection
            java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("some text", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}