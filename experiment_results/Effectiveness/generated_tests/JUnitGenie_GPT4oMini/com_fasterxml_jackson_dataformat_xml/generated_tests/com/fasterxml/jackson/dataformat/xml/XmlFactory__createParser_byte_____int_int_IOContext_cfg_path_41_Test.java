package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Test;
import javax.xml.stream.XMLInputFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_41_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Create a proper IOContext with a valid ObjectCodec and a ByteArrayInputStream
        IOContext ctxt = new IOContext(null, new ByteArrayInputStream(data), false); 

        XmlFactory xmlFactory = new XmlFactory(XMLInputFactory.newInstance()); // Instantiate XmlFactory

        // Act
        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            Object result = method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            assertNotNull(result);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }


}