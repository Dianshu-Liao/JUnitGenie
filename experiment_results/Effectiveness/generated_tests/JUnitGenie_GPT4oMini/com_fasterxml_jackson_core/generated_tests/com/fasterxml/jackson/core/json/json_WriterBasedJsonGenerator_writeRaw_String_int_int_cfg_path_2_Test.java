package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Before;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_WriterBasedJsonGenerator_writeRaw_String_int_int_cfg_path_2_Test {

    private WriterBasedJsonGenerator generator;
    private StringWriter writer;

    @Before
    public void setUp() {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, writer, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, (ObjectCodec) null, writer);
    }

    @Test(timeout = 4000)
    public void testWriteRaw_WithSufficientRoom() {
        try {
            String text = "Hello, World!";
            int offset = 0;
            int len = 13; // Length of the string
            // Setting _outputEnd to sufficient space
            generator._outputEnd = 20;
            generator._outputTail = 0;

            generator.writeRaw(text, offset, len);
            assertEquals("Hello, World!", writer.toString());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteRaw_WithInsufficientRoom() {
        try {
            String text = "Hello, World!";
            int offset = 0;
            int len = 13; // Length of the string
            // Setting _outputEnd to insufficient space
            generator._outputEnd = 5; // Less than len
            generator._outputTail = 0;

            generator.writeRaw(text, offset, len);
            assertEquals("Hello, World!", writer.toString());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void testWriteRaw_WithInvalidRange() throws IOException {
        String text = "Hello, World!";
        int offset = 0;
        int len = 100; // Exceeding length

        generator.writeRaw(text, offset, len); // This should throw an IOException
    }

}