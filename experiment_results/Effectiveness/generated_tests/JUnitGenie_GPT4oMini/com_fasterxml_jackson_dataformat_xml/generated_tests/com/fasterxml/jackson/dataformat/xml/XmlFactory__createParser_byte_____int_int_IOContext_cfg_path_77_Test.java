package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonFactory;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_77_Test {

    @org.junit.Test
    public void testCreateParser() {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        
        // Create a JsonFactory to pass to IOContext
        JsonFactory jsonFactory = new JsonFactory();
        IOContext ctxt = new IOContext(jsonFactory._getBufferRecycler(), null, false); // Use JsonFactory to create IOContext

        XmlFactory xmlFactory = new XmlFactory();
        // Use reflection to access the protected method
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            org.junit.Assert.assertNotNull(parser);
        } catch (Exception e) {
            // Handle all exceptions
            e.printStackTrace();
        }
    }


}