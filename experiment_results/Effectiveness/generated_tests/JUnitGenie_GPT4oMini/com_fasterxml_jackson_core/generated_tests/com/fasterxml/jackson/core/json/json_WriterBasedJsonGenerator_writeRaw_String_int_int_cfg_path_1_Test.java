package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class json_WriterBasedJsonGenerator_writeRaw_String_int_int_cfg_path_1_Test {

    private WriterBasedJsonGenerator generator;
    private StringWriter writer;
    private IOContext context;
    private ObjectCodec codec;


    @Test(timeout = 4000)
    public void testWriteRaw() {
        String text = "Hello World";
        int offset = 0;
        int len = 5;

        try {
            generator.writeRaw(text, offset, len);
            assertEquals("Hello", writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void testWriteRawWithInvalidRange() throws IOException { // Declare IOException here
        String text = "Hello World";
        int offset = 0;
        int len = 20; // This should cause an IOException

        generator.writeRaw(text, offset, len); // No need for try-catch, JUnit will handle the exception
    }

}
