package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.NodeList;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getRelativePositionOfTextNode__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfTextNode() {
        try {
            // Create a sample DOM structure
            Document document = createSampleDOM();
            Node textNode = document.getElementsByTagName("textNode").item(0);
            DOMNodePointer pointer = new DOMNodePointer(textNode, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("getRelativePositionOfTextNode");
            method.setAccessible(true);

            // Invoke the method and get the result
            int result = (int) method.invoke(pointer);

            // Assert the expected result
            assertEquals(2, result); // Assuming there is one previous text node
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document createSampleDOM() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create elements and text nodes
            Element root = document.createElement("root");
            document.appendChild(root);

            Text previousTextNode = document.createTextNode("Previous Text Node");
            root.appendChild(previousTextNode);

            Text currentTextNode = document.createTextNode("Current Text Node");
            root.appendChild(currentTextNode);
            // Removed the setNodeName call as it is not a valid method for Text nodes

            // To identify the current text node, we can wrap it in an element
            Element currentElement = document.createElement("textNode");
            currentElement.appendChild(currentTextNode);
            root.appendChild(currentElement);

            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // In case of an error, return null
        }
    }


}