package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
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

public class UTF8StreamJsonParser_currentTokenLocation_102_0_Test {

    private class TestUTF8StreamJsonParser extends UTF8StreamJsonParser {

        public TestUTF8StreamJsonParser(ByteQuadsCanonicalizer symbols, IOContext ioContext) {
            super(ioContext, 0, null, null, symbols, null, 0, 0, false);
        }

        public void setCurrToken(JsonToken token) {
            this._currToken = token;
        }

        public void setCurrInputProcessed(long processed) {
            this._currInputProcessed = processed;
        }

        public void setNameStartOffset(int offset) {
            this._nameStartOffset = offset;
        }

        public void setNameStartRow(int row) {
            this._nameStartRow = row;
        }

        public void setNameStartCol(int col) {
            this._nameStartCol = col;
        }

        public void setTokenInputTotal(long total) {
            this._tokenInputTotal = total;
        }

        public void setTokenInputRow(int row) {
            this._tokenInputRow = row;
        }

        public void setTokenInputCol(int col) {
            this._tokenInputCol = col;
        }
    }

    private TestUTF8StreamJsonParser parser;

    @BeforeEach
    public void setUp() {
        ByteQuadsCanonicalizer symbols = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(null, null, true);
        parser = new TestUTF8StreamJsonParser(symbols, ioContext);
    }

    @Test
    public void testCurrentTokenLocation_FieldName() {
        parser.setCurrToken(JsonToken.FIELD_NAME);
        parser.setNameStartOffset(5);
        parser.setNameStartRow(2);
        parser.setNameStartCol(3);
        parser.setCurrInputProcessed(10);
        JsonLocation location = parser.currentTokenLocation();
        assertEquals(14, location.getCharOffset());
        assertEquals(2, location.getLineNr());
        assertEquals(3, location.getColumnNr());
    }

    @Test
    public void testCurrentTokenLocation_OtherToken() {
        parser.setCurrToken(JsonToken.VALUE_STRING);
        parser.setTokenInputTotal(20);
        parser.setTokenInputRow(1);
        parser.setTokenInputCol(5);
        JsonLocation location = parser.currentTokenLocation();
        assertEquals(19, location.getCharOffset());
        assertEquals(1, location.getLineNr());
        assertEquals(5, location.getColumnNr());
    }
}
