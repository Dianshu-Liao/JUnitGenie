package org.apache.commons.collections4.queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

class CircularFifoQueue_writeObject_17_2_Test {

    private CircularFifoQueue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new CircularFifoQueue<>(3);
    }

    @Test
    void testWriteObject() throws IOException {
        // Add elements to the queue
        queue.add("A");
        queue.add("B");
        queue.add("C");
        // Serialize the CircularFifoQueue
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        // Use reflection to invoke the private writeObject method
        try {
            Method method = CircularFifoQueue.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            method.setAccessible(true);
            method.invoke(queue, out);
        } catch (Exception e) {
            fail("Exception during serialization: " + e.getMessage());
        }
        out.close();
        byteOut.close();
        // Deserialize the CircularFifoQueue
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        CircularFifoQueue<String> deserializedQueue = null;
        try {
            deserializedQueue = (CircularFifoQueue<String>) in.readObject();
        } catch (ClassNotFoundException e) {
            fail("Class not found during deserialization: " + e.getMessage());
        }
        in.close();
        byteIn.close();
        // Verify the deserialized queue
        assertNotNull(deserializedQueue);
        assertEquals(3, deserializedQueue.size());
        assertArrayEquals(new String[] { "A", "B", "C" }, deserializedQueue.toArray());
    }

    @Test
    void testWriteObjectEmptyQueue() throws IOException {
        // Serialize the empty CircularFifoQueue
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        // Use reflection to invoke the private writeObject method
        try {
            Method method = CircularFifoQueue.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            method.setAccessible(true);
            method.invoke(queue, out);
        } catch (Exception e) {
            fail("Exception during serialization: " + e.getMessage());
        }
        out.close();
        byteOut.close();
        // Deserialize the CircularFifoQueue
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        CircularFifoQueue<String> deserializedQueue = null;
        try {
            deserializedQueue = (CircularFifoQueue<String>) in.readObject();
        } catch (ClassNotFoundException e) {
            fail("Class not found during deserialization: " + e.getMessage());
        }
        in.close();
        byteIn.close();
        // Verify the deserialized empty queue
        assertNotNull(deserializedQueue);
        assertEquals(0, deserializedQueue.size());
    }
}
