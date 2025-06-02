package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeBoolean_boolean_cfg_path_53_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;


    @Test(timeout = 4000)
    public void testWriteBoolean() {
        boolean value = true;

        try {
            toXmlGenerator.writeBoolean(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteBooleanWithMissingName() {
        // Set _nextName to null to trigger handleMissingName
        try {
            toXmlGenerator.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
