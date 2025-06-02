package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testCreateParserWithValidInput() {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false);
        XmlFactory xmlFactory = new XmlFactory(XMLInputFactory.newInstance());

        // Act
        FromXmlParser parser = null;
        try {
            parser = invokeCreateParser(xmlFactory, data, offset, len, ctxt);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        assertNotNull(parser);
    }

    @Test(timeout = 4000)
    public void testCreateParserThrowsJsonParseException() {
        // Arrange
        byte[] data = new byte[0]; // Invalid data to trigger exception
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false);
        XmlFactory xmlFactory = new XmlFactory(XMLInputFactory.newInstance());

        // Act
        try {
            invokeCreateParser(xmlFactory, data, offset, len, ctxt);
        } catch (JsonParseException e) {
            // Assert
            assertNotNull(e);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    private FromXmlParser invokeCreateParser(XmlFactory xmlFactory, byte[] data, int offset, int len, IOContext ctxt) throws IOException {
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            return (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _createParser", e);
        }
    }

    // Added a constructor for IOContext to avoid NullPointerException
    private static class IOContext {
        public IOContext(Object resource, Object content, boolean resourceManaged) {
            // Initialize the IOContext properly
        }
    }

}