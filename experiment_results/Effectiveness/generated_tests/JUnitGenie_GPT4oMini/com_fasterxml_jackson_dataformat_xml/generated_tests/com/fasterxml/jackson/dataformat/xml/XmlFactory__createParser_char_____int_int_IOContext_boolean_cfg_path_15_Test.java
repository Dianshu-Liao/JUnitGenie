package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_char_____int_int_IOContext_boolean_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;

        // Corrected IOContext initialization
        BufferRecycler bufferRecycler = new BufferRecycler(); // Create a BufferRecycler instance
        IOContext ctxt = new IOContext(bufferRecycler, null, false); // Use the BufferRecycler in the constructor

        boolean recycleBuffer = false;

        // Act
        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", char[].class, int.class, int.class, IOContext.class, boolean.class);
            method.setAccessible(true);
            Object result = method.invoke(xmlFactory, data, offset, len, ctxt, recycleBuffer);

            // Assert
            assertNotNull(result);
            assertTrue(result instanceof com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser);
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }


}