package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Correctly initializing IOContext with a valid BufferRecycler and ObjectCodec
        BufferRecycler bufferRecycler = new BufferRecycler();
        ObjectCodec codec = new JsonFactory().getCodec();
        IOContext ctxt = new IOContext(bufferRecycler, codec, false);

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
            e.printStackTrace();
        }
    }

}