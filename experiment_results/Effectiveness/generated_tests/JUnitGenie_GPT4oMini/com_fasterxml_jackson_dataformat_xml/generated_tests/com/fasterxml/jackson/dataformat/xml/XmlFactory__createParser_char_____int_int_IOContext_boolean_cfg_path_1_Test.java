package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_char_____int_int_IOContext_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;

        // Create an instance of IOContext with a valid ObjectCodec
        IOContext ctxt = new IOContext(null, null, false);
        boolean recycleBuffer = false;

        // Create an instance of XmlFactory
        XmlFactory xmlFactory = new XmlFactory();
        try {
            // Access the protected method _createParser using reflection
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", char[].class, int.class, int.class, IOContext.class, boolean.class);
            method.setAccessible(true);

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt, recycleBuffer);

            // Assert
            assertNotNull(parser);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
            fail("An exception was thrown: " + e.getMessage());
        }
    }


}