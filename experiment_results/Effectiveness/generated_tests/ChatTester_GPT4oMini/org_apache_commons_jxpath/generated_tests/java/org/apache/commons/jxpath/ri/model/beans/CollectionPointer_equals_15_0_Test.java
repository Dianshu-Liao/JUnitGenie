package org.apache.commons.jxpath.ri.model.beans;

import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class CollectionPointer_equals_15_0_Test {

    private static class CollectionPointer {

        private Object collection;

        // Assuming index is an int based on the usage in equals
        private int index;

        private NodePointer valuePointer;

        private static final long serialVersionUID = 8620254915563256588L;

        public CollectionPointer(final Object collection, final Locale locale) {
            this.collection = collection;
            // default index
            this.index = 0;
        }

        public CollectionPointer(final NodePointer parent, final Object collection) {
            this.collection = collection;
            // default index
            this.index = 0;
        }

        @Override
        public boolean equals(final Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof CollectionPointer)) {
                return false;
            }
            final CollectionPointer other = (CollectionPointer) object;
            return collection == other.collection && index == other.index;
        }
    }

    private static class NodePointer {
        // Assuming some fields and methods are here
    }

    @Test
    public void testEquals_SameInstance() {
        CollectionPointer pointer = new CollectionPointer(new Object(), Locale.ENGLISH);
        assertTrue(pointer.equals(pointer));
    }

    @Test
    public void testEquals_DifferentType() {
        CollectionPointer pointer = new CollectionPointer(new Object(), Locale.ENGLISH);
        assertFalse(pointer.equals(new Object()));
    }

    @Test
    public void testEquals_SameValues() {
        Object collection = new Object();
        CollectionPointer pointer1 = new CollectionPointer(collection, Locale.ENGLISH);
        CollectionPointer pointer2 = new CollectionPointer(collection, Locale.ENGLISH);
        assertTrue(pointer1.equals(pointer2));
    }

    @Test
    public void testEquals_DifferentCollections() {
        CollectionPointer pointer1 = new CollectionPointer(new Object(), Locale.ENGLISH);
        CollectionPointer pointer2 = new CollectionPointer(new Object(), Locale.ENGLISH);
        assertFalse(pointer1.equals(pointer2));
    }

    @Test
    public void testEquals_DifferentIndex() {
        Object collection = new Object();
        CollectionPointer pointer1 = new CollectionPointer(collection, Locale.ENGLISH);
        CollectionPointer pointer2 = new CollectionPointer(collection, Locale.ENGLISH);
        // Set different index
        pointer2.index = 1;
        assertFalse(pointer1.equals(pointer2));
    }
}
