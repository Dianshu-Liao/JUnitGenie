package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Before;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_WriterBasedJsonGenerator_writeString_char_____int_int_cfg_path_2_Test {
    private WriterBasedJsonGenerator generator;
    private StringWriter writer;

    @Before
    public void setUp() {
        writer = new StringWriter();
        IOContext context = new IOContext(null, null, false);
        generator = new WriterBasedJsonGenerator(context, 0, (ObjectCodec) null, writer);
        generator._outputTail = 0; // Initialize _outputTail
        generator._outputEnd = 100; // Set a value greater than _outputTail
        generator._outputBuffer = new char[100]; // Initialize _outputBuffer
        generator._quoteChar = '"'; // Set a quote character
    }

    @Test(timeout = 4000)
    public void testWriteString() {
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;

        try {
            generator.writeString(text, offset, len);
            String expectedOutput = "\"Hello\""; // Expected output with quotes
            assertEquals(expectedOutput, writer.toString());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}