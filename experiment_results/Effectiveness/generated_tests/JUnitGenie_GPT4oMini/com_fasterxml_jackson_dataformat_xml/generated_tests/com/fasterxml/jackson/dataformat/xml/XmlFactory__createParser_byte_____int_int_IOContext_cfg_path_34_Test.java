package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertNotNull;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_34_Test {

    private class XmlFactoryAccessor extends XmlFactory {
        public XmlFactoryAccessor() {
            super();
        }

        protected FromXmlParser createParser(byte[] data, int offset, int len, IOContext ctxt) throws IOException {
            return super._createParser(data, offset, len, ctxt);
        }
    }




}
