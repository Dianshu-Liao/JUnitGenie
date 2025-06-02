package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class ser_ToXmlGenerator_writeNumber_long_cfg_path_41_Test {

    private XMLStreamWriter2 mockXmlWriter;
    private ToXmlGenerator toXmlGenerator;


    @Test(timeout = 4000)
    public void testWriteNumberWithNullNextName() {
        try {
            toXmlGenerator.writeNumber(123L);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }


}
