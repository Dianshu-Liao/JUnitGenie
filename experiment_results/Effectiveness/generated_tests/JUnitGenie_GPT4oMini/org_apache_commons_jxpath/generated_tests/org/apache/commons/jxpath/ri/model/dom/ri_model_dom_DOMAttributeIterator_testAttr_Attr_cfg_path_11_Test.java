package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ri_model_dom_DOMAttributeIterator_testAttr_Attr_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testTestAttr() {
        try {
            // Create mock objects for the dependencies
            NodePointer parentMock = mock(NodePointer.class);
            QName nameMock = mock(QName.class);
            Attr attrMock = mock(Attr.class);
            Element nodeMock = mock(Element.class); // Change Node to Element

            // Set up the behavior of the mocks
            when(attrMock.getOwnerElement()).thenReturn(nodeMock);
            when(nodeMock.getNodeName()).thenReturn("testNode");

            // Create an instance of the class under test
            DOMAttributeIterator iterator = new DOMAttributeIterator(parentMock, nameMock);

            // Set the name mock to return a specific name
            when(nameMock.getName()).thenReturn("testName");
            when(nameMock.getPrefix()).thenReturn(null); // Test with null prefix

            // Set up the behavior for getPrefix and getLocalName
            when(DOMNodePointer.getPrefix(attrMock)).thenReturn("testPrefix");
            when(DOMNodePointer.getLocalName(attrMock)).thenReturn("testLocalName");

            // Access the private method using reflection
            Method method = DOMAttributeIterator.class.getDeclaredMethod("testAttr", Attr.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(iterator, attrMock);
            assertTrue(result); // Expecting true based on the setup

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTestAttrWithXmlnsPrefix() {
        try {
            // Create mock objects for the dependencies
            NodePointer parentMock = mock(NodePointer.class);
            QName nameMock = mock(QName.class);
            Attr attrMock = mock(Attr.class);
            Element nodeMock = mock(Element.class); // Change Node to Element

            // Set up the behavior of the mocks
            when(attrMock.getOwnerElement()).thenReturn(nodeMock);
            when(nodeMock.getNodeName()).thenReturn("testNode");

            // Create an instance of the class under test
            DOMAttributeIterator iterator = new DOMAttributeIterator(parentMock, nameMock);

            // Set the name mock to return a specific name
            when(nameMock.getName()).thenReturn("testName");
            when(nameMock.getPrefix()).thenReturn("testPrefix"); // Test with a specific prefix

            // Set up the behavior for getPrefix and getLocalName
            when(DOMNodePointer.getPrefix(attrMock)).thenReturn("xmlns"); // This should trigger the false return
            when(DOMNodePointer.getLocalName(attrMock)).thenReturn("testLocalName");

            // Access the private method using reflection
            Method method = DOMAttributeIterator.class.getDeclaredMethod("testAttr", Attr.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(iterator, attrMock);
            assertFalse(result); // Expecting false due to xmlns prefix

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}