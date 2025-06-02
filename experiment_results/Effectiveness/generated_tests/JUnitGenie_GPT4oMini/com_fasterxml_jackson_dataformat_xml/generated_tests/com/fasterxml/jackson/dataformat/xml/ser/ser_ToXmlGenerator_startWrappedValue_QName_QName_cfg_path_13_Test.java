package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class ser_ToXmlGenerator_startWrappedValue_QName_QName_cfg_path_13_Test {
    private XMLStreamWriter2 mockXMLStreamWriter;
    private ToXmlGenerator generator;


    @Test(timeout = 4000)
    public void testStartWrappedValue_WithNullWrapperName_ThenDoesNotThrow() throws IOException {
        QName wrappedName = new QName("namespace", "localPart");
        generator.startWrappedValue(null, wrappedName);
    }

}
