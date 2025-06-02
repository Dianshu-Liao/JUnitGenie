package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.dataformat.xml.deser.ElementWrapper;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.junit.Assert.*;

public class deser_XmlTokenStream__handleRepeatElement__cfg_path_1_Test {


    private int invokeHandleRepeatElement(XmlTokenStream xmlTokenStream) throws XMLStreamException {
        try {
            java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_handleRepeatElement");
            method.setAccessible(true);
            return (int) method.invoke(xmlTokenStream);
        } catch (Exception e) {
            throw new XMLStreamException("Failed to invoke _handleRepeatElement", e);
        }
    }


}
