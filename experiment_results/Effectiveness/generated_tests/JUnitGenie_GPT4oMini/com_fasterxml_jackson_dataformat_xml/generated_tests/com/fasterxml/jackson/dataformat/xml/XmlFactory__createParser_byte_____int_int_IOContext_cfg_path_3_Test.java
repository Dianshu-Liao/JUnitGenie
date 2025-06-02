package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonFactory;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_3_Test {

    @org.junit.Test
    public void testCreateParser() {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        JsonFactory jsonFactory = new JsonFactory(); // Create a JsonFactory instance
        IOContext ctxt = new IOContext(jsonFactory._getBufferRecycler(), null, false); // Use JsonFactory to create IOContext
        XmlFactory xmlFactory = new XmlFactory(); // Instantiate XmlFactory

        // Accessing the protected method _createParser using reflection
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true); // Make the method accessible

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            org.junit.Assert.assertNotNull(parser);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }


}