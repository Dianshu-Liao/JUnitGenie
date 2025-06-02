package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class util_DefaultPrettyPrinter_withRootSeparator_SerializableString_cfg_path_6_Test {

    private class TestSerializableString implements SerializableString {
        private final String value;

        public TestSerializableString(String value) {
            this.value = value;
        }

        @Override
        public int appendQuotedUTF8(byte[] b, int offset) {
            // Implementation not needed for this test
            return 0;
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
        public int writeUnquotedUTF8(java.io.OutputStream out) {
            // Implementation not needed for this test
            return 0;
        }

        @Override
        public int putQuotedUTF8(java.nio.ByteBuffer bb) {
            // Implementation not needed for this test
            return 0;
        }

        @Override
        public int putUnquotedUTF8(java.nio.ByteBuffer bb) {
            // Implementation not needed for this test
            return 0;
        }

        @Override
        public int appendUnquoted(char[] c, int offset) {
            // Implementation not needed for this test
            return 0;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public int writeQuotedUTF8(java.io.OutputStream out) {
            // Implementation not needed for this test
            return 0;
        }

        @Override
        public int appendUnquotedUTF8(byte[] b, int offset) {
            // Implementation not needed for this test
            return 0;
        }

        @Override
        public int charLength() {
            return value.length();
        }

        @Override
        public byte[] asUnquotedUTF8() {
            return value.getBytes();
        }

        @Override
        public int appendQuoted(char[] c, int offset) {
            // Implementation not needed for this test
            return 0;
        }
    }

    @Test(timeout = 4000)
    public void testWithRootSeparator() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        TestSerializableString rootSeparator = new TestSerializableString("rootSeparator");

        // Set the _rootSeparator to a different value to test the condition
        printer._rootSeparator = new TestSerializableString("differentSeparator");

        DefaultPrettyPrinter result = printer.withRootSeparator(rootSeparator);

        // Verify that the returned object is the same as the original printer
        assertSame(printer, result);
    }

}