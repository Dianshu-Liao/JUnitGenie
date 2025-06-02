package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class util_TokenBuffer_writeString_SerializableString_cfg_path_1_Test {

    private class TestSerializableString implements SerializableString {
        private final String value;

        public TestSerializableString(String value) {
            this.value = value;
        }

        @Override
        public int appendQuotedUTF8(byte[] buffer, int offset) {
            // Implementation for testing purposes
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
            return 0;
        }

        @Override
        public int putQuotedUTF8(java.nio.ByteBuffer buffer) {
            return 0;
        }

        @Override
        public int putUnquotedUTF8(java.nio.ByteBuffer buffer) {
            return 0;
        }

        @Override
        public int appendUnquoted(char[] buffer, int offset) {
            return 0;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public int writeQuotedUTF8(java.io.OutputStream out) {
            return 0;
        }

        @Override
        public int appendUnquotedUTF8(byte[] buffer, int offset) {
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
        public int appendQuoted(char[] buffer, int offset) {
            return 0;
        }
    }

    @Test(timeout = 4000)
    public void testWriteString() {
        TokenBuffer tokenBuffer = new TokenBuffer(null, false);
        TestSerializableString testString = new TestSerializableString("test");

        try {
            tokenBuffer.writeString(testString);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

}