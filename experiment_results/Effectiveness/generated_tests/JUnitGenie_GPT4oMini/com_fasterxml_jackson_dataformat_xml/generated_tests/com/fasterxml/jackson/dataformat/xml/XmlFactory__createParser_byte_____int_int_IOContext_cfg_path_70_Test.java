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

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_70_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Correctly initialize IOContext with a valid ObjectCodec
        IOContext ctxt = new IOContext(xmlFactory._getBufferRecycler(), null, false);

        // Accessing the protected method using reflection
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            assertNotNull(parser);
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        } catch (java.lang.reflect.InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                fail("IOException occurred: " + cause.getMessage());
            } else {
                fail("Unexpected exception: " + cause.getMessage());
            }
        } catch (IllegalAccessException e) {
            fail("Method access failed: " + e.getMessage());
        }
    }


}