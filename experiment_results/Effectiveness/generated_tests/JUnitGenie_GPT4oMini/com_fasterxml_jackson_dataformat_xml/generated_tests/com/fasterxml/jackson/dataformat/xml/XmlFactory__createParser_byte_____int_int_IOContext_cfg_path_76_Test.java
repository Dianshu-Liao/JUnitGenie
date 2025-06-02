package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_76_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false);

        // Accessing the protected method using reflection
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            assertNotNull(parser);
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserThrowsException() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = new byte[0]; // Empty data to trigger exception
        int offset = 0;
        int len = 0;
        IOContext ctxt = new IOContext(null, null, false);

        // Accessing the protected method using reflection
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);
            fail("Expected an IOException to be thrown");
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            // Handle the exception as expected
            assertTrue(e.getCause() instanceof IOException);
        }
    }


}