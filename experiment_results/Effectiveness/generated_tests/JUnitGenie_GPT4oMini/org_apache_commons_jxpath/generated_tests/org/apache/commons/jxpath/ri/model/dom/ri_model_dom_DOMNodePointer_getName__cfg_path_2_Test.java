package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.Assert.assertNotNull;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_getName__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetNameForElementNode() {
        try {
            // Setup a Document and an Element Node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = document.createElement("testElement");
            document.appendChild(element);

            // Create an instance of DOMNodePointer with the Element Node
            DOMNodePointer pointer = new DOMNodePointer((Node) element, Locale.getDefault());

            // Call the getName method
            QName result = pointer.getName();

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetNameForProcessingInstructionNode() {
        try {
            // Setup a Processing Instruction Node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            ProcessingInstruction pi = document.createProcessingInstruction("target", "data");
            document.appendChild(pi);

            // Create an instance of DOMNodePointer with the Processing Instruction Node
            DOMNodePointer pointer = new DOMNodePointer((Node) pi, Locale.getDefault());

            // Call the getName method
            QName result = pointer.getName();

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}