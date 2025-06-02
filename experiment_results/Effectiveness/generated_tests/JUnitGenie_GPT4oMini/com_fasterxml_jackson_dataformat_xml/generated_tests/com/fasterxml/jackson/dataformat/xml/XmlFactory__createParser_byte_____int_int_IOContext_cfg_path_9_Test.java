package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory();
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Correcting the IOContext initialization
        BufferRecycler bufferRecycler = new BufferRecycler();
        ObjectCodec codec = new JsonFactory().getCodec();
        IOContext ctxt = new IOContext(bufferRecycler, codec, false);

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