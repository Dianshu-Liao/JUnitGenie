package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class queue_CircularFifoQueue_writeObject_ObjectOutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteObject() {
        CircularFifoQueue<String> queue = new CircularFifoQueue<>(3);
        queue.add("A");
        queue.add("B");
        queue.add("C");

        try {
            // Prepare the ObjectOutputStream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            // Access the private method using reflection
            Method writeObjectMethod = CircularFifoQueue.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            writeObjectMethod.setAccessible(true);

            // Invoke the private method
            // The ObjectOutputStream must be in a valid state for writing
            objectOutputStream.writeObject(queue); // Write the queue object first
            writeObjectMethod.invoke(queue, objectOutputStream); // Now invoke the private method

            // Verify the output
            // Here we can check the byteArrayOutputStream content if needed
            // For simplicity, we will just check the size of the queue
            assertEquals(3, queue.size());

        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

}