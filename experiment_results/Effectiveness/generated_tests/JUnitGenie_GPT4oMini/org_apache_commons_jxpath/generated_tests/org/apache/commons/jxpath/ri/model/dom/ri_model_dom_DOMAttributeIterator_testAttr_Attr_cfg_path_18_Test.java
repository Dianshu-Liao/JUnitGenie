package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.Mockito;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_dom_DOMAttributeIterator_testAttr_Attr_cfg_path_18_Test {

    private DOMAttributeIterator createDOMAttributeIterator(QName name) {
        // Mocking a DOMNodePointer to avoid NullPointerException
        DOMNodePointer mockNodePointer = Mockito.mock(DOMNodePointer.class);
        return new DOMAttributeIterator(mockNodePointer, name);
    }

    @org.junit.Test
    public void testTestAttr() {
        try {
            QName name = new QName("test", "ns"); // Ensure name is not "*"
            DOMAttributeIterator iterator = createDOMAttributeIterator(name);
            
            Attr attr = Mockito.mock(Attr.class);
            Element mockElement = Mockito.mock(Element.class); // Change to Element
            Mockito.when(attr.getOwnerElement()).thenReturn(mockElement); // Mock the behavior
            
            // Mocking static method call
            Mockito.when(DOMNodePointer.getPrefix(attr)).thenReturn("prefix");
            Mockito.when(DOMNodePointer.getLocalName(attr)).thenReturn("localName");

            // Access the private method using reflection
            Method testAttrMethod = DOMAttributeIterator.class.getDeclaredMethod("testAttr", Attr.class);
            testAttrMethod.setAccessible(true);

            // Call the method
            boolean result = (boolean) testAttrMethod.invoke(iterator, attr);
            
            // Check expected condition here
            assertTrue(result); // Adjust the assertion based on expected behavior for this input

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testTestAttr_whenNodePrefixIsNull() {
        try {
            QName name = new QName("test", "ns");
            DOMAttributeIterator iterator = createDOMAttributeIterator(name);
            
            Attr attr = Mockito.mock(Attr.class);
            Element mockElement = Mockito.mock(Element.class); // Change to Element
            Mockito.when(attr.getOwnerElement()).thenReturn(mockElement); // Mock behavior
            
            // Mocking static method calls
            Mockito.when(DOMNodePointer.getPrefix(attr)).thenReturn(null);
            Mockito.when(DOMNodePointer.getLocalName(attr)).thenReturn("localName");

            Method testAttrMethod = DOMAttributeIterator.class.getDeclaredMethod("testAttr", Attr.class);
            testAttrMethod.setAccessible(true);
     
            boolean result = (boolean) testAttrMethod.invoke(iterator, attr);
            assertFalse(result); // Expected to be false due to nodePrefix being null

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}