package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Correctly initialize IOContext with a valid BufferRecycler
        IOContext ctxt = new IOContext(new BufferRecycler(), new JsonFactory().getCodec(), false);

        // Accessing the protected method using reflection
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);

            // Act
            Object parser = method.invoke(xmlFactory, data, offset, len, ctxt);

            // Assert
            assertNotNull(parser);
        } catch (Exception e) {
            // Handle any exceptions
            fail("Exception occurred: " + e.getMessage());
        }
    }

}