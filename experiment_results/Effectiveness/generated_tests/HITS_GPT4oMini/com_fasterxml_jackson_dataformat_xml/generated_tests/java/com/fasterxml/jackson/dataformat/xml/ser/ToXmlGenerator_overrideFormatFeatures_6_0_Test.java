// Adjust this package name as necessary
package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
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
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_overrideFormatFeatures_6_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        xmlStreamWriter = Mockito.mock(XMLStreamWriter.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlStreamWriter, null);
    }

    @Test
    public void testOverrideFormatFeatures_UpdatesFormatFeatures() {
        // Example initial format feature
        int initialFormatFeatures = 0b0001;
        toXmlGenerator.overrideFormatFeatures(initialFormatFeatures, 0b0001);
        assertEquals(initialFormatFeatures, toXmlGenerator._formatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_MasksAndUpdatesCorrectly() {
        // Example initial format features
        int initialFormatFeatures = 0b0110;
        toXmlGenerator._formatFeatures = initialFormatFeatures;
        // New values to set
        int newValues = 0b0001;
        // Mask to apply
        int mask = 0b0010;
        toXmlGenerator.overrideFormatFeatures(newValues, mask);
        // Expecting updated features
        assertEquals(0b0111, toXmlGenerator._formatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_NoChangeWhenSameValues() {
        // Example initial format features
        int initialFormatFeatures = 0b0101;
        toXmlGenerator._formatFeatures = initialFormatFeatures;
        // Same as initial
        int newValues = 0b0101;
        // Mask to apply
        int mask = 0b1111;
        toXmlGenerator.overrideFormatFeatures(newValues, mask);
        // No change expected
        assertEquals(initialFormatFeatures, toXmlGenerator._formatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_UpdatesOnlyMaskedBits() {
        // Initial features
        int initialFormatFeatures = 0b1111;
        toXmlGenerator._formatFeatures = initialFormatFeatures;
        // No new values
        int newValues = 0b0000;
        // Mask to apply
        int mask = 0b0101;
        toXmlGenerator.overrideFormatFeatures(newValues, mask);
        // Only masked bits should change
        assertEquals(0b1100, toXmlGenerator._formatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_DoesNotChangeWhenNoMask() {
        // Initial features
        int initialFormatFeatures = 0b0011;
        toXmlGenerator._formatFeatures = initialFormatFeatures;
        // No new values
        int newValues = 0b0000;
        // No mask
        int mask = 0b0000;
        toXmlGenerator.overrideFormatFeatures(newValues, mask);
        // No change expected
        assertEquals(initialFormatFeatures, toXmlGenerator._formatFeatures);
    }
}
