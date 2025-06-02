package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeNumber_double_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteNumber_NaN() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        UTF8JsonGenerator generator = new UTF8JsonGenerator(null, 0, null, outputStream);
        try {
            generator.writeNumber(Double.NaN);
            generator.close(); // Ensure the generator is closed to flush the output
            String result = outputStream.toString();
            assertEquals("\"NaN\"", result); // Assuming the output for NaN is quoted
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_PositiveInfinity() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        UTF8JsonGenerator generator = new UTF8JsonGenerator(null, 0, null, outputStream);
        try {
            generator.writeNumber(Double.POSITIVE_INFINITY);
            generator.close(); // Ensure the generator is closed to flush the output
            String result = outputStream.toString();
            assertEquals("\"Infinity\"", result); // Assuming the output for positive infinity is quoted
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_NegativeInfinity() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        UTF8JsonGenerator generator = new UTF8JsonGenerator(null, 0, null, outputStream);
        try {
            generator.writeNumber(Double.NEGATIVE_INFINITY);
            generator.close(); // Ensure the generator is closed to flush the output
            String result = outputStream.toString();
            assertEquals("\"-Infinity\"", result); // Assuming the output for negative infinity is quoted
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}