package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            Node textNode = document.createTextNode("  Hello World  ");
            root.appendChild(textNode);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, null);

            // Access the private method using reflection
            java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("Hello World", result.trim());
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
            Node commentNode = document.createComment(" This is a comment ");

            root.appendChild(commentNode);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, null);

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
    public void testStringValueWithElementNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            Element child = document.createElement("child");
            child.appendChild(document.createTextNode("Child Text"));
            root.appendChild(child);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, null);

            // Access the private method using reflection
            java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            String result = (String) method.invoke(pointer, child);
            assertEquals("Child Text", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}