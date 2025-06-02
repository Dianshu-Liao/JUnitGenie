package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonParseException;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_53_Test {

    @Test(timeout = 4000)
    public void testCreateParser() throws JsonParseException { // Declare JsonParseException
        // Given
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Create an instance of IOContext with a valid input stream
        IOContext ctxt = new IOContext(null, new ByteArrayInputStream(data), false);
        
        // Create an instance of XmlFactory
        XmlFactory xmlFactory = new XmlFactory();

        // When
        try {
            // Accessing the protected _createParser using reflection
            Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true); // Allow access to the protected method
            Object result = method.invoke(xmlFactory, data, offset, len, ctxt);
            
            // Then
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the case for any exceptions, including reflection-related exceptions
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