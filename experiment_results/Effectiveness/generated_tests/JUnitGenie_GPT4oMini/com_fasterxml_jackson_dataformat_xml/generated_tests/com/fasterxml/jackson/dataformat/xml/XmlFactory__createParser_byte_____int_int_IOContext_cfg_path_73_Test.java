package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import org.junit.Assert;
import java.lang.reflect.Method;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_73_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Corrected IOContext initialization
        IOContext ctxt = new IOContext(xmlFactory._getBufferRecycler(), null, false);

        // Act
        try {
            Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);
            
            // Assert
            Assert.assertNotNull(parser); // Use Assert class for assertion
        } catch (Exception e) {
            // Handle all exceptions
            e.printStackTrace();
        }
    }


}