package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class json_ReaderBasedJsonParser__closeInput__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCloseInputWhenReaderIsNull() {
        try {
            // Arrange
            IOContext ioContext = new IOContext(null, null, false); // Provide a valid IOContext
            Reader reader = null; // _reader is null
            ObjectCodec objectCodec = null; // Assuming a valid ObjectCodec is provided
            CharsToNameCanonicalizer charsToNameCanonicalizer = CharsToNameCanonicalizer.createRoot(); // Provide a valid CharsToNameCanonicalizer
            
            ReaderBasedJsonParser parser = new ReaderBasedJsonParser(ioContext, 0, reader, objectCodec, charsToNameCanonicalizer);

            // Act
            Method closeInputMethod = ReaderBasedJsonParser.class.getDeclaredMethod("_closeInput");
            closeInputMethod.setAccessible(true);
            closeInputMethod.invoke(parser);

            // Assert
            // Since _reader is null, we expect no exception and _reader should remain null
            assertNull(parser.getClass().getDeclaredField("_reader").get(parser));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}