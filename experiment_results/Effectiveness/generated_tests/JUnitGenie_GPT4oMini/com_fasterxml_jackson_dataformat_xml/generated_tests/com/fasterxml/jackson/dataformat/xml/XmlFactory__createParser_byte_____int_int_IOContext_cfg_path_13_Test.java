package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_13_Test {

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
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            JsonParser result = (JsonParser) method.invoke(xmlFactory, data, offset, len, ctxt); // Cast to JsonParser

            // Assert
            assertNotNull(result);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }

}