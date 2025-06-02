package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import javax.xml.namespace.QName;
import java.io.StringWriter;

public class ser_ToXmlGenerator_writeNumber_long_cfg_path_67_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;
    private QName nextName;


    @Test(timeout = 4000)
    public void testWriteNumberWithNullNextName() {
        try {
            toXmlGenerator.writeNumber(123L);
        } catch (IOException e) {
            // Handle the IOException
        }
    }


}
