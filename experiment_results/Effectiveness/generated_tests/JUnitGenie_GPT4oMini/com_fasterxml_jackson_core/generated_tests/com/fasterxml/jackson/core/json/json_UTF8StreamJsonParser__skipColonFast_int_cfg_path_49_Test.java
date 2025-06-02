package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.*;

public class json_UTF8StreamJsonParser__skipColonFast_int_cfg_path_49_Test {

    @Test(timeout = 4000)
    public void testSkipColonFast() {
        // Setup
        byte[] inputBuffer = new byte[] {58, 32, 65}; // Example input buffer with a colon followed by space and 'A'
        IOContext ioContext = new IOContext(null, null, false); // Create an appropriate IOContext
        int features = 0; // Set any necessary features
        InputStream inputStream = new ByteArrayInputStream(inputBuffer); // Create an appropriate InputStream
        ObjectCodec codec = null; // Mock or create an appropriate ObjectCodec
        ByteQuadsCanonicalizer canonicalizer = ByteQuadsCanonicalizer.createRoot(); // Create an appropriate ByteQuadsCanonicalizer

        UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, features, inputStream, codec, canonicalizer, inputBuffer, 0, inputBuffer.length, false);

        // Accessing the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_skipColonFast", int.class);
            method.setAccessible(true);

            // Execute the method with a valid pointer
            int ptr = 0; // Starting pointer
            int result = (int) method.invoke(parser, ptr);

            // Verify the result
            assertEquals(65, result); // Expecting 'A' (ASCII 65) to be returned

        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            fail("Exception occurred while testing _skipColonFast: " + e.getMessage());
        }
    }


}