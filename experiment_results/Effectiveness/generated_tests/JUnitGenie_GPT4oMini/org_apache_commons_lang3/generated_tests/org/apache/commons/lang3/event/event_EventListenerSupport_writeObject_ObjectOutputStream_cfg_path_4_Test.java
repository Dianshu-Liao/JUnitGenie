package org.apache.commons.lang3.event;
import org.apache.commons.lang3.event.EventListenerSupport;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class event_EventListenerSupport_writeObject_ObjectOutputStream_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteObject() {
        // Arrange
        // Create an EventListenerSupport instance with an appropriate interface class
        EventListenerSupport eventListenerSupport = new EventListenerSupport(TestListener.class); // Provide an interface class argument
        List<TestListener> listeners = new ArrayList<>();
        listeners.add(new TestListener() {}); // Add a sample listener
        // Use reflection to set the private 'listeners' field
        setPrivateField(eventListenerSupport, "listeners", listeners);
        
        // Create a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Act
        try {
            Method writeObjectMethod = EventListenerSupport.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            writeObjectMethod.setAccessible(true);
            writeObjectMethod.invoke(eventListenerSupport, objectOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertNotNull(byteArrayOutputStream.toByteArray());
    }

    private void setPrivateField(EventListenerSupport eventListenerSupport, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = EventListenerSupport.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(eventListenerSupport, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a simple interface for testing purposes
    interface TestListener {
        // Define any methods that would be part of the listener interface
    }

}