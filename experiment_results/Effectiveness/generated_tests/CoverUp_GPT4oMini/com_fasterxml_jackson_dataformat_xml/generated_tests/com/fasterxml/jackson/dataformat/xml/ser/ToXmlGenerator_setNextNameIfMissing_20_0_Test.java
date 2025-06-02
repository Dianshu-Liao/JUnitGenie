package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_setNextNameIfMissing_20_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private IOContext ioContext;

    private int stdFeatures;

    private int xmlFeatures;

    private ObjectCodec codec;

    private XMLStreamWriter xmlStreamWriter;

    private XmlNameProcessor xmlNameProcessor;

    @BeforeEach
    public void setUp() {
        ioContext = Mockito.mock(IOContext.class);
        stdFeatures = 0;
        xmlFeatures = 0;
        codec = Mockito.mock(ObjectCodec.class);
        xmlStreamWriter = Mockito.mock(XMLStreamWriter.class);
        xmlNameProcessor = Mockito.mock(XmlNameProcessor.class);
        toXmlGenerator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, xmlNameProcessor);
    }

    @Test
    public void testSetNextNameIfMissing_WhenNextNameIsNull_ShouldSetNextName() {
        QName name = new QName("testNamespace", "testLocalPart");
        boolean result = toXmlGenerator.setNextNameIfMissing(name);
        assertTrue(result);
        // Use reflection to access the private field _nextName
        QName nextName = (QName) getPrivateField(toXmlGenerator, "_nextName");
        assertEquals(name, nextName);
    }

    @Test
    public void testSetNextNameIfMissing_WhenNextNameIsNotNull_ShouldNotSetNextName() {
        QName initialName = new QName("initialNamespace", "initialLocalPart");
        // Set initial name
        toXmlGenerator.setNextName(initialName);
        QName newName = new QName("newNamespace", "newLocalPart");
        boolean result = toXmlGenerator.setNextNameIfMissing(newName);
        assertFalse(result);
        // Use reflection to access the private field _nextName
        QName nextName = (QName) getPrivateField(toXmlGenerator, "_nextName");
        // _nextName should still be the initial name
        assertEquals(initialName, nextName);
    }

    private Object getPrivateField(Object obj, String fieldName) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
