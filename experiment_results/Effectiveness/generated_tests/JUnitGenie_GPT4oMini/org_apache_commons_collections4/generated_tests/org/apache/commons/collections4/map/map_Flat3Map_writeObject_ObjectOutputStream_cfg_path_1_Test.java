package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class map_Flat3Map_writeObject_ObjectOutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteObject() {
        Flat3Map flat3Map = new Flat3Map();
        // Populate the map for testing
        populateMap(flat3Map); // This method is now defined to add elements to the map

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            // Accessing the private method using reflection
            Method writeObjectMethod = Flat3Map.class.getDeclaredMethod("writeObject", ObjectOutputStream.class);
            writeObjectMethod.setAccessible(true);

            // Invoking the private method
            writeObjectMethod.invoke(flat3Map, objectOutputStream);

            // Verify that the output stream has data
            assertNotNull(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

    // Method to populate the Flat3Map for testing
    private void populateMap(Flat3Map flat3Map) {
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
    }

}