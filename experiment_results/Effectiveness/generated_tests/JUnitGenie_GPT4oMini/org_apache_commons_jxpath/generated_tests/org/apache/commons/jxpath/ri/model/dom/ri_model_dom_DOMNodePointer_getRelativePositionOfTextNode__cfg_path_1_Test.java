package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getRelativePositionOfTextNode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfTextNode() {
        try {
            // Create a sample DOM structure
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Create nodes
            Element root = doc.createElement("root");
            Text textNode1 = doc.createTextNode("Text Node 1");
            Text textNode2 = doc.createTextNode("Text Node 2");
            Element child = doc.createElement("child");

            // Build the DOM structure
            root.appendChild(textNode1);
            root.appendChild(child);
            child.appendChild(textNode2);
            doc.appendChild(root);

            // Create an instance of DOMNodePointer with the child node
            DOMNodePointer pointer = new DOMNodePointer(child, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("getRelativePositionOfTextNode");
            method.setAccessible(true);

            // Invoke the method and get the result
            int result = (int) method.invoke(pointer);

            // Assert the expected result
            assertEquals(2, result); // There are 2 text nodes before the child node

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}