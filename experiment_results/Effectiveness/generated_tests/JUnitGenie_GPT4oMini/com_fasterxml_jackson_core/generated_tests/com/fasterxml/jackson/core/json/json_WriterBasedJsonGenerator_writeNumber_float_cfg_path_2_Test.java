package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;

public class json_WriterBasedJsonGenerator_writeNumber_float_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteNumberWithFiniteFloat() {
        StringWriter stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, stringWriter, false);
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(ioContext, 0, (ObjectCodec) null, stringWriter);

        float finiteFloat = 1.23f; // A finite float value
        try {
            generator.writeNumber(finiteFloat);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNotFiniteFloat() {
        StringWriter stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, stringWriter, false);
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(ioContext, 0, (ObjectCodec) null, stringWriter);
        
        float notFiniteFloat = Float.NaN; // Not a finite float value
        // Instead of accessing the protected field directly, we can use a method to set the configuration
        generator.configure(WriterBasedJsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true); // Set the condition to trigger string writing
        try {
            generator.writeNumber(notFiniteFloat);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}