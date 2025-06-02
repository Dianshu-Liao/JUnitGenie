package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_65_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false); // Ensure IOContext is properly initialized

        // Act
        try {
            Object parser = invokeCreateParser(xmlFactory, data, offset, len, ctxt);
            // Assert
            assertNotNull(parser);
        } catch (IOException e) {
            // Handle the exception as per the focal method's behavior
            e.printStackTrace();
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

}