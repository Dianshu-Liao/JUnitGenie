package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonParseException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_40_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false);

        // Act
        try {
            Object parser = invokeCreateParser(xmlFactory, data, offset, len, ctxt);
            assertNotNull(parser);
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserThrowsJsonParseException() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = new byte[0]; // This will cause an exception
        int offset = 0;
        int len = 0;
        IOContext ctxt = new IOContext(null, null, false);

        // Act
        try {
            invokeCreateParser(xmlFactory, data, offset, len, ctxt);
            fail("Expected JsonParseException to be thrown");
        } catch (JsonParseException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        }
    }

    private Object invokeCreateParser(XmlFactory xmlFactory, byte[] data, int offset, int len, IOContext ctxt) throws IOException {
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            return method.invoke(xmlFactory, data, offset, len, ctxt);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _createParser method", e);
        }
    }

    // Fix for NullPointerException in IOContext constructor
    private IOContext createIOContext() {
        // Create a proper IOContext with a valid resource
        return new IOContext(null, new ByteArrayInputStream(new byte[0]), false);
    }

}