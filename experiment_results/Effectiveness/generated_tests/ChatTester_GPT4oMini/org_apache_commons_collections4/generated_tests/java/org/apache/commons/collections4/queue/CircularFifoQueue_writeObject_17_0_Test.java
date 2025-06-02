package org.apache.commons.collections4.queue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
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
        queue.addAll(Arrays.asList("one", "two", "three"));
    }

    @Test
    public void testWriteObject() throws IOException, ClassNotFoundException {
        // Create a ByteArrayOutputStream to write the object to
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        try {
            Method method = CircularFifoQueue.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            method.setAccessible(true);
            // Fixed the buggy line by adding a try-catch for InvocationTargetException
            try {
                method.invoke(queue, objectOutputStream);
            } catch (InvocationTargetException e) {
                fail("Invocation failed: " + e.getCause().getMessage());
            }
        } catch (NoSuchMethodException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        } finally {
            // Close the output stream
            objectOutputStream.close();
        }
        // Now read the object back
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        // Read the size
        int size = objectInputStream.readInt();
        assertEquals(3, size, "Size should be equal to the number of elements added.");
        // Read the elements
        for (int i = 0; i < size; i++) {
            String element = (String) objectInputStream.readObject();
            assertNotNull(element, "Element should not be null.");
        }
        // Close the input stream
        objectInputStream.close();
    }
}
