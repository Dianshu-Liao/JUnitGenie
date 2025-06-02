package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_JsonStringEncoder__appendByte_int_int_ByteArrayBuilder_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendByte() {
        try {
            // Create an instance of JsonStringEncoder
            JsonStringEncoder encoder = new JsonStringEncoder();
            
            // Prepare the parameters for the focal method
            int ch = 100; // valid input within the range
            int esc = -1; // standard escape
            ByteArrayBuilder bb = new ByteArrayBuilder(); // instance of ByteArrayBuilder
            int ptr = 0; // initial pointer
            
            // Invoke the private method _appendByte using reflection
            Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
            method.setAccessible(true); // allow access to the private method
            
            // Call the method and get the result
            int result = (int) method.invoke(encoder, ch, esc, bb, ptr);
            
            // Validate the result
            assertEquals(ptr, result);
            // Further assertions can be added to validate the content in bb if necessary
            
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception if necessary
        }
    }

}