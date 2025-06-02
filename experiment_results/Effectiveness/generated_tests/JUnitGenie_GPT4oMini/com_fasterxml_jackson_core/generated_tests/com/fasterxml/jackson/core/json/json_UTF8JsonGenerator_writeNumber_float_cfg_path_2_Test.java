package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeNumber_float_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteNumberWithFiniteFloat() {
        // Setup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream);

        float finiteFloat = 1.23f; // A finite float value

        try {
            // Execute
            generator.writeNumber(finiteFloat);
            // Verify
            String expectedOutput = "1.23"; // Expected output based on the implementation
            assertEquals(expectedOutput, outputStream.toString());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            // Close the generator to release resources
            try {
                generator.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNonFiniteFloat() {
        // Setup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream);

        float nonFiniteFloat = Float.NaN; // A non-finite float value

        try {
            // Execute
            generator.writeNumber(nonFiniteFloat);
            // Verify
            String expectedOutput = "NaN"; // Expected output based on the implementation
            assertEquals(expectedOutput, outputStream.toString());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            // Close the generator to release resources
            try {
                generator.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}