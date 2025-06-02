package org.apache.commons.lang3.event;
import org.apache.commons.lang3.event.EventListenerSupport;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.List;
import static org.junit.Assert.fail;

public class event_EventListenerSupport_writeObject_ObjectOutputStream_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteObject() {
        // Create an instance of EventListenerSupport with appropriate parameters
        // The second parameter should not be null; it should be a valid ClassLoader
        EventListenerSupport eventListenerSupport = new EventListenerSupport(EventListenerSupport.class, EventListenerSupport.class.getClassLoader());
        
        // Assuming we have a way to add listeners to the eventListenerSupport
        // eventListenerSupport.addListener(new SomeListener());

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            
            // Accessing the private method using reflection
            Method writeObjectMethod = EventListenerSupport.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            writeObjectMethod.setAccessible(true);
            
            // Invoke the private method
            writeObjectMethod.invoke(eventListenerSupport, objectOutputStream);
        } catch (IOException e) {
            // Handle IOException
            fail("IOException occurred: " + e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            fail("Exception occurred: " + e.getMessage());
        }
    }

}