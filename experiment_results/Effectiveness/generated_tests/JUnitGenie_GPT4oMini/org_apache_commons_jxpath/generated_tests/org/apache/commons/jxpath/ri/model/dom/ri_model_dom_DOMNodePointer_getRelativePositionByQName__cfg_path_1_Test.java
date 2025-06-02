package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_getRelativePositionByQName__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionByQName() {
        try {
            // Setup a sample XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Create nodes for testing
            Element root = doc.createElement("root");
            doc.appendChild(root);
            Element child1 = doc.createElement("child");
            root.appendChild(child1);
            Element child2 = doc.createElement("child");
            root.appendChild(child2);
            Element child3 = doc.createElement("child");
            root.appendChild(child3);

            // Create a DOMNodePointer instance
            DOMNodePointer pointer = new DOMNodePointer(child3, Locale.getDefault());

            // Access the private method using reflection
            Method method = DOMNodePointer.class.getDeclaredMethod("getRelativePositionByQName");
            method.setAccessible(true);

            // Call the method and assert the expected result
            int position = (int) method.invoke(pointer);
            assertEquals(1, position); // child3 is the first child with the same QName

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}