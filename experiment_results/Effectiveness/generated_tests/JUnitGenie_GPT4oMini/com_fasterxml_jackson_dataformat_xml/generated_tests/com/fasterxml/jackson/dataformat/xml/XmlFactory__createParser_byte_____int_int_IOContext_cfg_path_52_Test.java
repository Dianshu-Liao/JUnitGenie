package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.BufferRecycler;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_52_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Prepare test data
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Create an instance of XmlFactory
        XmlFactory xmlFactory = new XmlFactory();

        // Prepare the IOContext instance
        BufferRecycler bufferRecycler = new BufferRecycler();
        ObjectCodec codec = new JsonFactory().getCodec();
        IOContext ioContext = new IOContext(bufferRecycler, codec, true); // Fixed the constructor

        try {
            // Use reflection to access the protected method _createParser
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);

            // Invoke the method
            Object result = method.invoke(xmlFactory, data, offset, len, ioContext);

            // Check the result is not null and is of type FromXmlParser
            assertNotNull(result);
            assertTrue(result instanceof com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}