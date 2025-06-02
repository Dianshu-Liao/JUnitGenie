// Test method
package com.fasterxml.jackson.dataformat.xml.ser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class ToXmlGenerator_isEnabled_10_0_Test {

    private ToXmlGenerator toXmlGenerator;

    // Mock dependencies
    private IOContext mockContext;

    private ObjectCodec mockCodec;

    private XMLStreamWriter mockXmlWriter;

    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    public void setUp() {
        mockContext = Mockito.mock(IOContext.class);
        mockCodec = Mockito.mock(ObjectCodec.class);
        mockXmlWriter = Mockito.mock(XMLStreamWriter.class);
        mockNameProcessor = Mockito.mock(XmlNameProcessor.class);
        // Assuming default values for features
        toXmlGenerator = new ToXmlGenerator(mockContext, 0, 0, mockCodec, mockXmlWriter, mockNameProcessor);
    }

    @Test
    public void testIsEnabled_FeatureEnabled() {
        // Set _formatFeatures to a value that enables the feature
        // Assuming the mask for the feature is 1
        setFormatFeatures(1);
        ToXmlGenerator.Feature feature = mock(ToXmlGenerator.Feature.class);
        when(feature.getMask()).thenReturn(1);
        assertTrue(toXmlGenerator.isEnabled(feature));
    }

    @Test
    public void testIsEnabled_FeatureDisabled() {
        setFormatFeatures(0);
        ToXmlGenerator.Feature feature = mock(ToXmlGenerator.Feature.class);
        when(feature.getMask()).thenReturn(1);
        assertFalse(toXmlGenerator.isEnabled(feature));
    }

    @Test
    public void testIsEnabled_MultipleFeatures() {
        setFormatFeatures(3);
        ToXmlGenerator.Feature feature1 = mock(ToXmlGenerator.Feature.class);
        when(feature1.getMask()).thenReturn(1);
        ToXmlGenerator.Feature feature2 = mock(ToXmlGenerator.Feature.class);
        when(feature2.getMask()).thenReturn(2);
        assertTrue(toXmlGenerator.isEnabled(feature1));
        assertTrue(toXmlGenerator.isEnabled(feature2));
    }

    private void setFormatFeatures(int features) {
        try {
            java.lang.reflect.Field formatFeaturesField = ToXmlGenerator.class.getDeclaredField("_formatFeatures");
            formatFeaturesField.setAccessible(true);
            formatFeaturesField.setInt(toXmlGenerator, features);
        } catch (Exception e) {
            fail("Failed to set _formatFeatures via reflection: " + e.getMessage());
        }
    }
}
