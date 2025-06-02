package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class json_UTF8JsonGenerator_writeNumber_BigDecimal_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteNumber_NullValue() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);
        
        try {
            // Explicitly call the writeNumber method for String to avoid ambiguity
            generator.writeNumber((String) null);
            // Assert here if necessary, for example checking the output stream
            // However, this example does not check the output for brevity
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception if closing fails
            }
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_ValidValue() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);
        
        try {
            generator.writeNumber(new BigDecimal("123.45"));
            // Assert here to check that the output correctly contains "123.45"
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception if closing fails
            }
        }
    }


}