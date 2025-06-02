package com.fasterxml.jackson.dataformat.xml.deser;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.dataformat.xml.deser.ElementWrapper;
import javax.xml.stream.XMLStreamReader;

public class deser_XmlTokenStream__handleEndElement__cfg_path_2_Test {
    private XmlTokenStream xmlTokenStream;
    private ElementWrapper elementWrapper;



    private void setField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private Object getField(Object target, String fieldName) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }


}
