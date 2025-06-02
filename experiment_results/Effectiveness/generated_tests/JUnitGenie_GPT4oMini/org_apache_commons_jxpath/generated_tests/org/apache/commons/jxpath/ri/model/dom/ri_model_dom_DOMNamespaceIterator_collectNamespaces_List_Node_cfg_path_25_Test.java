package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNamespaceIterator;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNamespaceIterator_collectNamespaces_List_Node_cfg_path_25_Test {

    private DOMNamespaceIterator domNamespaceIterator;

    @Before
    public void setUp() {
        // Initialize the DOMNamespaceIterator with a mock NodePointer
        domNamespaceIterator = new DOMNamespaceIterator(Mockito.mock(org.apache.commons.jxpath.ri.model.NodePointer.class));
    }

    @Test(timeout = 4000)
    public void testCollectNamespaces() {
        List<Attr> attributes = new ArrayList<>();
        Node mockNode = Mockito.mock(Node.class);
        Node mockParentNode = Mockito.mock(Node.class);
        NamedNodeMap mockNamedNodeMap = Mockito.mock(NamedNodeMap.class);
        Attr mockAttr = Mockito.mock(Attr.class);

        // Set up the mock behavior
        Mockito.when(mockNode.getParentNode()).thenReturn(mockParentNode);
        Mockito.when(mockNode.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        Mockito.when(mockNode.getAttributes()).thenReturn(mockNamedNodeMap);
        Mockito.when(mockNamedNodeMap.getLength()).thenReturn(1);
        Mockito.when(mockNamedNodeMap.item(0)).thenReturn(mockAttr);
        Mockito.when(mockAttr.getNodeName()).thenReturn("xmlns:test");
        Mockito.when(mockAttr.getPrefix()).thenReturn(null); // This will ensure getPrefix() returns null
        Mockito.when(mockAttr.getLocalName()).thenReturn("test"); // Corrected local name to match the prefix

        try {
            // Invoke the private method using reflection
            java.lang.reflect.Method method = DOMNamespaceIterator.class.getDeclaredMethod("collectNamespaces", List.class, Node.class);
            method.setAccessible(true);
            method.invoke(domNamespaceIterator, attributes, mockNode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify that the attribute was added to the list
        assertEquals(1, attributes.size());
        assertEquals(mockAttr, attributes.get(0));
    }


}