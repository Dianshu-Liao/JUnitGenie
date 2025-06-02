package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
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

public class ToXmlGenerator_overrideFormatFeatures_6_2_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter mockXmlWriter;

    @BeforeEach
    public void setUp() {
        mockXmlWriter = Mockito.mock(XMLStreamWriter.class);
        generator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
    }

    @Test
    public void testOverrideFormatFeatures_ChangesFormat() {
        // Arrange
        // Set feature 1
        generator.overrideFormatFeatures(0b0001, 0b0001);
        int initialFormatFeatures = generator.getFormatFeatures();
        // Act
        // Change feature 1 to feature 2
        generator.overrideFormatFeatures(0b0010, 0b0001);
        int updatedFormatFeatures = generator.getFormatFeatures();
        // Assert
        assertNotEquals(initialFormatFeatures, updatedFormatFeatures);
        assertEquals(0b0010, updatedFormatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_NoChange() {
        // Arrange
        // Set feature 1
        generator.overrideFormatFeatures(0b0001, 0b0001);
        int initialFormatFeatures = generator.getFormatFeatures();
        // Act
        // No change
        generator.overrideFormatFeatures(0b0001, 0b0001);
        int updatedFormatFeatures = generator.getFormatFeatures();
        // Assert
        assertEquals(initialFormatFeatures, updatedFormatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_MultipleChanges() {
        // Arrange
        // Set feature 1
        generator.overrideFormatFeatures(0b0001, 0b0001);
        // Set feature 2
        generator.overrideFormatFeatures(0b0010, 0b0010);
        // Act
        // Change feature 1
        generator.overrideFormatFeatures(0b0011, 0b0001);
        int updatedFormatFeatures = generator.getFormatFeatures();
        // Assert
        assertEquals(0b0011, updatedFormatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_ZeroMask() {
        // Arrange
        // Set feature 1 with zero mask
        generator.overrideFormatFeatures(0b0001, 0b0000);
        int initialFormatFeatures = generator.getFormatFeatures();
        // Act
        // No change
        generator.overrideFormatFeatures(0b0010, 0b0000);
        int updatedFormatFeatures = generator.getFormatFeatures();
        // Assert
        assertEquals(initialFormatFeatures, updatedFormatFeatures);
    }

    @Test
    public void testOverrideFormatFeatures_NegativeMask() {
        // Arrange
        // Set feature 1
        generator.overrideFormatFeatures(0b0001, 0b1111);
        int initialFormatFeatures = generator.getFormatFeatures();
        // Act
        // Clear all features
        generator.overrideFormatFeatures(0b0000, 0b1111);
        int updatedFormatFeatures = generator.getFormatFeatures();
        // Assert
        assertNotEquals(initialFormatFeatures, updatedFormatFeatures);
        assertEquals(0b0000, updatedFormatFeatures);
    }
}
