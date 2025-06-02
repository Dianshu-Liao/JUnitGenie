package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class ri_model_dom_DOMNodePointer_setValue_Object_cfg_path_16_Test {
    private Node mockNode;
    private DOMNodePointer domNodePointer;
    private Document mockDocument; // Declare mockDocument here

    @Before
    public void setUp() {
        // Initialize a mock Document and Node for testing
        mockDocument = Mockito.mock(Document.class); // Create a mock Document
        mockNode = Mockito.mock(Element.class); // Create a mock Node
        Mockito.when(mockDocument.createElement(Mockito.anyString())).thenReturn((Element) mockNode); // Cast mockNode to Element
        domNodePointer = new DOMNodePointer(mockNode, null);
    }

    @Test(timeout = 4000)
    public void testSetValueWithTextNode() {
        // Set up the node to be a text node
        Node textNode = mockDocument.createTextNode("Initial Value");
        mockNode.appendChild(textNode);
        
        // Call the method under test
        domNodePointer.setValue("New Value");

        // Verify the node value has been updated
        assertEquals("New Value", textNode.getNodeValue());
    }

    @Test(timeout = 4000)
    public void testSetValueWithEmptyString() {
        // Set up the node to be a text node
        Node textNode = mockDocument.createTextNode("Initial Value");
        mockNode.appendChild(textNode);
        
        // Call the method under test with an empty string
        domNodePointer.setValue("");

        // Verify the node has been removed
        assertNull(mockNode.getFirstChild());
    }

    @Test(timeout = 4000)
    public void testSetValueWithNode() {
        // Create a new element node to set as value
        Element newElement = mockDocument.createElement("newElement");
        newElement.appendChild(mockDocument.createTextNode("Child Node"));

        // Call the method under test
        domNodePointer.setValue(newElement);

        // Verify the new element has been appended
        NodeList children = mockNode.getChildNodes();
        assertEquals(1, children.getLength());
        assertEquals("newElement", children.item(0).getNodeName());
    }

    @Test(timeout = 4000)
    public void testSetValueWithNull() {
        // Set up the node to be a text node
        Node textNode = mockDocument.createTextNode("Initial Value");
        mockNode.appendChild(textNode);

        // Call the method under test with null
        domNodePointer.setValue(null);

        // Verify the node value remains unchanged
        assertEquals("Initial Value", textNode.getNodeValue());
    }

}