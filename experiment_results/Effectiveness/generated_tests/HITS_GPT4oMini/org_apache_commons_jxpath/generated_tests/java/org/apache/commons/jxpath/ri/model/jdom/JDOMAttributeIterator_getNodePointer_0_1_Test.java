package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import java.util.Collections;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.jdom.Element;
import org.jdom.Namespace;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JDOMAttributeIterator_getNodePointer_0_1_Test {

    private NodePointer mockParent;

    private TestableJDOMAttributeIterator iterator;

    private QName mockQName;

    private class TestableJDOMAttributeIterator extends JDOMAttributeIterator {

        public TestableJDOMAttributeIterator(NodePointer parent, QName name) {
            super(parent, name);
        }

        public void setAttributesForTest(List<Attribute> attributes) {
            // Use reflection to set the private attributes field
            try {
                java.lang.reflect.Field field = JDOMAttributeIterator.class.getDeclaredField("attributes");
                field.setAccessible(true);
                field.set(this, attributes);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void setPositionForTest(int position) {
            setPosition(position);
        }
    }

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        mockQName = mock(QName.class);
        iterator = new TestableJDOMAttributeIterator(mockParent, mockQName);
    }

    @Test
    public void testGetNodePointer_WhenPositionIsZeroAndSetPositionFails() {
        // Arrange
        when(iterator.setPosition(1)).thenReturn(false);
        iterator.setPositionForTest(0);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNull(result, "Expected getNodePointer() to return null when setPosition(1) fails.");
    }

    @Test
    public void testGetNodePointer_WhenPositionIsZeroAndSetPositionSucceeds() {
        // Arrange
        when(iterator.setPosition(1)).thenReturn(true);
        iterator.setPositionForTest(0);
        // Prepare mock for the attributes list
        Attribute mockAttribute = mock(Attribute.class);
        iterator.setAttributesForTest(Collections.singletonList(mockAttribute));
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result, "Expected getNodePointer() to return a non-null NodePointer when setPosition(1) succeeds.");
        assertTrue(result instanceof JDOMAttributePointer, "Expected result to be an instance of JDOMAttributePointer.");
    }

    @Test
    public void testGetNodePointer_WhenPositionIsNotZero() {
        // Arrange
        iterator.setPositionForTest(1);
        Attribute mockAttribute = mock(Attribute.class);
        iterator.setAttributesForTest(Collections.singletonList(mockAttribute));
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result, "Expected getNodePointer() to return a non-null NodePointer when position is not zero.");
        assertTrue(result instanceof JDOMAttributePointer, "Expected result to be an instance of JDOMAttributePointer.");
    }
}
