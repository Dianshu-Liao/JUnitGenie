package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeNumber_double_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteNumberWithNonFiniteValue() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);

        try {
            generator.writeNumber(Double.NaN); // Testing with a non-finite value
            String result = outputStream.toString("UTF-8");
            // Validate the output as per the expected behavior for non-finite values
            assertEquals("\"NaN\"", result.trim());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithFiniteValue() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);

        try {
            generator.writeNumber(123.456); // Testing with a finite value
            String result = outputStream.toString("UTF-8");
            // Validate the output as per the expected behavior for finite values
            assertEquals("123.456", result.trim());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}