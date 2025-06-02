package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_JsonStringEncoder__appendByte_int_int_ByteArrayBuilder_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendByte() {
        try {
            // Instantiate the class
            JsonStringEncoder encoder = new JsonStringEncoder();

            // Prepare the parameters
            int ch = 0x1234; // Example character value
            int esc = -1; // Standard escape
            ByteArrayBuilder bb = new ByteArrayBuilder();
            int ptr = 0; // Initial pointer value

            // Access the private method using reflection
            Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            int result = (int) method.invoke(encoder, ch, esc, bb, ptr);

            // Validate the result
            assertEquals(ptr + 6, result); // Expecting 6 bytes to be appended for the given input

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}