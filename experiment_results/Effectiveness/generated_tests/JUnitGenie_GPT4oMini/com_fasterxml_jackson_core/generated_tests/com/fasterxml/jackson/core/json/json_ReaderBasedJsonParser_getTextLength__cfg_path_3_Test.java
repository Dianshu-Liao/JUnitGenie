package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_ReaderBasedJsonParser_getTextLength__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetTextLength() {
        IOContext ioContext = new IOContext(null, null, false); // Initialize properly with a context
        int features = 0;
        Reader reader = new StringReader("{\"field\":\"value\"}");
        ObjectCodec codec = null;
        CharsToNameCanonicalizer charsToNameCanonicalizer = CharsToNameCanonicalizer.createRoot();

        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(ioContext, features, reader, codec, charsToNameCanonicalizer);

        try {
            parser.nextToken();
            int length = parser.getTextLength();
            assertEquals(5, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetTextLengthWhenCurrTokenIsNull() {
        IOContext ioContext = new IOContext(null, null, false); // Initialize properly with a context
        int features = 0;
        Reader reader = new StringReader("{\"field\":\"value\"}");
        ObjectCodec codec = null;
        CharsToNameCanonicalizer charsToNameCanonicalizer = CharsToNameCanonicalizer.createRoot();

        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(ioContext, features, reader, codec, charsToNameCanonicalizer);

        try {
            parser.nextToken();
            parser.clearCurrentToken(); // This method should exist and be correctly implemented

            int length = parser.getTextLength();
            assertEquals(0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}