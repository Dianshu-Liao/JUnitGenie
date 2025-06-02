package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeBinary_Base64Variant_byte_____int_int_cfg_path_77_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;
    private Base64Variant base64Variant;


    @Test(timeout = 4000)
    public void testWriteBinary_withValidData() {
        byte[] data = new byte[]{1, 2, 3, 4, 5};
        int offset = 0;
        int len = data.length;

        try {
            toXmlGenerator.writeBinary(base64Variant, data, offset, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteBinary_withNullData() {
        byte[] data = null;
        int offset = 0;
        int len = 0;

        try {
            toXmlGenerator.writeBinary(base64Variant, data, offset, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
