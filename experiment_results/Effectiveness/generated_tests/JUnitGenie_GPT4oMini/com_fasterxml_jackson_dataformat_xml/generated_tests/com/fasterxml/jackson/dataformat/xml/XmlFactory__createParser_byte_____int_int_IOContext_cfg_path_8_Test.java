package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonParseException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.junit.Test;
import static org.junit.Assert.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.JsonFactory;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_8_Test {


    private XmlMapper invokeCreateParser(XmlFactory xmlFactory, byte[] data, int offset, int len, IOContext ctxt) throws Exception {
        // Use reflection to access the protected method
        java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
        method.setAccessible(true);
        return (XmlMapper) method.invoke(xmlFactory, data, offset, len, ctxt);
    }


}
