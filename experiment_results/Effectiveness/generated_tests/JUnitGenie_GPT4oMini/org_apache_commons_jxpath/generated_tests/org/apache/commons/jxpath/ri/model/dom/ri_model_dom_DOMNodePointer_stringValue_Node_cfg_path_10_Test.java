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

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testStringValueWithPreserveAttribute() {
        try {
            // Setup a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            root.setAttribute("xml:space", "preserve");
            Element child = document.createElement("child");
            child.appendChild(document.createTextNode("   some text   "));
            root.appendChild(child);
            document.appendChild(root);

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method with the child node
            String result = (String) method.invoke(pointer, child);

            // Assert the expected result
            assertEquals("   some text   ", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            // Setup a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            document.appendChild(root);
            root.appendChild(document.createComment("This is a comment"));

            // Create an instance of DOMNodePointer
            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);

            // Invoke the method with the comment node
            String result = (String) method.invoke(pointer, root.getFirstChild());

            // Assert the expected result
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}