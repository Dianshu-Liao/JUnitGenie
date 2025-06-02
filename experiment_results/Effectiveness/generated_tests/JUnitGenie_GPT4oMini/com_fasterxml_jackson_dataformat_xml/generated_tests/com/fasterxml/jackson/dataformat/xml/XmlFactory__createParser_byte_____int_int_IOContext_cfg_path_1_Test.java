package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_1_Test {

    @org.junit.Test
    public void testCreateParser() {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false); // Using a simple constructor for IOContext
        XmlFactory xmlFactory = new XmlFactory(); // Instantiate XmlFactory

        // Accessing the protected method using reflection
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true); // Make the method accessible

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            org.junit.Assert.assertNotNull(parser);
        } catch (NullPointerException e) {
            org.junit.Assert.fail("NullPointerException occurred: " + e.getMessage());
        } catch (Exception e) {
            // Handle general exceptions
            org.junit.Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

}