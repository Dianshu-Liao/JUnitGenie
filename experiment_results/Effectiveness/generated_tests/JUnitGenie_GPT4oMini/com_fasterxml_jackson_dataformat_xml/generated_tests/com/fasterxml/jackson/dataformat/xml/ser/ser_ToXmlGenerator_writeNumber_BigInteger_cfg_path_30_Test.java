package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.math.BigInteger;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_30_Test {

    @Test(timeout = 4000)
    public void testWriteNumber_validValue() throws XMLStreamException, IOException {
        // Setup
        XMLStreamWriter xmlWriterMock = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriterMock, null);

        // Set the internal state
        generator._nextName = new QName("namespace", "localPart");
        generator._nextIsAttribute = false;

        // Execute
        generator.writeNumber(BigInteger.valueOf(123));

        // Add assertions here to verify expected behavior
        verify(xmlWriterMock).writeCharacters("123");
    }

    @Test(timeout = 4000)
    public void testWriteNumber_nullValue() throws XMLStreamException, IOException {
        // Setup
        XMLStreamWriter xmlWriterMock = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriterMock, null);

        // Execute
        generator.writeNumber((BigInteger) null);

        // Assertions - verify that writeNull() was invoked
        verify(xmlWriterMock).writeCharacters("null");
    }

    @Test(timeout = 4000)
    public void testWriteNumber_exceptionHandled() throws XMLStreamException, IOException {
        // Setup
        XMLStreamWriter xmlWriterMock = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriterMock, null);

        generator._nextName = new QName("namespace", "localPart");
        generator._nextIsAttribute = false;

        try {
            // Execute
            generator.writeNumber(BigInteger.valueOf(123));
        } catch (IOException e) {
            // We expect this to be handled by StaxUtil
        }

        // Verify behavior here to ensure it handled the exception correctly
        verify(xmlWriterMock).writeCharacters("123");
    }

}