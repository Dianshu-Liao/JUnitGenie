package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import java.io.StringWriter;
import java.io.IOException;
import static com.fasterxml.jackson.core.JsonGenerator.Feature;

public class json_WriterBasedJsonGenerator_writeNumber_float_cfg_path_1_Test {

    @org.junit.Test
    public void testWriteNumberWithNonFiniteValue() {
        StringWriter writer = new StringWriter();
        IOContext context = new IOContext(null, writer, false);
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(context, 0, (ObjectCodec) null, writer);

        // Use a public method to set the configuration instead of accessing the protected field directly
        generator.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);

        try {
            generator.writeNumber(Float.NaN); // Testing with a non-finite value
            // Verify the output if necessary
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception if closing fails
            }
        }
    }

    @org.junit.Test
    public void testWriteNumberWithFiniteValue() {
        StringWriter writer = new StringWriter();
        IOContext context = new IOContext(null, writer, false);
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(context, 0, (ObjectCodec) null, writer);

        // Use a public method to set the configuration instead of accessing the protected field directly
        generator.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);

        try {
            generator.writeNumber(1.23f); // Testing with a finite value
            // Verify the output if necessary
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        } finally {
            try {
                generator.close(); // Ensure the generator is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception if closing fails
            }
        }
    }


}