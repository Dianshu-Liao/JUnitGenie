package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_67_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false); // Ensure the parameters are valid

        // Act
        try {
            // Corrected the type from XmlMapper to XmlParser
            Object parser = invokeCreateParser(xmlFactory, data, offset, len, ctxt);
            assertNotNull(parser);
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    private Object invokeCreateParser(XmlFactory xmlFactory, byte[] data, int offset, int len, IOContext ctxt) throws Exception {
        // Use reflection to access the protected method
        java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
        method.setAccessible(true);
        return method.invoke(xmlFactory, data, offset, len, ctxt);
    }

}