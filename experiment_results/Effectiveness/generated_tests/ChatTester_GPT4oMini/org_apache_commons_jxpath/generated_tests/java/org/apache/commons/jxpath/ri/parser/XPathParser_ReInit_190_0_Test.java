package org.apache.commons.jxpath.ri.parser;

import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

@ExtendWith(MockitoExtension.class)
public class XPathParser_ReInit_190_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager mockTokenManager;

    private InputStream mockInputStream;

    @BeforeEach
    public void setUp() {
        mockTokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(mockTokenManager);
        mockInputStream = mock(InputStream.class);
    }

    @Test
    public void testReInit() throws Exception {
        // Arrange
        Token mockToken = mock(Token.class);
        when(mockTokenManager.getNextToken()).thenReturn(mockToken);
        // Act
        parser.ReInit(mockInputStream);
        // Assert
        assertNotNull(parser.jj_input_stream);
        assertEquals(mockInputStream, parser.jj_input_stream.inputStream);
        assertNotNull(parser.token_source);
        assertNotNull(parser.token);
        assertNotNull(parser.jj_nt);
        assertSame(mockToken, parser.jj_nt);
        // Accessing private fields using reflection
        Field jj_genField = XPathParser.class.getDeclaredField("jj_gen");
        jj_genField.setAccessible(true);
        assertEquals(0, jj_genField.getInt(parser));
        Field jj_la1Field = XPathParser.class.getDeclaredField("jj_la1");
        jj_la1Field.setAccessible(true);
        int[] jj_la1 = (int[]) jj_la1Field.get(parser);
        for (int i = 0; i < jj_la1.length; i++) {
            assertEquals(-1, jj_la1[i]);
        }
        Field jj_2_rtnsField = XPathParser.class.getDeclaredField("jj_2_rtns");
        jj_2_rtnsField.setAccessible(true);
        Object[] jj_2_rtns = (Object[]) jj_2_rtnsField.get(parser);
        for (int i = 0; i < jj_2_rtns.length; i++) {
            assertNotNull(jj_2_rtns[i]);
        }
    }
}
