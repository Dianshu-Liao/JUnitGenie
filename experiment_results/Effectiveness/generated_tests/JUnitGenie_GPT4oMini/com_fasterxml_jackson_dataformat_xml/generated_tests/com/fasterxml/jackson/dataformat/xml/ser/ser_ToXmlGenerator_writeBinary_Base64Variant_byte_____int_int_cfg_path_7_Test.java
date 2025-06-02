package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeBinary_Base64Variant_byte_____int_int_cfg_path_7_Test {
    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 mockXmlWriter;
    private Base64Variant mockBase64Variant;


    @Test(timeout = 4000)
    public void testWriteBinaryWithNullData() throws IOException, XMLStreamException {
        byte[] nullData = null;
        int offset = 0;
        int len = 0;

        // Call the method under test
        try {
            toXmlGenerator.writeBinary(mockBase64Variant, nullData, offset, len);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        verify(mockXmlWriter, never()).writeBinary(any(), any(), anyInt(), anyInt());
    }

}
