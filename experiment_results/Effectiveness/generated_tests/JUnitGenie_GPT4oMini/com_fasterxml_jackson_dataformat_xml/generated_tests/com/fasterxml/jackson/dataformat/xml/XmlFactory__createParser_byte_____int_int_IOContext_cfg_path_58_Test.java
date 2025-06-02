package com.fasterxml.jackson.dataformat.xml;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.util.BufferRecycler;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_58_Test {

    private XmlFactory xmlFactory;
    private IOContext ioContext;


    @Test(timeout = 4000)
    public void test_CreateParser_Success() throws Exception {
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        try {
            FromXmlParser parser = invokeCreateParser(data, offset, len, ioContext);
            assertNotNull(parser);
        } catch (IOException e) {
            fail("Expected no IOException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void test_CreateParser_XmlStreamException() throws Exception {
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;

        // Mock the XMLInputFactory to throw an XMLStreamException
        XMLInputFactory mockInputFactory = Mockito.mock(XMLInputFactory.class);
        Mockito.when(mockInputFactory.createXMLStreamReader(Mockito.any(ByteArrayInputStream.class)))
               .thenThrow(new XMLStreamException("Mocked XMLStreamException"));

        // Use reflection to set the protected field _xmlInputFactory
        setField(xmlFactory, "_xmlInputFactory", mockInputFactory);
        
        try {
            invokeCreateParser(data, offset, len, ioContext);
            fail("Expected JsonParseException not thrown");
        } catch (JsonParseException e) {
            // Expected exception
        }
    }

    private FromXmlParser invokeCreateParser(byte[] data, int offset, int len, IOContext ctxt) throws Exception {
        // Use reflection to access the protected method
        return (FromXmlParser) XmlFactory.class
            .getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class)
            .invoke(xmlFactory, data, offset, len, ctxt); // Removed setAccessible(true) as it is not needed here
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

}
