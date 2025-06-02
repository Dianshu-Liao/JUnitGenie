package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.stream.XMLStreamReader;
import java.lang.reflect.Method;

public class deser_XmlTokenStream__decodeElementName_String_String_cfg_path_3_Test {


    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }


}
