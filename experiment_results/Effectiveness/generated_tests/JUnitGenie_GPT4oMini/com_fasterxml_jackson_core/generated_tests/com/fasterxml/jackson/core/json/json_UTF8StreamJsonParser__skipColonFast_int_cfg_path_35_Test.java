package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser__skipColonFast_int_cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testSkipColonFast() throws IOException {
        // Setup
        byte[] inputBuffer = new byte[] {58, 32, 65}; // Example input buffer with a colon and space followed by 'A'
        IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
        int features = 0; // Assuming default features
        InputStream inputStream = new ByteArrayInputStream(inputBuffer); // Create a valid InputStream from the byte array
        ObjectCodec objectCodec = null; // Assuming a valid ObjectCodec is provided
        ByteQuadsCanonicalizer byteQuadsCanonicalizer = ByteQuadsCanonicalizer.createRoot(); // Create a valid ByteQuadsCanonicalizer

        UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, features, inputStream, objectCodec, byteQuadsCanonicalizer, inputBuffer, 0, inputBuffer.length, false);

        // Accessing the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(parser, 0); // Invoke with pointer at 0

            // Verify the result
            assertEquals(65, result); // Expecting 'A' (ASCII 65) to be returned
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}