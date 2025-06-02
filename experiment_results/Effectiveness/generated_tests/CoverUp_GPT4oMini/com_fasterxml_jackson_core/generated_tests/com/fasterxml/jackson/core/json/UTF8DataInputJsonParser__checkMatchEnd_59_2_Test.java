package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser__checkMatchEnd_59_2_Test {

    private UTF8DataInputJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private DataInput inputData;

    @BeforeEach
    public void setUp() {
        // Mock dependencies
        // Use the appropriate method to create an instance
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, null, null, null, false);
        inputData = new DataInput() {

            private final InputStream stream = new ByteArrayInputStream(new byte[0]);

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
                return stream.read() != 0;
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
                return (short) (stream.read() << 8 | stream.read());
            }

            @Override
            public int readUnsignedShort() throws IOException {
                return (stream.read() << 8 | stream.read());
            }

            @Override
            public char readChar() throws IOException {
                return (char) (stream.read() << 8 | stream.read());
            }

            @Override
            public int readInt() throws IOException {
                return (stream.read() << 24 | stream.read() << 16 | stream.read() << 8 | stream.read());
            }

            @Override
            public long readLong() throws IOException {
                return ((long) readInt() << 32) | (readInt() & 0xFFFFFFFFL);
            }

            @Override
            public float readFloat() throws IOException {
                return Float.intBitsToFloat(readInt());
            }

            @Override
            public double readDouble() throws IOException {
                return Double.longBitsToDouble(readLong());
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
        parser = new UTF8DataInputJsonParser(ioContext, 0, inputData, null, symbols, 0);
    }

    @Test
    public void testCheckMatchEnd_withInvalidCharacter() throws Exception {
        Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_checkMatchEnd", String.class, int.class, int.class);
        method.setAccessible(true);
        // Test with an invalid character that is a Java identifier part
        String matchStr = "test";
        // Position in the matched string
        int i = 2;
        // Invalid character '-' (not a Java identifier part)
        int ch = 0x2D;
        assertThrows(IOException.class, () -> {
            method.invoke(parser, matchStr, i, ch);
        });
    }

    @Test
    public void testCheckMatchEnd_withValidCharacter() throws Exception {
        Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_checkMatchEnd", String.class, int.class, int.class);
        method.setAccessible(true);
        // Test with a valid character that is a Java identifier part
        String matchStr = "test";
        // Position in the matched string
        int i = 2;
        // Valid character 'a' (a Java identifier part)
        int ch = 0x61;
        // This should not throw an exception
        method.invoke(parser, matchStr, i, ch);
    }
}
