package org.apache.commons.collections4.queue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.io.Serializable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectInputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

public class CircularFifoQueue_writeObject_17_0_Test {

    private CircularFifoQueue<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new CircularFifoQueue<>(5);
    }

    private void invokeWriteObject(CircularFifoQueue<String> queue, ObjectOutputStream out) throws Exception {
        Method writeObjectMethod = CircularFifoQueue.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
        writeObjectMethod.setAccessible(true);
        writeObjectMethod.invoke(queue, out);
    }

    @Test
    public void testWriteObjectEmptyQueue() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        invokeWriteObject(queue, objectOutputStream);
        objectOutputStream.flush();
        assertEquals(4, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteObjectNonEmptyQueue() throws Exception {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        invokeWriteObject(queue, objectOutputStream);
        objectOutputStream.flush();
        assertEquals(4 + 3 * 2, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteObjectWithFullQueue() throws Exception {
        queue.addAll(Arrays.asList("A", "B", "C", "D", "E"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        invokeWriteObject(queue, objectOutputStream);
        objectOutputStream.flush();
        assertEquals(4 + 5 * 2, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteObjectHandlesIOException() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = Mockito.mock(ObjectOutputStream.class);
        doThrow(new IOException("Forced IOException")).when(objectOutputStream).writeObject(Mockito.any());
        assertThrows(IOException.class, () -> invokeWriteObject(queue, objectOutputStream));
    }
}
