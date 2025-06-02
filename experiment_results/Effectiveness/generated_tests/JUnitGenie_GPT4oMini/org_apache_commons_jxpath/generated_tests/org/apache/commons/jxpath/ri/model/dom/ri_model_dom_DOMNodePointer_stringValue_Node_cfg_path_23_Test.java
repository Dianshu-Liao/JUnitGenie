package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Node;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        // Arrange
        Node commentNode = mock(Node.class);
        when(commentNode.getNodeType()).thenReturn(Node.COMMENT_NODE);
        
        DOMNodePointer domNodePointer = new DOMNodePointer(commentNode, null);

        // Act
        String result = invokeStringValue(domNodePointer, commentNode);

        // Assert
        assertEquals("", result);
    }

    private String invokeStringValue(DOMNodePointer domNodePointer, Node node) {
        try {
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            return (String) method.invoke(domNodePointer, node);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}