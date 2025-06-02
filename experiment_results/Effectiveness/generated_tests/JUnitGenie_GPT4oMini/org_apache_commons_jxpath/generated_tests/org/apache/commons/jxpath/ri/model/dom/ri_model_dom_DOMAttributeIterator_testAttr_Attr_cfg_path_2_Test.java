package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributeIterator;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.mockito.Mockito;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_dom_DOMAttributeIterator_testAttr_Attr_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTestAttr() {
        try {
            // Create a mock Attr object
            Attr mockAttr = Mockito.mock(Attr.class);
            Node mockNode = Mockito.mock(Node.class);
            QName mockQName = Mockito.mock(QName.class);
            DOMNodePointer mockNodePointer = Mockito.mock(DOMNodePointer.class);
            
            // Set up the mock behavior
            Mockito.when(mockNodePointer.getPrefix(mockAttr)).thenReturn("prefix");
            Mockito.when(mockNodePointer.getLocalName(mockAttr)).thenReturn("localName");
            Mockito.when(mockQName.getName()).thenReturn("localName");
            Mockito.when(mockQName.getPrefix()).thenReturn("prefix");

            // Create an instance of DOMAttributeIterator
            DOMAttributeIterator iterator = new DOMAttributeIterator(mockNodePointer, mockQName);
            
            // Access the private method using reflection
            Method method = DOMAttributeIterator.class.getDeclaredMethod("testAttr", Attr.class);
            method.setAccessible(true);
            
            // Test case where nodePrefix is not null and equals "prefix"
            boolean result = (boolean) method.invoke(iterator, mockAttr);
            assertTrue(result);

            // Test case where nodePrefix is null
            Mockito.when(mockNodePointer.getPrefix(mockAttr)).thenReturn(null);
            result = (boolean) method.invoke(iterator, mockAttr);
            assertFalse(result);

            // Test case where nodeLocalName equals "xmlns"
            Mockito.when(mockNodePointer.getLocalName(mockAttr)).thenReturn("xmlns");
            result = (boolean) method.invoke(iterator, mockAttr);
            assertFalse(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}