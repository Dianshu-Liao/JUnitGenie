package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_2_Test {
    private DOMNodePointer domNodePointer;
    private Node mockNode;
    private Document mockDocument;

    @Before
    public void setUp() throws Exception {
        // Create a mock Document for testing
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        mockDocument = builder.newDocument();
        
        mockNode = mockDocument.createElement("mockNode");
        mockDocument.appendChild(mockNode); // Append the mockNode to the document
        domNodePointer = new DOMNodePointer(mockNode, null);
    }

    @Test(timeout = 4000)
    public void testSetValueWithTextNode() {
        try {
            // Set up a text node
            Text textNode = mockNode.getOwnerDocument().createTextNode("Initial Value");
            mockNode.appendChild(textNode);
            domNodePointer.setValue("New Value");

            // Verify the node value is updated
            assertEquals("New Value", textNode.getNodeValue());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        try {
            // Set up a text node
            Text textNode = mockNode.getOwnerDocument().createTextNode("Initial Value");
            mockNode.appendChild(textNode);
            domNodePointer.setValue("");

            // Verify the node is removed
            assertNull(textNode.getNodeValue());
            assertEquals(0, mockNode.getChildNodes().getLength());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        try {
            // Create a new element node
            Element newElement = mockDocument.createElement("newElement");
            domNodePointer.setValue(newElement);

            // Verify the new element is appended
            assertEquals(1, mockNode.getChildNodes().getLength());
            assertEquals("newElement", mockNode.getChildNodes().item(0).getNodeName());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}