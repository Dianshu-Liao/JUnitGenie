package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
// Import the Indenter class
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_indentArraysWith_0_2_Test {

    private DefaultXmlPrettyPrinter printer;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
    }

    @Test
    public void testIndentArraysWith_NullIndenter() throws Exception {
        Indenter expectedIndenter = new DefaultXmlPrettyPrinter.NopIndenter();
        // Act
        invokeIndentArraysWith(null);
        // Assert
        assertSame(expectedIndenter, getPrivateField("_arrayIndenter"));
    }

    @Test
    public void testIndentArraysWith_ValidIndenter() throws Exception {
        Indenter customIndenter = new DefaultXmlPrettyPrinter.FixedSpaceIndenter();
        // Act
        invokeIndentArraysWith(customIndenter);
        // Assert
        assertSame(customIndenter, getPrivateField("_arrayIndenter"));
    }

    private void invokeIndentArraysWith(Indenter indenter) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("indentArraysWith", Indenter.class);
        method.setAccessible(true);
        method.invoke(printer, indenter);
    }

    private Object getPrivateField(String fieldName) throws Exception {
        java.lang.reflect.Field field = DefaultXmlPrettyPrinter.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(printer);
    }
}
