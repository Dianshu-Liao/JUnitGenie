package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import org.junit.Before;
import org.junit.Test;
import java.io.StringWriter;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class json_WriterBasedJsonGenerator__writeFieldNameTail_SerializableString_cfg_path_1_Test {

    private WriterBasedJsonGenerator generator;
    private StringWriter writer;

    @Before
    public void setUp() {
        writer = new StringWriter();
        // Create a mock IOContext and ObjectCodec to avoid NullPointerException
        // Assuming IOContext and ObjectCodec are not needed for this test
        generator = new WriterBasedJsonGenerator(null, 0, null, writer);
    }

    private class TestSerializableString implements SerializableString {
        private final String value;

        public TestSerializableString(String value) {
            this.value = value;
        }

        @Override
        public byte[] asUnquotedUTF8() {
            return value.getBytes();
        }

        @Override
        public byte[] asQuotedUTF8() {
            return value.getBytes();
        }

        @Override
        public char[] asQuotedChars() {
            return value.toCharArray();
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public int charLength() {
            return value.length();
        }

        @Override
        public int appendQuoted(char[] buffer, int offset) {
            return 0; // Not needed for this test
        }

        @Override
        public int appendUnquoted(char[] buffer, int offset) {
            return 0; // Not needed for this test
        }

        @Override
        public int appendQuotedUTF8(byte[] buffer, int offset) {
            return 0; // Not needed for this test
        }

        @Override
        public int appendUnquotedUTF8(byte[] buffer, int offset) {
            return 0; // Not needed for this test
        }

        @Override
        public int putQuotedUTF8(java.nio.ByteBuffer buffer) {
            return 0; // Not needed for this test
        }

        @Override
        public int putUnquotedUTF8(java.nio.ByteBuffer buffer) {
            return 0; // Not needed for this test
        }

        @Override
        public int writeQuotedUTF8(java.io.OutputStream out) {
            return 0; // Not needed for this test
        }

        @Override
        public int writeUnquotedUTF8(java.io.OutputStream out) {
            return 0; // Not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testWriteFieldNameTail() {
        try {
            // Prepare a valid SerializableString
            TestSerializableString name = new TestSerializableString("testName");

            // Access the protected method using reflection
            Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeFieldNameTail", SerializableString.class);
            method.setAccessible(true);

            // Call the method
            method.invoke(generator, name);

            // Validate the output
            char[] expectedOutput = new char[] {'t', 'e', 's', 't', 'N', 'a', 'm', 'e', '"'};
            assertArrayEquals(expectedOutput, generator._outputBuffer);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

}