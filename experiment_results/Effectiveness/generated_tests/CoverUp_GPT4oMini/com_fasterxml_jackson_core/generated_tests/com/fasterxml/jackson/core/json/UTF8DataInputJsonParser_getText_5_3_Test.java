package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8DataInputJsonParser_getText_5_3_Test {

    private UTF8DataInputJsonParser parser;

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        ByteQuadsCanonicalizer symbols = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(null, null, true);
        DataInput inputData = new DataInput() {

            private final InputStream stream = new ByteArrayInputStream(new byte[] {});

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
                return 0;
            }

            @Override
            public int readUnsignedByte() throws IOException {
                return 0;
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
        parser = new UTF8DataInputJsonParser(ioContext, 0, inputData, null, symbols, 0);
        writer = new StringWriter();
    }

    @Test
    void testGetTextWithValueString() throws Exception {
        setFieldValue(parser, "_currToken", JsonToken.VALUE_STRING);
        setFieldValue(parser, "_tokenIncomplete", false);
        setFieldValue(parser, "_textBuffer", new TextBuffer(null));
        ((TextBuffer) getFieldValue(parser, "_textBuffer")).setCurrentLength(5);
        int length = parser.getText(writer);
        assertEquals(5, length);
        assertEquals("value", writer.toString());
    }

    @Test
    void testGetTextWithFieldName() throws Exception {
        setFieldValue(parser, "_currToken", JsonToken.FIELD_NAME);
        JsonReadContext context = new JsonReadContext(null, 0, null, 0, 0, 0);
        setFieldValue(parser, "_parsingContext", context);
        context.setCurrentName("fieldName");
        int length = parser.getText(writer);
        assertEquals(9, length);
        assertEquals("fieldName", writer.toString());
    }

    @Test
    void testGetTextWithNumericValue() throws Exception {
        setFieldValue(parser, "_currToken", JsonToken.VALUE_NUMBER_INT);
        setFieldValue(parser, "_textBuffer", new TextBuffer(null));
        ((TextBuffer) getFieldValue(parser, "_textBuffer")).setCurrentLength(3);
        int length = parser.getText(writer);
        assertEquals(3, length);
        assertEquals("123", writer.toString());
    }

    @Test
    void testGetTextWithNullToken() throws Exception {
        setFieldValue(parser, "_currToken", null);
        int length = parser.getText(writer);
        assertEquals(0, length);
        assertEquals("", writer.toString());
    }

    private void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
