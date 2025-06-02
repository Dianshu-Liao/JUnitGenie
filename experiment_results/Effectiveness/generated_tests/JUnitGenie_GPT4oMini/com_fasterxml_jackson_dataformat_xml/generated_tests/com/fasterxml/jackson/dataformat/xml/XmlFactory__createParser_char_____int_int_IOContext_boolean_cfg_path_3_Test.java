package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.CharArrayReader;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_char_____int_int_IOContext_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCreateParserWithValidInput() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false); // This line is fine
        boolean recycleBuffer = false;

        // Act
        try {
            FromXmlParser parser = (FromXmlParser) invokeCreateParser(xmlFactory, data, offset, len, ctxt, recycleBuffer);
            assertNotNull(parser);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserThrowsException() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        char[] data = null; // This will cause an exception
        int offset = 0;
        int len = 0;
        IOContext ctxt = new IOContext(null, null, false); // This line is fine
        boolean recycleBuffer = false;

        // Act
        try {
            invokeCreateParser(xmlFactory, data, offset, len, ctxt, recycleBuffer);
            fail("Expected IOException was not thrown");
        } catch (IOException e) {
            // Expected exception
        }
    }

    private Object invokeCreateParser(XmlFactory xmlFactory, char[] data, int offset, int len, IOContext ctxt, boolean recycleBuffer) throws IOException {
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", char[].class, int.class, int.class, IOContext.class, boolean.class);
            method.setAccessible(true);
            return method.invoke(xmlFactory, data, offset, len, ctxt, recycleBuffer);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _createParser", e);
        }
    }

}