package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCreateParserThrowsXMLStreamException() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = new byte[]{};
        int offset = 0;
        int len = 0;
        IOContext ctxt = new IOContext(null, null, false); // This line causes NullPointerException

        // Create a valid IOContext
        IOContext validCtxt = new IOContext(null, new ByteArrayInputStream(data), false);

        // Simulate the condition that causes XMLStreamException
        try {
            // Access the protected method using reflection
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            // Act
            method.invoke(xmlFactory, data, offset, len, validCtxt); // Use valid IOContext
            fail("Expected XMLStreamException to be thrown");
        } catch (NoSuchMethodException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        } catch (InvocationTargetException e) {
            // Check if the cause of the exception is XMLStreamException
            if (e.getCause() instanceof XMLStreamException) {
                // Assert
                assertNotNull(e.getCause());
            } else {
                fail("Expected XMLStreamException to be thrown, but got: " + e.getCause());
            }
        }
    }


}