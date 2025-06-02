package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_ReaderBasedJsonParser_getTextLength__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetTextLengthWhenCurrTokenIsNull() {
        // Arrange
        IOContext ioContext = new IOContext(null, null, false);
        Reader reader = new StringReader("");
        CharsToNameCanonicalizer canonicalizer = CharsToNameCanonicalizer.createRoot();
        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(ioContext, 0, reader, null, canonicalizer);

        // Act
        int length = 0;
        try {
            length = parser.getTextLength();
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(0, length);
    }


}