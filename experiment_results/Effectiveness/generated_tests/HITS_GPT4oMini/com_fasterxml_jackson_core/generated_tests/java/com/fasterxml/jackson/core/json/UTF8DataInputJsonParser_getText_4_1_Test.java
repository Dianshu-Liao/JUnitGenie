package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser_getText_4_1_Test {

    private TestUTF8DataInputJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private DataInput inputData;

    @BeforeEach
    public void setUp() {
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, true);
        inputData = new DataInput() {

            private final InputStream stream = new ByteArrayInputStream("\"test string\"".getBytes());

            @Override
            public void readFully(byte[] b) throws IOException {
                stream.read(b);
            }

            @Override
            public void readFully(byte[] b, int off, int len) throws IOException {
                stream.read(b, off, len);
            }

            @Override
            public int skipBytes(int n) throws IOException {
                return (int) stream.skip(n);
            }

            @Override
            public boolean readBoolean() throws IOException {
                return false;
            }

            @Override
            public byte readByte() throws IOException {
                return (byte) stream.read();
            }

            @Override
            public int readUnsignedByte() throws IOException {
                return stream.read();
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
        };
        parser = new TestUTF8DataInputJsonParser(ioContext, 0, inputData, symbols, 0);
    }

    private static class TestUTF8DataInputJsonParser extends UTF8DataInputJsonParser {

        public TestUTF8DataInputJsonParser(IOContext ctxt, int features, DataInput inputData, ByteQuadsCanonicalizer sym, int firstByte) {
            super(ctxt, features, inputData, null, sym, firstByte);
        }

        public void setCurrToken(JsonToken token) {
            try {
                java.lang.reflect.Field field = UTF8DataInputJsonParser.class.getDeclaredField("_currToken");
                field.setAccessible(true);
                field.set(this, token);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testGetTextWithValueStringAndIncompleteToken() throws IOException {
        parser.setCurrToken(JsonToken.VALUE_STRING);
        parser._tokenIncomplete = true;
    }
}
