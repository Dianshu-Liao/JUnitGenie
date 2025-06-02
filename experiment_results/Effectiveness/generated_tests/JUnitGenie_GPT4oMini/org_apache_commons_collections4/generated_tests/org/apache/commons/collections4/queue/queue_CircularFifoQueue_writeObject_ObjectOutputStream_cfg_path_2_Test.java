package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class queue_CircularFifoQueue_writeObject_ObjectOutputStream_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteObject() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5); // Initialize with a positive maxElements
        // Ensure the queue is empty to satisfy the hasNext() condition
        try {
            // Prepare the output stream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            // Use reflection to access the private method
            Method writeObjectMethod = CircularFifoQueue.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            writeObjectMethod.setAccessible(true);

            // Invoke the private method
            // The ObjectOutputStream must be in a valid state for writing
            objectOutputStream.defaultWriteObject(); // Call this to ensure the stream is active
            writeObjectMethod.invoke(queue, objectOutputStream);

            // Verify the output stream content
            // Since the queue is empty, we expect the size to be 0
            objectOutputStream.flush();
            byte[] result = byteArrayOutputStream.toByteArray();
            // The first 4 bytes should represent the integer size (0)
            assertEquals(0, result[0]);
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

}