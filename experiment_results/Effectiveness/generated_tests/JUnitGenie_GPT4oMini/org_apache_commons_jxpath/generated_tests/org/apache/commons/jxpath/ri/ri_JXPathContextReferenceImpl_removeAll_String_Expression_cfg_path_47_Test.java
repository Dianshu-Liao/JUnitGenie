package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.junit.Test;
import java.util.Iterator;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class ri_JXPathContextReferenceImpl_removeAll_String_Expression_cfg_path_47_Test {

    @Test(timeout = 4000)
    public void testRemoveAll() {
        // Create a mock of the Expression
        Expression expr = mock(Expression.class);
        EvalContext evalContext = mock(EvalContext.class);
        NodePointer nodePointer = mock(NodePointer.class);
        Iterator<NodePointer> pointerIterator = new ArrayList<NodePointer>() {{ add(nodePointer); }}.iterator();

        // Setup the mock behavior
        when(expr.iteratePointers(any(EvalContext.class))).thenReturn(pointerIterator);
        when(nodePointer.asPath()).thenReturn("mockPath");
        
        // Create an instance of the class to be tested
        JXPathContextReferenceImpl jXPathContextReferenceImpl = new JXPathContextReferenceImpl(null, new Object());

        // Call the method under test
        try {
            jXPathContextReferenceImpl.removeAll("mockXPath", expr);
        } catch (JXPathException e) {
            // Handling the thrown exception if any occurs
            e.printStackTrace();
        }

        // Verify the interactions
        verify(nodePointer).remove();
    }
    
    @Test(timeout = 4000)
    public void testRemoveAllWithException() {
        // Create a mock of the Expression
        Expression expr = mock(Expression.class);
        EvalContext evalContext = mock(EvalContext.class);
        NodePointer nodePointer = mock(NodePointer.class);
        Iterator<NodePointer> pointerIterator = new ArrayList<NodePointer>() {{ add(nodePointer); }}.iterator();

        // Setup the mock behavior
        when(expr.iteratePointers(any(EvalContext.class))).thenReturn(pointerIterator);
        when(nodePointer.asPath()).thenThrow(new RuntimeException("Mock exception"));

        // Create an instance of the class to be tested
        JXPathContextReferenceImpl jXPathContextReferenceImpl = new JXPathContextReferenceImpl(null, new Object());

        // Call the method under test expecting an exception
        try {
            jXPathContextReferenceImpl.removeAll("mockXPath", expr);
        } catch (JXPathException e) {
            // Assert that the exception is thrown with the expected message
            assertEquals("Exception trying to remove all for xpath mockXPath", e.getMessage());
        }
    }


}