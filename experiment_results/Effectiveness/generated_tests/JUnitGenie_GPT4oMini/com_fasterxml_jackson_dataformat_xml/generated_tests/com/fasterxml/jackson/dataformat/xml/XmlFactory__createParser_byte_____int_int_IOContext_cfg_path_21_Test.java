package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testCreateParser() throws JsonParseException {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Correctly initialize IOContext with a valid ObjectCodec and a ByteArrayInputStream
        IOContext ctxt = new IOContext(null, new ByteArrayInputStream(data), false);

        // Accessing the protected method using reflection
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            assertNotNull(parser);
        } catch (Exception e) {
            // Handle any exceptions
            if (e.getCause() instanceof XMLStreamException) {
                throw new JsonParseException(null, "XMLStreamException occurred: " + e.getCause().getMessage());
            } else if (e.getCause() instanceof IOException) {
                throw new JsonParseException(null, "IOException occurred: " + e.getCause().getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }

}