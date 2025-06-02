package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstruction() {
        try {
            // Create a sample ProcessingInstruction node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            ProcessingInstruction pi = document.createProcessingInstruction("target", "data");

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(pi, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with the ProcessingInstruction node
            String result = (String) method.invoke(pointer, pi);

            // Assert the expected result
            assertEquals("data", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithChildNodes() {
        try {
            // Create a sample Document and Element with child nodes
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            Element child1 = document.createElement("child1");
            child1.appendChild(document.createTextNode("text1"));
            Element child2 = document.createElement("child2");
            child2.appendChild(document.createTextNode("text2"));
            root.appendChild(child1);
            root.appendChild(child2);
            document.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with the root node
            String result = (String) method.invoke(pointer, root);

            // Assert the expected result
            assertEquals("text1text2", result);
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
            Document document = builder.newDocument();
            Node commentNode = document.createComment("This is a comment");

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(commentNode, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with the Comment node
            String result = (String) method.invoke(pointer, commentNode);

            // Assert the expected result
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}