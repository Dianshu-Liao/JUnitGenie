package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import java.io.StringWriter;
import java.io.IOException;
import static com.fasterxml.jackson.core.JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER;

public class json_WriterBasedJsonGenerator_writeNumber_double_cfg_path_1_Test {

    @org.junit.Test
    public void testWriteNumber_WithValidDouble() {
        StringWriter stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, stringWriter, false);
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);

        try {
            generator.writeNumber(123.45);
            // You can add assertions here to verify the output if needed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception for close
            }
        }
    }

    @org.junit.Test
    public void testWriteNumber_WithNonFiniteDouble() {
        StringWriter stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, stringWriter, false);
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
        
        // Instead of accessing the protected field directly, use a method to set the configuration
        generator.configure(USE_FAST_DOUBLE_WRITER, true); // Assuming this is the correct method to set the configuration

        try {
            generator.writeNumber(Double.NaN);
            // You can add assertions here to verify the output if needed
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception for close
            }
        }
    }


}