package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import org.codehaus.stax2.XMLStreamReader2;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.stream.XMLStreamException;
import java.lang.reflect.Method;

public class deser_XmlTokenStream__handleRepeatElement__cfg_path_3_Test {



    private void setField(XmlTokenStream xmlTokenStream, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(xmlTokenStream, value);
    }


}
