package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser__skipColonFast_int_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testSkipColonFast() throws Exception {
        // Setup
        byte[] inputBuffer = new byte[] {58, 32, 65}; // Example input buffer with a colon and space
        IOContext ioContext = new IOContext(null, null, false); // Create an appropriate IOContext
        int features = 0; // Set any necessary features
        InputStream inputStream = new ByteArrayInputStream(inputBuffer); // Create an appropriate InputStream
        ObjectCodec objectCodec = null; // Mock or create an appropriate ObjectCodec
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot(); // Create an appropriate ByteQuadsCanonicalizer

        UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, features, inputStream, objectCodec, byteQuadsCanonicalizer, inputBuffer, 0, inputBuffer.length, false);

        // Accessing the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
            method.setAccessible(true);

            // Execute the method with a valid pointer
            int result = (int) method.invoke(parser, 0);

            // Verify the result
            assertEquals(65, result); // Expecting the ASCII value of 'A' after the colon and space
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        } finally {
            parser.close(); // Ensure the parser is closed to avoid resource leaks
        }
    }

}