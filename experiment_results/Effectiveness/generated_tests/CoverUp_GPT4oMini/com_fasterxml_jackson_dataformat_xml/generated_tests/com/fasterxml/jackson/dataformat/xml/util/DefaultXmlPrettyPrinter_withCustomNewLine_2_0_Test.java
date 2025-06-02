package com.fasterxml.jackson.dataformat.xml.util;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_withCustomNewLine_2_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    @BeforeEach
    public void setUp() throws Exception {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        // Set a default value for SYSTEM_DEFAULT_NEW_LINE using reflection
        setSystemDefaultNewLine("\n");
    }

    @Test
    public void testWithCustomNewLine_NullInput() throws Exception {
        prettyPrinter.withCustomNewLine(null);
        assertEquals(getSystemDefaultNewLine(), prettyPrinter._newLine);
    }

    @Test
    public void testWithCustomNewLine_ValidInput() {
        String customNewLine = "\n";
        prettyPrinter.withCustomNewLine(customNewLine);
        assertEquals(customNewLine, prettyPrinter._newLine);
    }

    @Test
    public void testWithCustomNewLine_EmptyString() {
        prettyPrinter.withCustomNewLine("");
        assertEquals("", prettyPrinter._newLine);
    }

    @Test
    public void testWithCustomNewLine_Spaces() {
        String customNewLine = "   ";
        prettyPrinter.withCustomNewLine(customNewLine);
        assertEquals(customNewLine, prettyPrinter._newLine);
    }

    private String getSystemDefaultNewLine() throws Exception {
        Field field = DefaultXmlPrettyPrinter.class.getDeclaredField("SYSTEM_DEFAULT_NEW_LINE");
        field.setAccessible(true);
        return (String) field.get(null);
    }

    private void setSystemDefaultNewLine(String newLine) throws Exception {
        Field field = DefaultXmlPrettyPrinter.class.getDeclaredField("SYSTEM_DEFAULT_NEW_LINE");
        field.setAccessible(true);
        field.set(null, newLine);
    }
}
