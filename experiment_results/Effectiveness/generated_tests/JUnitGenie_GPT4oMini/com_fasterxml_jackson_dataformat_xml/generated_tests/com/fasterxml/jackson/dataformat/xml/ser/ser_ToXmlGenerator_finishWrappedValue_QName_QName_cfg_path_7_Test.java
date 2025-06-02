package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class ser_ToXmlGenerator_finishWrappedValue_QName_QName_cfg_path_7_Test {


    @Test(timeout = 4000)
    public void testFinishWrappedValue_WithoutWrapperName() {
        // Arrange
        QName wrapperName = null;
        QName wrappedName = new QName("http://example.com", "wrapped");
        
        XMLStreamWriter2 mockWriter = mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, mockWriter, null);

        // Act
        try {
            generator.finishWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        // No exception should be thrown and nothing should be verified since wrapperName is null
    }



}
