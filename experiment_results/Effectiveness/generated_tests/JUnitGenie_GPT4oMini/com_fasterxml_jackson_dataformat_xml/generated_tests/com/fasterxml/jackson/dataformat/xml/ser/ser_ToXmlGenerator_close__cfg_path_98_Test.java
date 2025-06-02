package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class ser_ToXmlGenerator_close__cfg_path_98_Test {



    private Object getWriteContext(ToXmlGenerator generator) {
        try {
            return generator.getClass().getSuperclass().getDeclaredField("_writeContext").get(generator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
