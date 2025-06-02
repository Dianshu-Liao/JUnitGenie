package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class json_UTF8JsonGenerator_writeRawUTF8String_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteRawUTF8String() {
        // Setup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
        // Corrected the constructor call to include a valid buffer allocator
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream, new byte[]{'"'}, 0, false);
        
        byte[] text = "Hello".getBytes();
        int offset = 0;
        int len = text.length;

        try {
            // Execute
            generator.writeRawUTF8String(text, offset, len);
            generator.close(); // Close the generator to flush the output

            // Verify
            byte[] expectedOutput = new byte[] { '"', 'H', 'e', 'l', 'l', 'o', '"' };
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }


}