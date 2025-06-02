package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NullPropertyPointer_asPath_21_0_Test {

    private NullPropertyPointer pointer;

    private NonContainerParent parent;

    @BeforeEach
    void setUp() {
        parent = new NonContainerParent();
        pointer = new NullPropertyPointer(parent);
    }

    @Test
    void testAsPathWithoutNameAttribute() {
        String path = pointer.asPath();
        assertEquals("expectedPathWithoutNameAttribute", path);
    }

    @Test
    void testAsPathWithNameAttribute() {
        pointer.setNameAttributeValue("testName");
        String path = pointer.asPath();
        assertEquals("expectedPathWithNameAttribute", path);
    }

    private static class NonContainerParent extends NodePointer {

        protected NonContainerParent() {
            super(null);
        }

        public NodePointer getImmediateParentPointer() {
            return null;
        }

        public QName getName() {
            return new QName("nonContainerParent");
        }

        public void setPropertyIndex(int index) {
        }

        public int getLength() {
            return 0;
        }

        public Object getBaseValue() {
            return null;
        }

        public Object getImmediateNode() {
            return null;
        }

        public NodePointer getValuePointer() {
            return this;
        }

        public void setValue(Object value) {
            throw new JXPathInvalidAccessException("Cannot set value on NonContainerParent");
        }

        public int getPropertyCount() {
            return 0;
        }

        public String[] getPropertyNames() {
            return new String[0];
        }

        public boolean isLeaf() {
            return false;
        }

        public int compareChildNodePointers(NodePointer nodePointer1, NodePointer nodePointer2) {
            return 0;
        }

        public boolean isCollection() {
            return false;
        }
    }
}
