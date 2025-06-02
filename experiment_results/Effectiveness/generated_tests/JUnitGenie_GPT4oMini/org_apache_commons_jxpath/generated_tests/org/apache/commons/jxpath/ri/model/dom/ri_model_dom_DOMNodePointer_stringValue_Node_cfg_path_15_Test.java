package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testStringValueWithElementNode() {
        try {
            // Create a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            root.setAttribute("xml:space", "preserve");
            Element child = document.createElement("child");
            child.appendChild(document.createTextNode("  Hello World  "));
            root.appendChild(child);
            document.appendChild(root);

            // Instantiate the DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());

            // Access the private method stringValue using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with the child node
            String result = (String) method.invoke(pointer, child);

            // Assert the expected result
            assertEquals("Hello World", result);
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
            Node commentNode = document.createComment("This is a comment");

            // Instantiate the DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(commentNode, Locale.getDefault());

            // Access the private method stringValue using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Call the method with the comment node
            String result = (String) method.invoke(pointer, commentNode);

            // Assert the expected result
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}