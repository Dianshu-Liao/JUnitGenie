package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_long_cfg_path_2_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;
    private QName nextName;



    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }


}
