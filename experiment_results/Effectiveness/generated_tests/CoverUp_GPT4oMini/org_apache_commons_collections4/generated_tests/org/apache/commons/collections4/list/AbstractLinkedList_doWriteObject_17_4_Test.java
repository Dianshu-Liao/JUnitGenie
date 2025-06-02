package org.apache.commons.collections4.list;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.lang.reflect.Array;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectInputStream;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_doWriteObject_17_4_Test {

    private AbstractLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new TestLinkedList(Arrays.asList("A", "B", "C"));
    }

    @Test
    void testDoWriteObject() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        // Invoke the private method using reflection
        invokeDoWriteObject(objectOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();
        // Verify the size is written correctly
        // Size of the list is 3
        assertEquals(3, readInt(data, 0));
        // Further checks could be added here
    }

    private void invokeDoWriteObject(ObjectOutputStream outputStream) throws IOException {
        try {
            Method method = AbstractLinkedList.class.getDeclaredMethod("doWriteObject", ObjectOutputStream.class);
            method.setAccessible(true);
            method.invoke(list, outputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int readInt(byte[] data, int offset) {
        return ((data[offset] & 0xFF) << 24) | ((data[offset + 1] & 0xFF) << 16) | ((data[offset + 2] & 0xFF) << 8) | (data[offset + 3] & 0xFF);
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

        public TestLinkedList(Collection<? extends String> coll) {
            super(coll);
        }

        @Override
        public String getFirst() {
            return super.getFirst();
        }

        @Override
        public String getLast() {
            return super.getLast();
        }

        @Override
        public int size() {
            return super.size();
        }

        @Override
        protected void doWriteObject(ObjectOutputStream outputStream) throws IOException {
            super.doWriteObject(outputStream);
        }
    }
}
