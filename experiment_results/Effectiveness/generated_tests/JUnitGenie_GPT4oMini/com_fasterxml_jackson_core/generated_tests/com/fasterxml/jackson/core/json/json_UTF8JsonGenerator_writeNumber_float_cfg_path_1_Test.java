package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeNumber_float_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteNumberWithValidFloat() {
        // Setup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream);
        
        // Set the necessary internal state for the test using a setter method
        generator.configure(UTF8JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true); // Set to true to trigger the first branch
        float testValue = 123.45f;

        try {
            // Execute
            generator.writeNumber(testValue);
            // Verify
            String expectedOutput = "\"123.45\""; // Expected output based on the implementation (should be quoted)
            assertEquals(expectedOutput, outputStream.toString());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNotFiniteFloat() {
        // Setup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream);
        
        // Set the necessary internal state for the test using a setter method
        generator.configure(UTF8JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false); // Set to false to trigger the second branch
        float testValue = Float.NaN; // Not finite value

        try {
            // Execute
            generator.writeNumber(testValue);
            // Verify
            String expectedOutput = "\"NaN\""; // Expected output based on the implementation (should be quoted)
            assertEquals(expectedOutput, outputStream.toString());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}