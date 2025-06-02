package com.fasterxml.jackson.core.json;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.VersionUtil;

public class // Additional tests can be added here to cover edge cases and other branches
ByteSourceJsonBootstrapper_constructParser_3_0_Test {

    private ByteSourceJsonBootstrapper bootstrapper;

    @Mock
    private IOContext mockContext;

    @Mock
    private ObjectCodec mockCodec;

    @Mock
    private ByteQuadsCanonicalizer mockRootByteSymbols;

    @Mock
    private CharsToNameCanonicalizer mockRootCharSymbols;

    private InputStream inputStream;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        inputBuffer = new byte[8192];
        inputStream = new ByteArrayInputStream(inputBuffer);
        bootstrapper = new ByteSourceJsonBootstrapper(mockContext, inputStream);
    }

    @Test
    public void testConstructParserWithUTF8Encoding() throws IOException {
        // Arrange
        int parserFeatures = 0;
        int factoryFeatures = JsonFactory.Feature.CHARSET_DETECTION.getMask() | JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.getMask();
        when(mockRootByteSymbols.makeChild(factoryFeatures)).thenReturn(mockRootByteSymbols);
        // Act
        JsonParser parser = bootstrapper.constructParser(parserFeatures, mockCodec, mockRootByteSymbols, mockRootCharSymbols, factoryFeatures);
        // Assert
        assertNotNull(parser);
        assertTrue(parser instanceof UTF8StreamJsonParser);
    }

    @Test
    public void testConstructParserWithReaderBasedParser() throws IOException {
        // Arrange
        int parserFeatures = 0;
        // No charset detection or canonicalization
        int factoryFeatures = 0;
        // Act
        JsonParser parser = bootstrapper.constructParser(parserFeatures, mockCodec, mockRootByteSymbols, mockRootCharSymbols, factoryFeatures);
        // Assert
        assertNotNull(parser);
        assertTrue(parser instanceof ReaderBasedJsonParser);
    }

    @Test
    public void testConstructParserWithNullCodec() throws IOException {
        // Arrange
        int parserFeatures = 0;
        int factoryFeatures = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.getMask();
        when(mockRootByteSymbols.makeChild(factoryFeatures)).thenReturn(mockRootByteSymbols);
        // Act
        JsonParser parser = bootstrapper.constructParser(parserFeatures, null, mockRootByteSymbols, mockRootCharSymbols, factoryFeatures);
        // Assert
        assertNotNull(parser);
        assertTrue(parser instanceof UTF8StreamJsonParser);
    }

    @Test
    public void testConstructParserWithCharsetDetectionDisabled() throws IOException {
        // Arrange
        int parserFeatures = 0;
        // No charset detection or canonicalization
        int factoryFeatures = 0;
        // Act
        JsonParser parser = bootstrapper.constructParser(parserFeatures, mockCodec, mockRootByteSymbols, mockRootCharSymbols, factoryFeatures);
        // Assert
        assertNotNull(parser);
        assertTrue(parser instanceof ReaderBasedJsonParser);
    }

    @Test
    public void testConstructParserWithOnlyCanonicalizationEnabled() throws IOException {
        // Arrange
        int parserFeatures = 0;
        int factoryFeatures = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.getMask();
        when(mockRootByteSymbols.makeChild(factoryFeatures)).thenReturn(mockRootByteSymbols);
        // Act
        JsonParser parser = bootstrapper.constructParser(parserFeatures, mockCodec, mockRootByteSymbols, mockRootCharSymbols, factoryFeatures);
        // Assert
        assertNotNull(parser);
        assertTrue(parser instanceof UTF8StreamJsonParser);
    }
}
