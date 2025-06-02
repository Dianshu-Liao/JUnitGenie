package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Method;

public class ri_model_dom_DOMAttributeIterator_testAttr_Attr_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testTestAttrWithValidNode() {
        try {
            // Setup
            NodePointer mockParent = Mockito.mock(NodePointer.class);
            QName mockName = Mockito.mock(QName.class);
            Mockito.when(mockName.getName()).thenReturn("*");
            Mockito.when(mockName.getPrefix()).thenReturn("prefix");

            DOMAttributeIterator iterator = new DOMAttributeIterator(mockParent, mockName);
            org.w3c.dom.Attr mockAttr = Mockito.mock(org.w3c.dom.Attr.class);
            Mockito.when(mockAttr.getPrefix()).thenReturn("somePrefix");
            Mockito.when(mockAttr.getLocalName()).thenReturn("someLocalName");

            // Invoke the private method using reflection
            Method method = DOMAttributeIterator.class.getDeclaredMethod("testAttr", org.w3c.dom.Attr.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(iterator, mockAttr);

            // Assert
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTestAttrWithNullPrefix() {
        try {
            // Setup
            NodePointer mockParent = Mockito.mock(NodePointer.class);
            QName mockName = Mockito.mock(QName.class);
            Mockito.when(mockName.getName()).thenReturn("*");
            Mockito.when(mockName.getPrefix()).thenReturn(null);

            DOMAttributeIterator iterator = new DOMAttributeIterator(mockParent, mockName);
            org.w3c.dom.Attr mockAttr = Mockito.mock(org.w3c.dom.Attr.class);
            Mockito.when(mockAttr.getPrefix()).thenReturn(null);
            Mockito.when(mockAttr.getLocalName()).thenReturn("someLocalName");

            // Invoke the private method using reflection
            Method method = DOMAttributeIterator.class.getDeclaredMethod("testAttr", org.w3c.dom.Attr.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(iterator, mockAttr);
            
            // Assert
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTestAttrWithXmlnsPrefix() {
        try {
            // Setup
            NodePointer mockParent = Mockito.mock(NodePointer.class);
            QName mockName = Mockito.mock(QName.class);
            Mockito.when(mockName.getName()).thenReturn("someLocalName");
            Mockito.when(mockName.getPrefix()).thenReturn("somePrefix");

            DOMAttributeIterator iterator = new DOMAttributeIterator(mockParent, mockName);
            org.w3c.dom.Attr mockAttr = Mockito.mock(org.w3c.dom.Attr.class);
            Mockito.when(mockAttr.getPrefix()).thenReturn("xmlns");
            Mockito.when(mockAttr.getLocalName()).thenReturn("someLocalName");

            // Invoke the private method using reflection
            Method method = DOMAttributeIterator.class.getDeclaredMethod("testAttr", org.w3c.dom.Attr.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(iterator, mockAttr);
            
            // Assert
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}