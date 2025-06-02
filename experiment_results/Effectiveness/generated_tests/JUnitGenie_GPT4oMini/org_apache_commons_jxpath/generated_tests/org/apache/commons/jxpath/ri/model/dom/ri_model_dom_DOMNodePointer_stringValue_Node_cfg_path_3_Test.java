package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstruction() {
        // Arrange
        Node node = mock(ProcessingInstruction.class);
        when(node.getNodeType()).thenReturn(Node.PROCESSING_INSTRUCTION_NODE);
        when(((ProcessingInstruction) node).getData()).thenReturn("   Some Data   ");
        
        DOMNodePointer domNodePointer = new DOMNodePointer(node, null);

        // Act
        String result = "";
        try {
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            result = (String) method.invoke(domNodePointer, node);
        } catch (Exception e) {
            // Handle exception
        }

        // Assert
        assertEquals("Some Data", result);
    }
    
    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        // Arrange
        Node node = mock(Node.class);
        when(node.getNodeType()).thenReturn(Node.COMMENT_NODE);
        
        DOMNodePointer domNodePointer = new DOMNodePointer(node, null);

        // Act
        String result = "";
        try {
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            result = (String) method.invoke(domNodePointer, node);
        } catch (Exception e) {
            // Handle exception
        }

        // Assert
        assertEquals("", result);
    }
    
    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        // Arrange
        Node node = mock(Node.class);
        when(node.getNodeType()).thenReturn(Node.TEXT_NODE);
        when(node.getNodeValue()).thenReturn("   Hello World   ");
        
        DOMNodePointer domNodePointer = new DOMNodePointer(node, null);

        // Act
        String result = "";
        try {
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            result = (String) method.invoke(domNodePointer, node);
        } catch (Exception e) {
            // Handle exception
        }

        // Assert
        assertEquals("Hello World", result);
    }

}