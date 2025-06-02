package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamWriter;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

class ser_ToXmlGenerator_writeEndObject__cfg_path_2_Test {
    private boolean inObject;

    // Constructor should be defined as a class, not a method
    public ser_ToXmlGenerator_writeEndObject__cfg_path_2_Test(boolean inObject) {
        this.inObject = inObject;
    }

    public boolean inObject() {
        return inObject;
    }


}