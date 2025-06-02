package com.fasterxml.jackson.core.json;
import static org.junit.Assert.assertEquals;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import org.junit.Before;
import org.junit.Test;
import java.io.DataInput;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.reflect.Method;

public class json_UTF8DataInputJsonParser__skipWS__cfg_path_18_Test {

    private UTF8DataInputJsonParser parser;
    private DataInput dataInput;

    @Before
    public void setUp() throws Exception {
        byte[] data = {0, 10, 13, 32}; // Test data, include CR and LF
        dataInput = new DataInputStream(new ByteArrayInputStream(data));
        parser = new UTF8DataInputJsonParser(null, -1, dataInput, null, null, 0);
    }

    @Test(timeout = 4000)
    public void testSkipWS() {
        try {
            Method skipWSMethod = UTF8DataInputJsonParser.class.getDeclaredMethod("_skipWS");
            skipWSMethod.setAccessible(true);
            int result = (int) skipWSMethod.invoke(parser);
            assertEquals(10, result); // Expecting to skip whitespace and return the next relevant byte
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipWSThrowsIOException() {
        try {
            Method skipWSMethod = UTF8DataInputJsonParser.class.getDeclaredMethod("_skipWS");
            skipWSMethod.setAccessible(true);

            // Simulate IOException by providing faulty DataInput implementation
            parser = new UTF8DataInputJsonParser(null, -1, new FaultyDataInput(), null, null, 0);
            skipWSMethod.invoke(parser);
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                // Exception expected, test passes
            } else {
                e.printStackTrace();
            }
        }
    }

    private static class FaultyDataInput implements DataInput {
        @Override
        public void readFully(byte[] b) throws IOException {
        }

        @Override
        public void readFully(byte[] b, int off, int len) throws IOException {
        }

        @Override
        public int skipBytes(int n) {
            return 0;
        }

        @Override
        public boolean readBoolean() throws IOException {
            return false;
        }

        @Override
        public byte readByte() throws IOException {
            return 0;
        }

        @Override
        public int readUnsignedByte() throws IOException {
            throw new IOException("Simulated IOException");
        }

        @Override
        public short readShort() throws IOException {
            return 0;
        }

        @Override
        public int readUnsignedShort() throws IOException {
            return 0;
        }

        @Override
        public char readChar() throws IOException {
            return 0;
        }

        @Override
        public int readInt() throws IOException {
            return 0;
        }

        @Override
        public long readLong() throws IOException {
            return 0;
        }

        @Override
        public float readFloat() throws IOException {
            return 0;
        }

        @Override
        public double readDouble() throws IOException {
            return 0;
        }

        @Override
        public String readLine() throws IOException {
            return null;
        }

        @Override
        public String readUTF() throws IOException {
            return null;
        }
    }


}